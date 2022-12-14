package com.example.concerto.controller;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Client;
import com.example.concerto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sarise
 * @version 1.0
 * @date 2021/4/20 下午7:52
 */
@RestController()
public class TestController {

    @Autowired
    ClientService clilentService;

    @RequestMapping("/rsp")
    public CommonResponse testCommonResponse(){
        Client result=clilentService.getClientInfoByTel("13905080435");
        return new CommonResponse(200,"对了", result);
    }

}
