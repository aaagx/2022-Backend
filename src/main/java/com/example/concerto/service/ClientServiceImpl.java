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

    @Override
    public void insertClientInfo(Client client) {
        clientDao.insertClientInfo(client);
    }

    @Override
    public void deleteClientInfoById(int id) {
        clientDao.deleteClientInfoById(id);
    }

    @Override
    public void updateClientInfo(Client client) {
        clientDao.updateClientInfo(client);
    }

    @Override
    public Client getClientInfoById(int id) {
        Client client = clientDao.getClientInfoById(id);
        return client;
    }

    @Override
    public List<Client> getClientList() {
        List<Client> clientList = clientDao.getClientList();
        return clientList;
    }

    @Override
    public List<Client> getClientListByPojo(Client client) {
        List<Client> clientList = clientDao.getClientListByPojo(client);
        return clientList;
    }
}
