package com.example.concerto.dao;

import com.example.concerto.pojo.StationExpress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StationExpressDao {
    public void insertStationExpress(StationExpress stationExpress);

    public void deleteStationExpressByStationExpress(StationExpress stationExpress);

    public void updateStationExpressByStationExpress(StationExpress stationExpress);

    public List<StationExpress> getStationExpressList(StationExpress stationExpress);

}
