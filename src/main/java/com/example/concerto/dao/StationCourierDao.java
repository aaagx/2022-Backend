package com.example.concerto.dao;

import com.example.concerto.pojo.Station_courier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StationCourierDao {
    public void insertStationCourier(Station_courier station_courier);

    public void deleteStationCourierByStationCourier(Station_courier station_courier);

    public void updateStationCourierByStationCourier(Station_courier station_courier);

    public List<Station_courier> getStationCourierList(Station_courier station_courier);
}
