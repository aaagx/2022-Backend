package com.example.concerto.dao;

import com.example.concerto.pojo.Express;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface ExpressDao {

    public void insertExpressByPojo(Express express);

    public void deleteExpressByExpressNo(int expressNo);

    public void deleteExpressByPojo(Express express);

    public void updateExpressByPojo(Express express);

    public Express getExpressByExpressNo(int expressNo);

    public List<Express> getExpressList();

    public List<Express> getExpressListByPojo(Express express);

    public List<Express> getRecExpressListByTel(String tel);

    public List<Express> getSendExpressListByTel(String tel);

    public List<Express> getRecExpressListByTelAndStatus(@Param("recipientTel") String tel, @Param("status") Integer status);

    public List<Express> getSendExpressListByTelAndStatus(@Param("senderTel") String tel, @Param("status") Integer status);

    public List<Express> getExpressListByCourierNoAndStatus(@Param("courierNo") int courierNo, @Param("status") Integer status);

    public void updateExpressStatusByExpressNo(@Param("expressNo") int expressNo, @Param("status") Integer status);

    public String getCourierTel(@Param("expressNo") int expressNo);
}
