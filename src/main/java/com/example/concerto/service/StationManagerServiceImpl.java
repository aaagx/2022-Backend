package com.example.concerto.service;

import com.example.concerto.dao.StationManagerDao;
import com.example.concerto.pojo.StationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationManagerServiceImpl implements StationManagerService{

    @Autowired
    StationManagerDao stationManagerDao;
    @Override
    public int getStationNoByManagerNo(int managerNo) {
        StationManager stationManager = new StationManager();
        stationManager.setManagerNo(managerNo);
        List<StationManager> stationManagerList = stationManagerDao.getStationManagerList(stationManager);
        if (stationManagerList.size() == 0){
            return -1;
        }
        return stationManagerList.get(0).getStationNo();
    }

}
