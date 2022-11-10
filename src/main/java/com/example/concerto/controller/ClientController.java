package com.example.concerto.controller;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Client;
import com.example.concerto.returnData.Pager;
import com.example.concerto.service.ClilentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    ClilentService clilentService;

    @PostMapping("/id")
    public CommonResponse testCommonResponse(@RequestParam int id){
        Client client=clilentService.getClientInfoById(id);
        return new CommonResponse(200,"对了", client);
    }
    @GetMapping("/list")
    public CommonResponse getLIst()
    {
        List<Client> result=clilentService.getClientList();
        Pager pager=new Pager(result,20,10,0);
        return new CommonResponse(200,"not ok",pager);
    }
}
