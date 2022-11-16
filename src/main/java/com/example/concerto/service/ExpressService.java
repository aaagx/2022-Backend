package com.example.concerto.service;

import com.example.concerto.pojo.Express;

import java.util.List;

public interface ExpressService {
    public List<Express> getNotPickedUpExpress(String tel, int status);

    public void updateExpressByPojo(Express express);

    public String getCourierTel(int expressNo);

    public List<Express> getExpressBySender(String tel);
}
