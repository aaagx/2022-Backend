package com.example.concerto.controller;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.User;
import com.sun.prism.null3d.NULL3DPipeline;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sarise
 * @version 1.0
 * @date 2021/4/20 下午7:52
 */
@RestController()
public class TestController {

    @RequestMapping("/rsp")
    public CommonResponse testCommonResponse(){
        User user=new User();
        return new CommonResponse(200,"对了", user);
    }
}
