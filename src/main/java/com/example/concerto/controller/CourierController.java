package com.example.concerto.controller;

import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.UserToken;
import com.example.concerto.service.CourierServiceImpl;
import com.example.concerto.utils.SaltUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    CourierServiceImpl courierService;

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

}
