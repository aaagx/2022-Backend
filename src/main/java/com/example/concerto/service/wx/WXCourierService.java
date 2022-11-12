package com.example.concerto.service.wx;

import com.example.concerto.pojo.Express;

import java.util.List;

public interface WXCourierService {
    public void insertCourierExpressAndUpdateStatus(int courierNo,int expressNo,int status);

    public List<Express> queryExpressListByStatus(int courierNo, int status);

    public Express queryExpressByExpressNo(int expressNo);

    public void updateExpressStatus(int expressNo,int status);

}
