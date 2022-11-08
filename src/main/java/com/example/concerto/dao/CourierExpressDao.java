package com.example.concerto.dao;

import com.example.concerto.pojo.Courier_express;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourierExpressDao {

    public void insertCourierExpressInfo(Courier_express courier_express);

    public void deleteCourierExpressInfo(Courier_express courier_express);

    public void updateCourierExpressInfo(Courier_express courier_express);

    public Courier_express getCourierExpressInfoByExpressNo(Integer expressNo);

    public List<Courier_express> getCourierExpressInfoByCourierNo(Integer courierNo);

}
