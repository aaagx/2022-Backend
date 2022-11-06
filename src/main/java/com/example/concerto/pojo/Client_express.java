package com.example.concerto.pojo;

public class Client_express {
    String uuid;
    String tel;
    Integer express_no;

    public Client_express(String uuid, String tel, Integer express_no) {
        this.uuid = uuid;
        this.tel = tel;
        this.express_no = express_no;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
