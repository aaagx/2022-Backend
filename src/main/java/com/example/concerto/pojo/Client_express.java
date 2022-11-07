package com.example.concerto.pojo;

public class Client_express {
    Integer id;
    String tel;
    Integer express_no;

    public Client_express(Integer id, String tel, Integer express_no) {
        this.id = id;
        this.tel = tel;
        this.express_no = express_no;
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

    public Integer getExpress_no() {
        return express_no;
    }

    public void setExpress_no(Integer express_no) {
        this.express_no = express_no;
    }
}
