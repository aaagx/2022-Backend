package com.example.concerto.service;

import com.example.concerto.pojo.Express;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpressService {

    public void insertExpressByPojo(Express express);
    public List<Express> getNotPickedUpExpress(String tel, int status);

    public Integer updateExpressByPojo(Express express);

    public String getCourierTel(int expressNo);


    public List<Express> getExpressBySender(String tel);

    public List<Express> getExpressListByCourierNoAndStatus(int courierNo, Integer status);

    public void deleteExpressByExpressNo(int expressNo);

    public List<Express> getExpressListByStationNo(Integer stationNo);

}
