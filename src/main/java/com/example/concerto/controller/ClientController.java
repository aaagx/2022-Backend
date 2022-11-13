package com.example.concerto.controller;

import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.UserToken;
import com.example.concerto.service.ClientServiceImpl;
import com.example.concerto.utils.SaltUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(String tel,String nickname,String realName,String idCardNo,String password,String address){
        Client client = new Client();
        String salt = SaltUtil.getSalt(8);
        client.setTel(tel);
        Client ifExit = clientService.getClientInfoByTel(tel);
        if (ifExit == null){
            client.setNickName(nickname);
            client.setRealName(realName);
            client.setIdCardNo(idCardNo);
            client.setSalt(salt);
            client.setAddress(address);
            Md5Hash MD5 = new Md5Hash(password,salt,1024);
            client.setPassword(MD5.toHex());
            clientService.register(client);
            return "注册成功";
        }else {
            return "该号码已注册";
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String tel, String password, String loginType, Model model){
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
            return "登录成功";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户不存在");
            return "用户不存在";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "密码错误";
        }
    }
}
