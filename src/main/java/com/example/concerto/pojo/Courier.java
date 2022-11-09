package com.example.concerto.pojo;

public class Courier {
    Integer id;
    Integer courierNo;
    String realName;
    String tel;
    String idCardNo;
    String password;
    String salt;

    public Courier(Integer id, Integer courierNo, String realName, String tel, String idCardNo, String password, String salt) {
        this.id = id;
        this.courierNo = courierNo;
        this.realName = realName;
        this.tel = tel;
        this.idCardNo = idCardNo;
        this.password = password;
        this.salt = salt;
    }

    public Courier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourierNo() {
        return courierNo;
    }

    public void setCourierNo(Integer courierNo) {
        this.courierNo = courierNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", courierNo=" + courierNo +
                ", realName='" + realName + '\'' +
                ", tel='" + tel + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
