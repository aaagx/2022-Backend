package com.example.concerto.service;

import com.example.concerto.dao.StationExpressDao;
import com.example.concerto.pojo.StationExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationExpressServiceImpl implements StationExpressService{
    @Autowired
    StationExpressDao stationExpressDao;
    @Override
    public void deleteStationExpressByStationExpress(StationExpress stationExpress) {
        stationExpressDao.deleteStationExpressByStationExpress(stationExpress);
    }
}
