package com.example.concerto.pojo;

public class Manager {
    Integer id;
    String account;
    Integer manager_no;
    String name;
    String tel;
    String password;
    String salt;

    public Manager(Integer id, String account, Integer manager_no, String name, String tel, String password, String salt) {
        this.id = id;
        this.account = account;
        this.manager_no = manager_no;
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
