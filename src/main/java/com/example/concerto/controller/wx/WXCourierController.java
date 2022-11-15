package com.example.concerto.controller.wx;

import com.example.concerto.controller.response.CommonResponse;
import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.Express;
import com.example.concerto.service.wx.WXCourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
@RequestMapping("/wx/courier")
public class WXCourierController {
    @Autowired
    WXCourierService courierService;

    @RequestMapping("/queryExpressListByStatus")
    public CommonResponse queryExpressListByStatus(@RequestParam("courierNo") int courierNo, @RequestParam("status") int status) {
        ArrayList<Express> expresses = new ArrayList<>();
        if (status == 3 || status == 4) {
            expresses.addAll(courierService.queryExpressListByStatus(courierNo, 3));
            expresses.addAll(courierService.queryExpressListByStatus(courierNo, 4));
        } else {
            expresses.addAll(courierService.queryExpressListByStatus(courierNo, status));
        }
        return new CommonResponse(200, "right", expresses);
    }

    @RequestMapping("/receiveOrder")
    public CommonResponse receiveOrder(@RequestParam("courierNo") int courierNo, @RequestParam("expressNo") int expressNo) {
        courierService.insertCourierExpressAndUpdateStatus(courierNo, expressNo, 2);
        return new CommonResponse(200, "right", "");
    }

    @RequestMapping("/queryExpressByExpressNo")
    public CommonResponse queryExpressByExpressNo(@RequestParam("expressNo") int expressNo) {
        Express express = courierService.queryExpressByExpressNo(expressNo);
        return new CommonResponse(200, "right", express);
    }

    @RequestMapping("/updateExpressStatus")
    public CommonResponse updateExpressStatus(@RequestParam("expressNo") int expressNo) {
        courierService.updateExpressStatus(expressNo, 3);
        return new CommonResponse(200, "right", "");
    }
}
