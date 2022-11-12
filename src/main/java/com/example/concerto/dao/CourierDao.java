package com.example.concerto.dao;

import com.example.concerto.pojo.Courier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourierDao {

    /**
     * 插入
     * @param courier
     */
    public void insertCourierInfo(Courier courier);

    public void deteleCourierInfoByCourierNo(int courierNo);

    public void updateCourierInfo(Courier courier);

    public Courier getCourierInfoByCourierNo(int courierNo);

    public List<Courier> getCourierList();

    public List<Courier> getCourierListByPojo(Courier courier);

}
