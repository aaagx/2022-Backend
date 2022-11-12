package com.example.concerto.dao;

import com.example.concerto.pojo.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WxUserDao {
    public WxUser selectById(String openId);
    public void insert(WxUser user);
    public void updateById(WxUser wxUser);
}
