package com.example.concerto.pojo;

public class Courier_express {
    String uuid;
    Integer courier_no;
    Integer express_no;

    public Courier_express(String uuid, Integer courier_no, Integer express_no) {
        this.uuid = uuid;
        this.courier_no = courier_no;
        this.express_no = express_no;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getCourier_no() {
        return courier_no;
    }

    public void setCourier_no(Integer courier_no) {
        this.courier_no = courier_no;
    }

    public Integer getExpress_no() {
        return express_no;
    }

    public void setExpress_no(Integer express_no) {
        this.express_no = express_no;
    }
}
