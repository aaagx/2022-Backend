package com.example.concerto.dao;

import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.Express;
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

    public void deleteCourierInfoByCourierNo(int courierNo);

    public void updateCourierInfo(Courier courier);

    public Courier getCourierInfoByCourierNo(int courierNo);

    public List<Courier> getCourierList();

    public List<Courier> getCourierListByPojo(Courier courier);

    public Courier queryCourierByTel(String tel);

    public List<Courier> getCourierListByStationNo(int stationNo);

}
