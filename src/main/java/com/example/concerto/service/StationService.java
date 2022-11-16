package com.example.concerto.service;

import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.Express;
import com.example.concerto.pojo.Station;

import java.util.List;

public interface StationService {
    public Station getStationiByExpressNo(Integer ExpressNo);
    public Station getStationiByCourierNo(Integer CourierNo);
    public List<Station> getStationList();

    public List<Station> getStationList(List<Express> expressList);

    public List<Station>  getStationListByCourier(List<Courier> courierList);
}
