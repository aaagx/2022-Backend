package com.example.concerto.pojo;

public class Manager {
    String account;
    Integer managerNo;
    String name;
    String tel;
    String password;
    String salt;

    public Manager(String account, Integer managerNo, String name, String tel, String password, String salt) {
        this.account = account;
        this.managerNo = managerNo;
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.salt = salt;
    }

    public Manager() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(Integer managerNo) {
        this.managerNo = managerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        return "Manager{" +
                "account='" + account + '\'' +
                ", managerNo=" + managerNo +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
