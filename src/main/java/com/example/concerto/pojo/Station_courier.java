package com.example.concerto.pojo;

public class Station_courier {
    String uuid;
    Integer station_no;
    Integer courier_no;

    public Station_courier(String uuid, Integer station_no, Integer courier_no) {
        this.uuid = uuid;
        this.station_no = station_no;
        this.courier_no = courier_no;
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

    public Integer getCourier_no() {
        return courier_no;
    }

    public void setCourier_no(Integer courier_no) {
        this.courier_no = courier_no;
    }
}
