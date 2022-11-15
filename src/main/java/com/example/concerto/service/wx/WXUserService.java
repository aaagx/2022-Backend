package com.example.concerto.service.wx;

import com.example.concerto.pojo.WxUser;

public interface WXUserService {
    public WxUser selectById(String openId);
    public void insert(WxUser user);
    public void updateById(WxUser wxUser);
}
