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
    public Client getClientInfoByTel(String tel) {
        Client client = new Client();
        client.setTel(tel);
        List<Client> list = clientDao.getClientListByPojo(client);
        if (list.size() == 0){
            return null;
        }
        Client returnClient = new Client();
        returnClient = list.get(0);
        return returnClient;
    }

    @Override
    public void register(Client client) {
        clientDao.insertClientInfo(client);
    }
}
