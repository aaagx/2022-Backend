package com.example.concerto.dao;

import com.example.concerto.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerDao {

    public void insertManageInfo(Manager manager);

    public void deleteManageInfoByManagerNo(int managerNo);

    public void deleteManageInfoByPojo(Manager manager);

    public void updateManageInfo(Manager manager);

    public Manager getManageInfoByManagerNo(int managerNo);

    public List<Manager> getManageInfoList();

    public List<Manager> getManageInfoByPojo(Manager manager);
}
