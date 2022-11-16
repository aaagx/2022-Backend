package com.example.concerto.service;

import com.example.concerto.dao.CourierExpressDao;
import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.CourierExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierExpressServiceImpl implements CourierExpressService {
    @Autowired
    CourierExpressDao courierExpressDao;
    @Override
    public void insertCourierExpressInfo(CourierExpress courierExpress) {
        courierExpressDao.insertCourierExpressInfo(courierExpress);
    }

    @Override
    public void deleteCourierExpressInfo(CourierExpress courierExpress) {
        courierExpressDao.deleteCourierExpressInfo(courierExpress);
    }
}
