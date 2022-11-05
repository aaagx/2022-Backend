package com.example.concerto.pojo;

public class Client {
    Integer uuid;
    String tel;
    String nickName;
    String realName;
    String idCardNo;
    String password;
    Integer salt;

    public Client(String tel, String nickName, String realName, String idCardNo, String password) {
        this.tel = tel;
        this.nickName = nickName;
        this.realName = realName;
        this.idCardNo = idCardNo;
        this.password = password;
    }

    public Client(Integer uuid, String tel, String nickName, String realName, String idCardNo, String password, Integer salt) {
        this.uuid = uuid;
        this.tel = tel;
        this.nickName = nickName;
        this.realName = realName;
        this.idCardNo = idCardNo;
        this.password = password;
        this.salt = salt;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }
}
