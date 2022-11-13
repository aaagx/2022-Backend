package com.example.concerto.controller.wx;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Express;
import com.example.concerto.service.wx.WXClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wx/client")
public class WXClientController {
    @Autowired
    WXClientService clientService;

    @RequestMapping("/insertExpress")
    public CommonResponse insertExpress(@RequestParam("expressCompany") String expressCompany,
                                        @RequestParam("productLink") String productLink,
                                        @RequestParam("senderTel") String senderTel,
                                        @RequestParam("recipientTel") String recipientTel,
                                        @RequestParam("senderName") String senderName,
                                        @RequestParam("recipientName") String recipientName,
                                        @RequestParam("senderAddress") String senderAddress,
                                        @RequestParam("recipientAddress") String recipientAddress) {
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
    public CommonResponse queryExpressListByStatus(@RequestParam("tel") String tel, @RequestParam("status") int status) {
        List<Express> expresses = clientService.queryExpressListByStatus(tel, status);
        return new CommonResponse(200, "right", expresses);
    }

    @RequestMapping("/queryExpressByExpressNo")
    public CommonResponse queryExpressByExpressNo(@RequestParam("expressNo") int expressNo) {
        Express express = clientService.queryExpressByExpressNo(expressNo);
        return new CommonResponse(200, "right", express);
    }

    @RequestMapping("/deleteExpressByExpressNo")
    public CommonResponse deleteExpressByExpressNo(@RequestParam("expressNo") int expressNo) {
        clientService.deleteExpressByExpressNo(expressNo);
        return new CommonResponse(200, "right", "");
    }

    @RequestMapping("/updateClientAddressByTel")
    public CommonResponse updateClientAddressByTel(@RequestParam("address") String address, @RequestParam("tel") String tel) {
        clientService.updateClientAddressByTel(address, tel);
        return new CommonResponse(200, "right", "");
    }
}
