package com.example.concerto.service;

import com.example.concerto.pojo.Client;

import java.util.List;

public interface ClilentService {
    Client getClientInfoByTel(String tel);

    void register(Client client);
}
