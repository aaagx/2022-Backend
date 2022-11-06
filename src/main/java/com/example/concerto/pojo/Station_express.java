package com.example.concerto.pojo;

public class Station_express {
    String uuid;
    Integer station_no;
    Integer express_no;

    public Station_express(String uuid, Integer station_no, Integer express_no) {
        this.uuid = uuid;
        this.station_no = station_no;
        this.express_no = express_no;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
