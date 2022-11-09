package com.example.concerto.dao;

import com.example.concerto.pojo.Express;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExpressDao {

    public void insertExpressInfo(Express express);

    public void deleteExpressInfo(int id);

    public void deleteExpressInfoByPojo(Express express);

    public void updateExpressInfo(Express express);

    public Express getExpressInfoById(int id);

    public List<Express> getExpressList();

    public List<Express> getExpressListByPojo(Express express);

}
