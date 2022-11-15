package com.example.concerto.service.wx;

import com.example.concerto.dao.WxUserDao;
import com.example.concerto.pojo.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WXUserServiceImpl implements WXUserService{
    @Autowired
    WxUserDao wxUserDao;
    @Override
    public WxUser selectById(String openId) {
        return wxUserDao.selectById(openId);
    }

    @Override
    public void insert(WxUser user) {
        wxUserDao.insert(user);
    }

    @Override
    public void updateById(WxUser wxUser) {
        wxUserDao.updateById(wxUser);
    }
}
