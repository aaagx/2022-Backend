package com.example.concerto.dao;

import com.example.concerto.pojo.Station_express;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StationExpressDao {
    public void insertStationExpress(Station_express station_express);

    public void deleteStationExpressByStationExpress(Station_express station_express);

    public void updateStationExpressByStationExpress(Station_express station_express);

    public List<Station_express> getStationExpressList(Station_express station_express);
}
