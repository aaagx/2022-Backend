package com.example.concerto.controller;
import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.*;
import com.example.concerto.service.*;
import com.example.concerto.utils.SaltUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerServiceImpl managerService;
    @Autowired
    CourierService courierService;
    @Autowired
    StationManagerService stationManagerService;
    @Autowired
    StationCourierServiceImpl stationCourierService;
    @Autowired
    CourierExpressService courierExpressService;
    @Autowired
    ExpressService expressService;
    @Autowired
    StationExpressService stationExpressService;
    @Autowired
    StationService stationService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("managerNo")int managerNo,@RequestParam("account")String account,@RequestParam("name")String name,@RequestParam("tel")String tel,@RequestParam("password")String password){
        Manager ifExit1 = managerService.getManagerInfoByTel(tel);
        if (ifExit1 != null){
            return "该号码已注册";
        }
        Manager ifExit2 = managerService.getManagerInfoByManagerNo(managerNo);
        if (ifExit2 != null){
            return "该工号已注册";
        }
        Manager manager = new Manager();
        String salt = SaltUtil.getSalt(8);
        manager.setAccount(account);
        manager.setManagerNo(managerNo);
        manager.setName(name);
        manager.setTel(tel);
        manager.setSalt(salt);
        Md5Hash MD5 = new Md5Hash(password,salt,1024);
        manager.setPassword(MD5.toHex());
        managerService.register(manager);
        return "管理员注册成功";
    }


    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("tel")String tel, @RequestParam("password")String password, @RequestParam("loginType")String loginType, Model model){
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        UserToken token = new UserToken(tel, password, loginType);
        try {
            subject.login(token);
            //只要没有异常，则登录成功；有异常则登录失败
            System.out.println("用户["+tel+"]登录成功*****************");
            model.addAttribute("userTel", tel);
            //登录成功，跳转xxx.html
            return "管理员登录成功";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","管理员账号不存在");
            return "管理员账号不存在";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","管理员密码错误");
            return "管理员密码错误";
        }
    }

    /**
     * 管理员新增一个快递员
     * 同是新增快递员与快递站的联系
     * @param realName
     * @param tel
     * @param idCardNo
     * @param password
     * @return
     */

    @RequestMapping("/addCourier")
    public CommonResponse addCourier(@RequestParam("realName")String realName,@RequestParam("tel")String tel,@RequestParam("idCardNo")String idCardNo,@RequestParam("password")String password){
        try{
            Subject subject = SecurityUtils.getSubject();
            Manager user=(Manager) subject.getPrincipal();
            Integer managerNo=user.getManagerNo();

            Courier ifExit = courierService.getCourierInfoByTel(tel);
            if (ifExit != null){
                return new CommonResponse(400,"该号码已注册",null);
            }
            Courier courier = new Courier();
            String salt = SaltUtil.getSalt(8);
            courier.setRealName(realName);
            courier.setTel(tel);
            courier.setIdCardNo(idCardNo);
            courier.setSalt(salt);
            Md5Hash MD5 = new Md5Hash(password,salt,1024);
            courier.setPassword(MD5.toHex());
            courierService.register(courier);
            int stationNo;
            stationNo = stationManagerService.getStationNoByManagerNo(managerNo);
            StationCourier stationCourier = new StationCourier();
            stationCourier.setStationNo(stationNo);
            stationCourier.setCourierNo(courier.getCourierNo());
            stationCourierService.insertStationCourier(stationCourier);
            return new CommonResponse(200,"成功",null);
        }catch (Exception e){
            System.out.println(e);
            return new CommonResponse(400,"失败",null);
        }
    }

    /**
     * 管理员删除一个快递员
     * 同是删除快递员和管理站点的联系 以及快递员和快递的联系
     * @param courierNo
     * @return
     */
    @RequestMapping("/deleteCourier")
    public CommonResponse deleteCourier(@RequestParam("courierNo")int courierNo){
        try{
            courierService.deleteCourierInfoByCourierNo(courierNo);
            StationCourier stationCourier = new StationCourier();
            stationCourier.setCourierNo(courierNo);
            stationCourierService.deleteStationCourierByStationCourier(stationCourier);
            CourierExpress courierExpress = new CourierExpress();
            courierExpress.setCourierNo(courierNo);
            courierExpressService.deleteCourierExpressInfo(courierExpress);
            return new CommonResponse(200,"成功",null);
        }catch (Exception e){
            return new CommonResponse(400,"失败",null);
        }
    }

    /**
     * 获取该站点下的所有快递员的信息
     * @return
     */
    @RequestMapping("/getCouriers")
    public CommonResponse getCouriers(){
        try {
            Subject subject = SecurityUtils.getSubject();
            Manager user=(Manager) subject.getPrincipal();
            Integer managerNo=user.getManagerNo();
            int stationNo;
            stationNo = stationManagerService.getStationNoByManagerNo(managerNo);
            List<Courier> courierList = courierService.getCourierListByStationNo(stationNo);
            return new CommonResponse(200,"成功",courierList);
        }catch (Exception e){
            return new CommonResponse(400,"失败",null);
        }
    }

    @RequestMapping("/getAllCouriers")
    public CommonResponse getAllCouriers(){
        try {

            List<Courier> courierList = courierService.getCourierListByPojo(new Courier());
            return new CommonResponse(200,"成功",courierList);
        }catch (Exception e){
            return new CommonResponse(400,"失败",null);
        }
    }


    /**
     * 将快递分配给一个快递员
     * 同时修改快递的状态
     * @param expressNo
     * @param courierNo
     * @return
     */
    @RequestMapping("/allotExpressToCourier")
    public CommonResponse allotExpressToCourier(@RequestParam("expressNo")int expressNo,@RequestParam("courierNo")int courierNo){
        try{
            CourierExpress courierExpress = new CourierExpress();
            courierExpress.setCourierNo(courierNo);
            courierExpress.setExpressNo(expressNo);
            courierExpressService.insertCourierExpressInfo(courierExpress);
            Express express = new Express();
            express.setStatus(2);
            express.setExpressNo(expressNo);
            expressService.updateExpressByPojo(express);
            return new CommonResponse(200,"成功",null);
        }catch (Exception e){
            return new CommonResponse(400,"失败",null);
        }
    }

    /**
     * 管理员删除一条快递
     * 同时删除 快递与管理员 快递与快递站
     * @param expressNo
     * @return
     */
    @RequestMapping("deleteExpress")
    public CommonResponse deleteExpress(@RequestParam("expressNo")int expressNo){
        try{
            expressService.deleteExpressByExpressNo(expressNo);

            CourierExpress courierExpress = new CourierExpress();
            courierExpress.setExpressNo(expressNo);
            courierExpressService.deleteCourierExpressInfo(courierExpress);

            StationExpress stationExpress = new StationExpress();
            stationExpress.setExpressNo(expressNo);
            stationExpressService.deleteStationExpressByStationExpress(stationExpress);
            return new CommonResponse(200,"成功",null);
        }catch (Exception e){
            return new CommonResponse(400,"失败",null);
        }
    }

    /**
     * 管理员新增一个快递
     * @param expressCompany
     * @param productLink
     * @param senderTel
     * @param recipientTel
     * @param senderName
     * @param recipientName
     * @param senderAddress
     * @param recipientAddress
     * @return
     */
    @RequestMapping("/addExpress")
    public CommonResponse addExpress(@RequestParam("expressCompany")String expressCompany,
                                     @RequestParam("productLink")String productLink,
                                     @RequestParam("senderTel")String senderTel,
                                     @RequestParam("recipientTel")String recipientTel,
                                     @RequestParam("senderName")String senderName,
                                     @RequestParam("recipientName")String recipientName,
                                     @RequestParam("senderAddress")String senderAddress,
                                     @RequestParam("recipientAddress")String recipientAddress){
        try {
            Express express = new Express();
            express.setExpressCompany(expressCompany);
            express.setProductLink(productLink);
            express.setSenderTel(senderTel);
            express.setRecipientTel(recipientTel);
            express.setSenderName(senderName);
            express.setRecipientName(recipientName);
            express.setSenderAddress(senderAddress);
            express.setRecipientAddress(recipientAddress);
            express.setStatus(1);
            expressService.insertExpressByPojo(express);
            return new CommonResponse(200,"成功",null);
        }catch (Exception e){
            return new CommonResponse(400,"失败",null);
        }
    }

    @RequestMapping("/getStationListByCourier")
    @ResponseBody
    public List<Station> getStationListByCourier(Model model,@RequestBody List<Courier> courierList){

        return stationService.getStationListByCourier(courierList);
    }
    @RequestMapping("/getExpress")
    @ResponseBody
    public List<Express> getExpress(){
        Subject subject = SecurityUtils.getSubject();
        Manager user=(Manager) subject.getPrincipal();
        Integer managerNo=user.getManagerNo();
        Integer stationNo = stationManagerService.getStationNoByManagerNo(managerNo);
        return expressService.getExpressListByStationNo(stationNo);
    }
}
