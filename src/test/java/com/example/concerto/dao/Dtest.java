package com.example.concerto.dao;
import com.example.concerto.pojo.Courier;
import com.example.concerto.pojo.Manager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class Dtest {
    @Autowired
    CourierDao courierDao;

    @Autowired
    ManagerDao managerDao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;
    @Test
    public void test(){
        date=new Date();
        System.out.println(date);
    }
}
