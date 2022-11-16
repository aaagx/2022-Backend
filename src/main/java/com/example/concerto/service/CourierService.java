package com.example.concerto.service;

import com.example.concerto.pojo.Courier;

import java.util.List;

public interface CourierService {

    Courier getCourierInfoByTel(String tel);

    Courier getCourierInfoByCourierNo(int courierNo);
    void register(Courier courier);

    void deleteCourierInfoByCourierNo(int courierNo);

    public List<Courier> getCourierListByStationNo(int stationNo);

    public List<Courier> getCourierListByPojo(Courier courier);}