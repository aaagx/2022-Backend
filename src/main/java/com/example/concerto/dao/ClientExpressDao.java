package com.example.concerto.dao;

import com.example.concerto.pojo.Client_express;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientExpressDao {

    public void insertClientExpressInfo(Client_express client_express);

    public void deleteClientExpressInfo(Client_express client_express);

    public void updateClientExpressInfo(Client_express client_express);

    public Client_express getClientExpressInfoByExpressNo(Integer expressNo);

    public List<Client_express> getClientExpressInfoListByClientTel(String tel);
}
