package com.example.concerto.service.wx;

import com.example.concerto.dao.ClientExpressDao;
import com.example.concerto.dao.ExpressDao;
import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.ClientExpress;
import com.example.concerto.pojo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ExpressDao expressDao;
    @Autowired
    ClientExpressDao clientExpressDao;

    @Override
    public void insertExpress(Express express) {
        expressDao.insertExpressByPojo(express);
    }

    @Override
    public List<Express> queryExpressListByStatus(String tel, int status) {
        List<Express> expressList = expressDao.getExpressListByTelAndStatus(tel, status);
        return expressList;
    }

    @Override
    public Express queryExpressByExpressNo(int expressNo) {
        Express express = expressDao.getExpressByExpressNo(expressNo);
        return express;
    }

    @Override
    public void deleteExpressByExpressNo(int expressNo) {
        Express express = new Express();
        express.setExpressNo(expressNo);
        expressDao.deleteExpressByPojo(express);
    }
}
