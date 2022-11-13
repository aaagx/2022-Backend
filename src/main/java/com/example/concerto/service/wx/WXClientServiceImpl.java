package com.example.concerto.service.wx;

import com.example.concerto.dao.CourierExpressDao;
import com.example.concerto.dao.ExpressDao;
import com.example.concerto.dao.StationExpressDao;
import com.example.concerto.pojo.CourierExpress;
import com.example.concerto.pojo.Express;
import com.example.concerto.pojo.StationExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WXClientServiceImpl implements WXClientService {
    @Autowired
    ExpressDao expressDao;
    @Autowired
    ClientExpressDao clientExpressDao;
    @Autowired
    StationExpressDao stationExpressDao;
    @Autowired
    CourierExpressDao courierExpressDao;

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

        ClientExpress clientExpress = new ClientExpress();
        clientExpress.setExpressNo(expressNo);
        clientExpressDao.deleteClientExpress(clientExpress);

        CourierExpress courierExpress = new CourierExpress();
        clientExpress.setExpressNo(expressNo);
        courierExpressDao.deleteCourierExpressInfo(courierExpress);

        StationExpress stationExpress = new StationExpress();
        stationExpress.setExpressNo(expressNo);
        stationExpressDao.deleteStationExpressByStationExpress(stationExpress);

    }
}
