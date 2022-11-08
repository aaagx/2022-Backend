package com.example.concerto.service;

import com.example.concerto.pojo.Client;

import java.util.List;

public interface ClilentService {
    List<Client> getByKeyword(String keyword);

    void insertClientInfo(Client client);

    void deleteClientInfoById(int id);

    void updateClientInfo(Client client);

    Client getClientInfoById(int id);

    List<Client> getClientList();

    List<Client> getClientListByPojo(Client client);
}
