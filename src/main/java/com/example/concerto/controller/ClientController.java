package com.example.concerto.controller;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.Express;
import com.example.concerto.pojo.UserToken;
import com.example.concerto.service.ClientService;
import com.example.concerto.service.ClientServiceImpl;
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
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    ExpressService expressService;


    @RequestMapping("/register")
    @ResponseBody

    public String register(@RequestParam("tel") String tel,@RequestParam("nickname")String nickname,@RequestParam("realName")String realName,@RequestParam("idCardNo")String idCardNo,@RequestParam("password")String password){


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
            return "登录成功";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户不存在");
            return "用户不存在";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "密码错误";
        }
    }

    /**
     * 获得用户未取件(status=3)的快递列表
     * @return
     */
    @PostMapping("/getNotPickedUpExpress")
    public CommonResponse getNotPickedUpExpress(@RequestParam("tel")String tel){
        List<Express> expressList = expressService.getNotPickedUpExpress(tel, 3);
        return new CommonResponse(200,"成功",expressList);
    }

    /**
     * 用户取件->修改快递的状态为4:已取件
     * @param expressNo
     * @return
     */
    @PostMapping("/doPickUpExpress")
    public CommonResponse doPickUpExpress(@RequestParam("expressNo") int expressNo){
        Express express = new Express();
        express.setStatus(4);
        express.setExpressNo(expressNo);
        expressService.updateExpressByPojo(express);
        return new CommonResponse(200,"成功",null);
    }
}
