package com.example.concerto.service;

import com.example.concerto.dao.StationCourierDao;
import com.example.concerto.pojo.StationCourier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationCourierServiceImpl implements StationCourierService{
    @Autowired
    StationCourierDao stationCourierDao;
    @Override
    public void insertStationCourier(StationCourier stationCourier) {
        stationCourierDao.insertStationCourier(stationCourier);
    }

    @Override
    public void deleteStationCourierByStationCourier(StationCourier stationCourier) {
        stationCourierDao.deleteStationCourierByStationCourier(stationCourier);
    }
}
