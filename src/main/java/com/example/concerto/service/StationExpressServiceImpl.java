package com.example.concerto.service;

import com.example.concerto.dao.StationExpressDao;
import com.example.concerto.pojo.Express;
import com.example.concerto.pojo.StationExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationExpressServiceImpl implements StationExpressService{
    @Autowired
    StationExpressDao stationExpressDao;
    @Override
    public void deleteStationExpressByStationExpress(StationExpress stationExpress) {
        stationExpressDao.deleteStationExpressByStationExpress(stationExpress);
    }

    @Override
    public void update(StationExpress stationExpress) {
        List<StationExpress> expressList=stationExpressDao.getStationExpressList(new StationExpress(null,null,stationExpress.getExpressNo()));
        if(expressList.isEmpty())
            stationExpressDao.insertStationExpress(stationExpress);
        else {
            stationExpressDao.updateStationExpressByStationExpress(stationExpress);
        }
        System.out.println(1);
    }
}
