package com.example.concerto.controller;
import com.example.concerto.pojo.Manager;
import com.example.concerto.pojo.UserToken;
import com.example.concerto.service.ManagerServiceImpl;
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
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ManagerServiceImpl managerService;


    @RequestMapping("/register")
    @ResponseBody
    public String register(String account,int managerNo,String name,String tel,String password){
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
            return "管理员登录成功";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","管理员账号不存在");
            return "管理员账号不存在";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","管理员密码错误");
            return "管理员密码错误";
        }
    }
}
