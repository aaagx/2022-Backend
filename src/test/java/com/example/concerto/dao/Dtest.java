package com.example.concerto.dao;
import com.example.concerto.pojo.Courier;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class Dtest {
    @Autowired
    CourierDao courierDao;

    @Test
    public void test(){
        Courier courier = new Courier();
        courier.setId(1);
        System.out.println(courier.getId());
        List<Courier> courierList = courierDao.getCourierList();
        for (Courier courier1 : courierList) {
            System.out.println(courier1.toString());
        }
    }
}