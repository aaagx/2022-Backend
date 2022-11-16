package com.example.concerto.service;

import com.example.concerto.dao.ManagerDao;
import com.example.concerto.pojo.Express;
import com.example.concerto.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    ManagerDao managerDao;
    @Override
    public Manager getManagerInfoByTel(String tel) {
        Manager manager = new Manager();
        manager.setTel(tel);
        List<Manager> list = managerDao.getManageInfoByPojo(manager);
        if (list.size() == 0){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    public Manager getManagerInfoByManagerNo(int managerNo) {
        Manager manager = new Manager();
        manager.setManagerNo(managerNo);
        List<Manager> list = managerDao.getManageInfoByPojo(manager);
        if (list.size() == 0){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    public void register(Manager manager) {
        managerDao.insertManageInfo(manager);
    }

}
