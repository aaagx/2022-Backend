package com.example.concerto.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.dao.CourierDao;
import com.example.concerto.dao.WxUserDao;
import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.UserToken;
import com.example.concerto.pojo.WxUser;
import com.example.concerto.service.ClientService;
import com.example.concerto.service.CourierService;
import com.example.concerto.service.wx.WXCourierService;
import com.example.concerto.service.wx.WXUserService;
import com.example.concerto.utils.HttpClientUtil;
import com.example.concerto.utils.WechatUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/wx")
public class WXLoginController {
    @Autowired
    WXUserService wxUserService;
    @Autowired
    ClientService clientService;
    @Autowired
    CourierService courierService;

    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public CommonResponse userLogin(@RequestParam(value = "code", required = false) String code,
                                    @RequestParam(value = "rawData", required = false) String rawData,
                                    @RequestParam(value = "signature", required = false) String signature) {
        JSONObject rawDataJSON = JSON.parseObject(rawData);
        JSONObject sessionKeyOrOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        String openId = sessionKeyOrOpenId.getString("openid");
        String sessionKey = sessionKeyOrOpenId.getString("session_key");
        String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
        if (!signature.equals(signature2)) {
            return new CommonResponse(500, "签名校验失败", "");
        }
        WxUser wxUser = wxUserService.selectById(openId);
        String skey = UUID.randomUUID().toString();
        if (wxUser == null) {
            String nickname = rawDataJSON.getString("nickName");
            String avatarUrl = rawDataJSON.getString("avatarUrl");
            String gender = rawDataJSON.getString("gender");
            String city = rawDataJSON.getString("city");
            String country = rawDataJSON.getString("country");
            String province = rawDataJSON.getString("province");

            wxUser = new WxUser();
            wxUser.setOpenId(openId);
            wxUser.setSkey(skey);
            wxUser.setCreateTime(new Date());
            wxUser.setLastVisitTime(new Date());
            wxUser.setSessionKey(sessionKey);
            wxUser.setProvince(province);
            wxUser.setCountry(country);
            wxUser.setCity(city);
            wxUser.setAvatarUrl(avatarUrl);
            wxUser.setGender(Integer.parseInt(gender));
            wxUser.setNickname(nickname);
            wxUserService.insert(wxUser);
        } else {
            wxUser.setLastVisitTime(new Date());
            wxUser.setSkey(skey);
            wxUserService.updateById(wxUser);
        }
        return new CommonResponse(200, "登陆成功", wxUser);
    }

    @RequestMapping("/TelPasswordLogin")
    public CommonResponse login(@RequestParam("tel") String tel, @RequestParam("password") String password, @RequestParam("loginType") String loginType) {
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        UserToken token = new UserToken(tel, password, loginType);
        try {
            subject.login(token);
            System.out.println("用户[" + tel + "]登录成功");
            if (loginType.equals("Client")) {
                Client client = clientService.getClientInfoByTel(tel);
                return new CommonResponse(200, "客户登录成功", client);
            } else if (loginType.equals("Courier")) {
                Courier courier = courierService.getCourierInfoByTel(tel);
                return new CommonResponse(200, "快递员登录成功", courier);
            }
            return new CommonResponse(200, "登录成功", " ");
        } catch (UnknownAccountException e) {
            return new CommonResponse(471, "用户不存在", "");
        } catch (IncorrectCredentialsException e) {
            return new CommonResponse(461, "密码错误", "");
        }
    }
}
