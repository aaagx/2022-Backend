package com.example.concerto.controller;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.Express;
import com.example.concerto.pojo.UserToken;
import com.example.concerto.service.CourierServiceImpl;
import com.example.concerto.service.ExpressService;
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
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    CourierServiceImpl courierService;
    @Autowired
    ExpressService expressService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("courierNo")int courierNo, @RequestParam("realName")String realName, @RequestParam("tel")String tel, @RequestParam("idCardNo")String idCardNo, @RequestParam("password")String password) {
        Courier ifExit1 = courierService.getCourierInfoByTel(tel);
        if (ifExit1 != null){
            return "该号码已注册";
        }
        Courier ifExit2 = courierService.getCourierInfoByCourierNo((int)courierNo);
        if (ifExit2 != null){
            return "该工号已注册";
        }
        Courier courier = new Courier();
        String salt = SaltUtil.getSalt(8);
        courier.setCourierNo(courierNo);
        courier.setRealName(realName);
        courier.setTel(tel);
        courier.setIdCardNo(idCardNo);
        courier.setSalt(salt);
        Md5Hash MD5 = new Md5Hash(password,salt,1024);
        courier.setPassword(MD5.toHex());
        courierService.register(courier);
        return "快递员注册成功";
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
            System.out.println("快递员["+tel+"]登录成功*****************");
            model.addAttribute("userTel", tel);
            //登录成功，跳转xxx.html
            return "快递员登录成功";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","快递员账号不存在");
            return "快递员账号不存在";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","快递员密码错误");
            return "快递员密码错误";
        }
    }

    /**
     * 快递员获取所有已经指派给自己但未接单的快递
     * 1:未指派 2:待接单 3:派送中 4:已送达未取件 5:用户取件
     * @param
     * @return
     */
    @RequestMapping("/getToBeDeliveredExpress")
    public CommonResponse getToBeDeliveredExpress(){
        Subject subject = SecurityUtils.getSubject();
        Courier user=(Courier) subject.getPrincipal();
        if(user==null)
            return null;
        Integer courierNo=user.getCourierNo();
        int status = 2;
        List<Express> expressList = expressService.getExpressListByCourierNoAndStatus(courierNo, status);
        System.out.println(expressList.size());
        return new CommonResponse(200,"成功",expressList);
    }
    @RequestMapping("/getDeliveredExpress")
    public CommonResponse getDeliveredExpress(){
        Subject subject = SecurityUtils.getSubject();
        Courier user=(Courier) subject.getPrincipal();
        if(user==null)
            return null;
        Integer courierNo=user.getCourierNo();
        int status = 3;
        List<Express> expressList = expressService.getExpressListByCourierNoAndStatus(courierNo, status);
        System.out.println(expressList.size());
        return new CommonResponse(200,"成功",expressList);
    }

    /**
     * 快递员取件 快递改为派送中
     * @param expressNo
     * @return
     */
    @RequestMapping("/doCourierPickUpExpress")
    public CommonResponse doCourierPickUpExpress(@RequestParam("expressNo")int expressNo){
        Express express = new Express();
        express.setExpressNo(expressNo);
        express.setStatus(3);
        expressService.updateExpressByPojo(express);
        return new CommonResponse(200,"成功",null);
    }

    /**
     * 快递员确认已送达 将快递状态修改为 已送达用户未取件状态
     * @param expressNo
     * @return
     */
    @RequestMapping("/doConfirmDeliverExpress")
    public CommonResponse doConfirmDeliverExpress(@RequestParam("expressNo")int expressNo){
        Express express = new Express();
        express.setExpressNo(expressNo);
        express.setStatus(4);
        expressService.updateExpressByPojo(express);
        return new CommonResponse(200,"成功",null);
    }
    /**
     * 快递员信息
     */
    @RequestMapping("/info")
    public Courier info(){
        Subject subject = SecurityUtils.getSubject();
        Courier user=(Courier) subject.getPrincipal();
        user.setPassword(null);
        user.setSalt(null);
        return user;
    }


}
