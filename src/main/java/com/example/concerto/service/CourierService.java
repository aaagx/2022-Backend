package com.example.concerto.service;

import com.example.concerto.pojo.Courier;

public interface CourierService {

    Courier getCourierInfoByTel(String tel);

    Courier getCourierInfoByCourierNo(int courierNo);
    void register(Courier courier);
}
