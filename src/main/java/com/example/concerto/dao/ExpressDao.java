package com.example.concerto.dao;

import com.example.concerto.pojo.Express;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpressDao {

    public void intserExpressInfo(Express express);

    public void deleteExpressInfo(int id);

    public void deleteExpressInfoByPojo(Express express);

    public void updateExpressInfo(Express express);

    public Express getExpressInfoById(int id);

    public List<Express> getExpressList();

    public List<Express> getExpressListByPojo(Express express);

}
