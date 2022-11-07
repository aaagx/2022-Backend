package com.example.concerto.pojo;

public class Courier_express {
    Integer id;
    Integer courier_no;
    Integer express_no;

    public Courier_express(Integer id, Integer courier_no, Integer express_no) {
        this.id = id;
        this.courier_no = courier_no;
        this.express_no = express_no;
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

    public Integer getExpress_no() {
        return express_no;
    }

    public void setExpress_no(Integer express_no) {
        this.express_no = express_no;
    }
}
