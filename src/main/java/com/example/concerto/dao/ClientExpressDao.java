package com.example.concerto.dao;

import com.example.concerto.pojo.ClientExpress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClientExpressDao {

    public void insertClientExpress(ClientExpress clientExpress);

    public void deleteClientExpress(ClientExpress clientExpress);

    public void updateClientExpress(ClientExpress clientExpress);

    public ClientExpress getClientExpressByExpressNo(Integer expressNo);

    public List<ClientExpress> getClientExpressListByClientTel(String tel);
}
