package com.example.concerto.dao;

import com.example.concerto.pojo.StationCourier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StationCourierDao {
    public void insertStationCourier(StationCourier stationCourier);

    public void deleteStationCourierByStationCourier(StationCourier stationCourier);

    public void updateStationCourierByStationCourier(StationCourier stationCourier);

    public List<StationCourier> getStationCourierList(StationCourier stationCourier);
}
