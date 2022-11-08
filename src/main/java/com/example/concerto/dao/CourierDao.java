package com.example.concerto.dao;

import com.example.concerto.pojo.Courier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourierDao {

    /**
     * 插入
     * @param courier
     */
    public void insertCourierInfo(Courier courier);

    public void deteleCourierInfoById(int id);

    public void updateCourierInfo(Courier courier);

    public Courier getCourierInfoById(int id);

    public List<Courier> getCourierList();

    public List<Courier> getCourierListByPojo(Courier courier);

}
