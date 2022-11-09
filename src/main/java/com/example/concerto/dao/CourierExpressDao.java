package com.example.concerto.dao;

import com.example.concerto.pojo.CourierExpress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourierExpressDao {

    public void insertCourierExpressInfo(CourierExpress courier_express);

    public void deleteCourierExpressInfo(CourierExpress courier_express);

    public void updateCourierExpressInfo(CourierExpress courier_express);

    public CourierExpress getCourierExpressInfoByExpressNo(Integer expressNo);

    public List<CourierExpress> getCourierExpressInfoByCourierNo(Integer courierNo);

}
