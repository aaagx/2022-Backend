package com.example.concerto.dao;


import com.example.concerto.pojo.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author sarise
 * @version 1.0
 * @date 2021/4/20 下午5:48
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class DaoTest {
    @Autowired
    ClientDao clientDao;

    @Test
    public void test(){
        List<Client> Clients = clientDao.queryByNickName("aaagx");
        System.out.println(Clients.get(0).getTel());
        System.out.println("fine");
    }

}