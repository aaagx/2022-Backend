package com.example.concerto.service.wx;

import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.Express;

import java.util.List;

public interface ClientService {
    public void insertExpress(Express express);

    public List<Express> queryExpressListByStatus(String tel, int status);

    public Express queryExpressByExpressNo(int expressNo);

    public void deleteExpressByExpressNo(int expressNo);
}
