package com.example.concerto.pojo;

public class ClientExpress {
    Integer id;
    String tel;
    Integer expressNo;

    public ClientExpress(Integer id, String tel, Integer expressNo) {
        this.id = id;
        this.tel = tel;
        this.expressNo = expressNo;
    }

    public ClientExpress() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(Integer expressNo) {
        this.expressNo = expressNo;
    }

    @Override
    public String toString() {
        return "ClientExpress{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", expressNo=" + expressNo +
                '}';
    }
}
