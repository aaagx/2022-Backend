package com.example.concerto.service.wx;

import com.example.concerto.dao.CourierExpressDao;
import com.example.concerto.dao.ExpressDao;
import com.example.concerto.pojo.CourierExpress;
import com.example.concerto.pojo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WXCourierServiceImpl implements WXCourierService {
    @Autowired
    CourierExpressDao courierExpressDao;
    @Autowired
    ExpressDao expressDao;

    @Override
    public void insertCourierExpressAndUpdateStatus(int courierNo, int expressNo,int status) {
        CourierExpress courierExpress = new CourierExpress();
        courierExpress.setCourierNo(courierNo);
        courierExpress.setExpressNo(expressNo);
        courierExpressDao.insertCourierExpressInfo(courierExpress);
        expressDao.updateExpressStatusByExpressNo(expressNo,status);
    }

    @Override
    public List<Express> queryExpressListByStatus(int courierNo, int status) {
        List<Express> expressList = expressDao.getExpressListByCourierNoAndStatus(courierNo, status);
        return expressList;
    }

    @Override
    public Express queryExpressByExpressNo(int expressNo) {
        Express express = expressDao.getExpressByExpressNo(expressNo);
        return express;
    }

    @Override
    public void updateExpressStatus(int expressNo, int status) {
        expressDao.updateExpressStatusByExpressNo(expressNo,status);
    }
}
