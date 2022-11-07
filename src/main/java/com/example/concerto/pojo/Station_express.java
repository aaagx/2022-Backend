package com.example.concerto.pojo;

public class Station_express {
    Integer id;
    Integer station_no;
    Integer express_no;

    public Station_express(Integer id, Integer station_no, Integer express_no) {
        this.id = id;
        this.station_no = station_no;
        this.express_no = express_no;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStation_no() {
        return station_no;
    }

    public void setStation_no(Integer station_no) {
        this.station_no = station_no;
    }

    public Integer getExpress_no() {
        return express_no;
    }

    public void setExpress_no(Integer express_no) {
        this.express_no = express_no;
    }
}
