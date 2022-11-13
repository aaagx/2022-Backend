package com.example.concerto.pojo;

public class Client {
    String tel;
    String nickName;
    String realName;
    String idCardNo;
    String password;
    String salt;
    String address;

    public Client(String tel, String nickName, String realName, String idCardNo, String password, String salt, String address) {
        this.tel = tel;
        this.nickName = nickName;
        this.realName = realName;
        this.idCardNo = idCardNo;
        this.password = password;
        this.salt = salt;
        this.address = address;
    }

    public Client() {
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "tel='" + tel + '\'' +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
