package com.example.concerto.dao;

import com.example.concerto.pojo.Station;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StationDao {
    public void insertStation(Station station);

    public void deleteStationByStation(Station station);

    public void updateStationAddressByStation(Station station);

    public void updateStationNameByStation(Station station);

    public List<Station> getStationList(Station station);
}
