package com.example.concerto.controller.wx;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Express;
import com.example.concerto.service.wx.WXClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wx/client")
public class WXClientController {
    @Autowired
    WXClientService clientService;

    @RequestMapping("/insertExpress")
    public CommonResponse insertExpress(String expressCompany, String productLink, String senderTel, String recipientTel, String senderName, String recipientName, String senderAddress, String recipientAddress) {
        Express express = new Express();
        express.setExpressCompany(expressCompany);
        express.setProductLink(productLink);
        express.setSenderTel(senderTel);
        express.setRecipientTel(recipientTel);
        express.setSenderName(senderName);
        express.setRecipientName(recipientName);
        express.setSenderAddress(senderAddress);
        express.setRecipientAddress(recipientAddress);
        express.setStatus(1);
        clientService.insertExpress(express);
        return new CommonResponse(200, "right", "");
    }

    @RequestMapping("/queryExpressListByStatus")
    public CommonResponse queryExpressListByStatus(String tel, int status) {
        List<Express> expresses = clientService.queryExpressListByStatus(tel, status);
        return new CommonResponse(200, "right", expresses);
    }

    @RequestMapping("/queryExpressByExpressNo")
    public CommonResponse queryExpressByExpressNo(int expressNo) {
        Express express = clientService.queryExpressByExpressNo(expressNo);
        return new CommonResponse(200, "right", express);
    }

    @RequestMapping("/deleteExpressByExpressNo")
    public CommonResponse deleteExpressByExpressNo(int expressNo) {
        clientService.deleteExpressByExpressNo(expressNo);
        return new CommonResponse(200, "right", "");
    }


}
