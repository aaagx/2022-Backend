package com.example.concerto.dao;

import com.example.concerto.pojo.ClientExpress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClientExpressDao {

    public void insertClientExpressInfo(ClientExpress clientExpress);

    public void deleteClientExpressInfo(ClientExpress clientExpress);

    public void updateClientExpressInfo(ClientExpress clientExpress);

    public ClientExpress getClientExpressInfoByExpressNo(Integer expressNo);

    public List<ClientExpress> getClientExpressInfoListByClientTel(String tel);
}
