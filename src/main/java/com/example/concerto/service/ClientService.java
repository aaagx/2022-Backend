package com.example.concerto.service;

import com.example.concerto.pojo.Client;

public interface ClientService {
    Client getClientInfoByTel(String tel);

    void register(Client client);
}
