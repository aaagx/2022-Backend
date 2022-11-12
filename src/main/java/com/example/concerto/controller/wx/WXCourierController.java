package com.example.concerto.controller.wx;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Express;
import com.example.concerto.service.wx.WXCourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wx/courier")
public class WXCourierController {
    @Autowired
    WXCourierService courierService;

    @RequestMapping("/queryExpressListByStatus")
    public CommonResponse queryExpressListByStatus(int courierNo, int status) {
        List<Express> expresses = courierService.queryExpressListByStatus(courierNo, status);
        return new CommonResponse(200, "right", expresses);
    }

    @RequestMapping("/receiveOrder")
    public CommonResponse receiveOrder(int courierNo, int expressNo) {
        courierService.insertCourierExpressAndUpdateStatus(courierNo, expressNo, 2);
        return new CommonResponse(200, "right", "");
    }

    @RequestMapping("/queryExpressByExpressNo")
    public CommonResponse queryExpressByExpressNo(int expressNo) {
        Express express = courierService.queryExpressByExpressNo(expressNo);
        return new CommonResponse(200, "right", express);
    }

    @RequestMapping("/updateExpressStatus")
    public CommonResponse updateExpressStatus(int expressNo) {
        courierService.updateExpressStatus(expressNo, 3);
        return new CommonResponse(200, "right", "");
    }
}
