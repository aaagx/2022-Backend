package com.example.concerto.pojo;

public class Courier {
    Integer id;
    Integer courier_no;
    String real_name;
    String tel;
    String id_card_no;
    Integer employ_unit;
    String password;
    String salt;

    public Courier(Integer id, Integer courier_no, String real_name, String tel, String id_card_no, Integer employ_unit, String password, String salt) {
        this.id = id;
        this.courier_no = courier_no;
        this.real_name = real_name;
        this.tel = tel;
        this.id_card_no = id_card_no;
        this.employ_unit = employ_unit;
        this.password = password;
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourier_no() {
        return courier_no;
    }

    public void setCourier_no(Integer courier_no) {
        this.courier_no = courier_no;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId_card_no() {
        return id_card_no;
    }

    public void setId_card_no(String id_card_no) {
        this.id_card_no = id_card_no;
    }

    public Integer getEmploy_unit() {
        return employ_unit;
    }

    public void setEmploy_unit(Integer employ_unit) {
        this.employ_unit = employ_unit;
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
