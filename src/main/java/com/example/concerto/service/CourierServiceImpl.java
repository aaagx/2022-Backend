package com.example.concerto.service;

import com.example.concerto.dao.CourierDao;
import com.example.concerto.pojo.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService{
    @Autowired
    CourierDao courierDao;
    @Override
    public Courier getCourierInfoByTel(String tel) {
        Courier courier = new Courier();
        courier.setTel(tel);
        List<Courier> list = courierDao.getCourierListByPojo(courier);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public Courier getCourierInfoByCourierNo(int courierNo) {
        Courier courier = new Courier();
        courier.setCourierNo(courierNo);
        List<Courier> list = courierDao.getCourierListByPojo(courier);
        if (list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void register(Courier courier) {
        courierDao.insertCourierInfo(courier);
    }

    @Override
    public void deleteCourierInfoByCourierNo(int courierNo) {
        courierDao.deleteCourierInfoByCourierNo(courierNo);
    }

    @Override
    public List<Courier> getCourierListByStationNo(int stationNo) {
        List<Courier> courierList = courierDao.getCourierListByStationNo(stationNo);
        return courierList;
    }


    @Override
    public List<Courier> getCourierListByPojo(Courier courier) {
        List<Courier> courierList = courierDao.getCourierListByPojo(courier);
        return courierList;
    }

}
