package com.example.concerto.controller.wx;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Express;
import com.example.concerto.service.ExpressService;
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
    @Autowired
    ExpressService expressService;

    @RequestMapping("/insertExpress")
    public CommonResponse insertExpress(@RequestParam("expressCompany") String expressCompany,
                                        @RequestParam("senderTel") String senderTel,
                                        @RequestParam("recipientTel") String recipientTel,
                                        @RequestParam("senderName") String senderName,
                                        @RequestParam("recipientName") String recipientName,
                                        @RequestParam("senderAddress") String senderAddress,
                                        @RequestParam("recipientAddress") String recipientAddress) {
        Express express = new Express();
        express.setExpressCompany(expressCompany);
        express.setSenderTel(senderTel);
        express.setRecipientTel(recipientTel);
        express.setSenderName(senderName);
        express.setRecipientName(recipientName);
        express.setSenderAddress(senderAddress);
        express.setRecipientAddress(recipientAddress);
        express.setStatus(1);
        clientService.insertExpress(express);
        return new CommonResponse(200, "寄件成功", "");
    }

    @RequestMapping("/queryExpressListByStatus")
    public CommonResponse queryExpressListByStatus(@RequestParam("tel") String tel, @RequestParam("status") int status) {
        List<Express> expresses = new ArrayList<>();
        if (status == 1) {
            expresses.addAll(clientService.querySendExpressListByStatus(tel, 1));
        } else if (status == 2) {
            expresses.addAll(clientService.queryExpressListByStatus(tel, 2));
            expresses.addAll(clientService.querySendExpressListByStatus(tel, 2));
            expresses.addAll(clientService.queryExpressListByStatus(tel, 3));
            expresses.addAll(clientService.querySendExpressListByStatus(tel, 3));
        } else if (status == 3) {
            expresses.addAll(clientService.queryExpressListByStatus(tel, 4));
        } else if (status == 4) {
            expresses.addAll(clientService.queryExpressListByStatus(tel, 5));
            expresses.addAll(clientService.querySendExpressListByStatus(tel, 5));
        } else {
            return new CommonResponse(500, "未知status", "");
        }
        return new CommonResponse(200, "right", expresses);
    }

    @RequestMapping("/queryExpressByExpressNo")
    public CommonResponse queryExpressByExpressNo(@RequestParam("expressNo") int expressNo) {
        Express express = clientService.queryExpressByExpressNo(expressNo);
        return new CommonResponse(200, "right", express);
    }

    @RequestMapping("/updateExpressByExpressNo")
    public CommonResponse updateExpressByExpressNo(@RequestParam("expressNo") int expressNo) {
        Express express = new Express();
        express.setExpressNo(expressNo);
        express.setStatus(5);
        expressService.updateExpressByPojo(express);

        return new CommonResponse(200, "right", "");
    }

    @RequestMapping("/getCourierTel")
    public CommonResponse getCourierTel(@RequestParam("expressNo") int expressNo) {
        String courierTel = expressService.getCourierTel(expressNo);
        if (courierTel == null) {
            return new CommonResponse(500, "没有快递员接单", "");
        } else {
            return new CommonResponse(200, "快递员电话", courierTel);
        }
    }

    @RequestMapping("/updateClientAddressByTel")
    public CommonResponse updateClientAddressByTel(@RequestParam("address") String address, @RequestParam("tel") String tel) {
        clientService.updateClientAddressByTel(address, tel);
        return new CommonResponse(200, "right", "");
    }
}
