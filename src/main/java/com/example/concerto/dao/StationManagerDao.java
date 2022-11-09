package com.example.concerto.dao;

import com.example.concerto.pojo.StationManager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StationManagerDao {
    public void insertStationManager(StationManager stationManager);

    public void deleteStationManagerByStationManager(StationManager stationManager);

    public void updateStationManagerByStationManager(StationManager stationManager);

    public List<StationManager> getStationManagerList(StationManager stationManager);
}
