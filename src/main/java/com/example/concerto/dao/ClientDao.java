package com.example.concerto.dao;

import com.example.concerto.pojo.Client;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sarise
 * @version 1.0
 * @date 2021/4/20 下午8:58
 */
@Mapper
@Repository
public interface ClientDao {
    //模糊查询 用like对标题和概述进行查询
    public List<Client> queryByNickName(String keyword);

    /**
     * 插入
     *
     * @param client
     */
    public void insertClientInfo(Client client);

    /**
     * 通过Id删除
     */
    public void deleteClientInfoByTel(int tel);

    /**
     * 更新
     *
     * @param client
     */
    public void updateClientInfo(Client client);


    /**
     * 通过id获得Client信息
     *
     * @return
     */
    public Client getClientInfoByTel(int tel);

    /**
     * 获得Client的全部列表信息
     *
     * @return
     */
    public List<Client> getClientList();

    /**
     * 通过pojo查找client信息
     *
     * @param client
     * @return
     */
    public List<Client> getClientListByPojo(Client client);

    public void updateClientAddressByTel(String address, String tel);

}

