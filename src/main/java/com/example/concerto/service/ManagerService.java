package com.example.concerto.service;

import com.example.concerto.pojo.Manager;

public interface ManagerService {
    Manager getManagerInfoByTel(String tel);

    Manager getManagerInfoByManagerNo(int managerNo);
    void register(Manager manager);
}
