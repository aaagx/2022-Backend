package com.example.concerto.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.dao.WxUserDao;
import com.example.concerto.pojo.WxUser;
import com.example.concerto.utils.WechatUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/wx")
public class WXLoginController {
    @Autowired
    WxUserDao wxUserDao;
    @RequestMapping("/login")
    public CommonResponse userLogin(@RequestParam(value = "code", required = false) String code,
                                    @RequestParam(value = "rawData", required = false) String rawData,
                                    @RequestParam(value = "signature", required = false) String signature,
                                    @RequestParam(value = "encrypteData", required = false) String encrypteData,
                                    @RequestParam(value = "iv", required = false) String iv) {
        JSONObject rawDataJSON = JSON.parseObject(rawData);
        JSONObject sessionKeyOrOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        String openId = sessionKeyOrOpenId.getString("openid");
        String sessionKey = sessionKeyOrOpenId.getString("session_key");
        String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
        if (!signature.equals(signature2)) {
            return new CommonResponse(500, "签名校验失败", "");
        }
        WxUser wxUser = wxUserDao.selectById(openId);
        String skey = UUID.randomUUID().toString();
        if(wxUser==null){
            String nickname = rawDataJSON.getString("nickName");
            String avatarUrl = rawDataJSON.getString("avatarUrl");
            String gender = rawDataJSON.getString("gender");
            String city = rawDataJSON.getString("city");
            String country = rawDataJSON.getString("country");
            String province = rawDataJSON.getString("province");

            wxUser  = new WxUser();
            wxUser.setOpenId(openId);
            wxUser.setSkey(skey);
            wxUser.setCreateTime(new Date());
            wxUser.setLastVisitTime(new Date());
            wxUser.setSessionKey(sessionKey);
            wxUser.setProvince(province);
            wxUser.setCountry(country);
            wxUser.setAvatarUrl(avatarUrl);
            wxUser.setGender(Integer.parseInt(gender));
            wxUser.setNickname(nickname);
            wxUserDao.insert(wxUser);
        }else{
            wxUser.setLastVisitTime(new Date());
            wxUser.setSkey(skey);
            wxUserDao.updateById(wxUser);
        }
        return new CommonResponse(200,"登陆成功","");
    }
}
