package com.example.concerto.controller.wx;

import com.example.concerto.controller.response.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wx/Login")
public class WXLoginController {
    String AppId = "";  //公众平台自己的appId
    String AppSecret = "";  //AppSecret
    RestOperations restTemplate=new RestTemplate();
    @GetMapping("/login")
    public CommonResponse wxLogin(@RequestParam("code") String code) throws Exception {
        RestOperations restTemplate=new RestTemplate();
    }
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + AppId +
                "&secret=" + AppSecret +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        //利用spring原生http请求工具对接口进行请求
        String jsonData = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(jsonData);
        //请求返回的是Json类型的数据 所以我们需要用到fastjson
        //这个判断是判断我们的请求是否出错，如果没有出错的话就能够拿到openid
        if (StringUtils.contains(jsonData, "errcode")) {
            //出错了
            result.setMessage("err");
            return result;
        }
        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        String unionid = jsonObject.getString("unionid");
        System.out.println(openid);
        System.out.println(sessionKey );
        System.out.println(unionid);

    }
