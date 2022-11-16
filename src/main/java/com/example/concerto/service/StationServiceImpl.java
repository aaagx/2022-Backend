package com.example.concerto.service;

import com.example.concerto.dao.StationDao;
import com.example.concerto.dao.StationExpressDao;
import com.example.concerto.pojo.Express;
import com.example.concerto.pojo.Station;
import com.example.concerto.pojo.StationExpress;
import com.example.concerto.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationDao stationDao;
    @Autowired
    StationExpressDao stationExpressDao;
    @Override
    public Station getStationiByExpressNo(Integer ExpressNo) {
        List<StationExpress> SElist=stationExpressDao.getStationExpressList(new StationExpress(null,null,ExpressNo));
        if(SElist.isEmpty())
            return null;
        Integer StationNo=SElist.get(0).getStationNo();
        List<Station> result=stationDao.getStationList(new Station(StationNo,null,null));
        if(result.isEmpty())
            return null;
        return result.get(0);
    }

    @Override
    public List<Station> getStationList() {
        return  stationDao.getStationList(new Station());
    }

    @Override
    public List<Station> getStationList(List<Express> expressList) {
        List<Station> stationList=new ArrayList<Station>();
        for(int i=0;i<expressList.size();i++)
        {
            Station temp=getStationiByExpressNo(expressList.get(i).getExpressNo());
            if(temp!=null)
            stationList.add(temp);
            else
                stationList.add(new Station(0,"无","无"));
        }
        return  stationList;
    }
}
