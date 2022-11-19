package com.example.concerto.service;

import com.example.concerto.dao.ExpressDao;
import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService{
    @Autowired
    ExpressDao expressDao;


    @Override
    public void insertExpressByPojo(Express express) {
        expressDao.insertExpressByPojo(express);
    }

    @Override
    public List<Express> getNotPickedUpExpress(String tel, int status) {
        List<Express> expressList = expressDao.getRecExpressListByTelAndStatus(tel, status);
        return expressList;
    }

    @Override
    public Integer updateExpressByPojo(Express express) {
        if(express.getExpressNo()!=null)
            expressDao.updateExpressByPojo(express);
        else {
            express.setStatus(1);
            expressDao.insertExpressByPojo(express);
        }
        return 0;
    }

    @Override
    public List<Express> getExpressBySender(String tel) {
        List<Express> expressList = expressDao.getSendExpressListByTel(tel);
        return expressList;
    }

    @Override
    public String getCourierTel(int expressNo) {
        return expressDao.getCourierTel(expressNo);
    }


    @Override
    public List<Express> getExpressListByCourierNoAndStatus(int courierNo, Integer status) {
        List<Express> expressList = expressDao.getExpressListByCourierNoAndStatus(courierNo, status);
        return expressList;
    }

    @Override
    public void deleteExpressByExpressNo(int expressNo) {
        expressDao.deleteExpressByExpressNo(expressNo);
    }

    @Override
    public List<Express> getExpressListByStationNo(Integer stationNo)
    {
        List<Express> expressList = expressDao.getExpressListByStationNo(stationNo,1);
        return  expressList;
    }
}
