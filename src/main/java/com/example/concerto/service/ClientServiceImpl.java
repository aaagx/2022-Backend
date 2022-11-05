package com.example.concerto.service;

import com.example.concerto.dao.ClientDao;
import com.example.concerto.pojo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClilentService{
    @Autowired
    ClientDao clientDao;
    @Override
    public List<Client> getByKeyword(String keyword) {
        List<Client> result= clientDao.queryByNickName("aaagx");
        return result;
    }
}
