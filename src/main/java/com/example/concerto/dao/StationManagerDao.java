package com.example.concerto.dao;

import com.example.concerto.pojo.Station_manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StationManagerDao {
    public void insertStationManager(Station_manager station_manager);

    public void deleteStationManagerByStationManager(Station_manager station_manager);

    public void updateStationManagerByStationManager(Station_manager station_manager);

    public List<Station_manager> getStationManagerList(Station_manager station_manager);
}
