package com.example.concerto.pojo;

public class Manager {
    String uuid;
    String account;
    Integer manager_no;
    String name;
    String tel;
    String password;
    String salt;

    public Manager(String uuid, String account, Integer manager_no, String name, String tel, String password, String salt) {
        this.uuid = uuid;
        this.account = account;
        this.manager_no = manager_no;
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.salt = salt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getManager_no() {
        return manager_no;
    }

    public void setManager_no(Integer manager_no) {
        this.manager_no = manager_no;
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
}
