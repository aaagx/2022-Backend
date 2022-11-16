package com.example.concerto.service;

import com.example.concerto.dao.ExpressDao;
import com.example.concerto.pojo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService{
    @Autowired
    ExpressDao expressDao;
    @Override
    public List<Express> getNotPickedUpExpress(String tel, int status) {
        List<Express> expressList = expressDao.getRecExpressListByTelAndStatus(tel, status);
        return expressList;
    }

    @Override
    public void updateExpressByPojo(Express express) {
        expressDao.updateExpressByPojo(express);
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
}
