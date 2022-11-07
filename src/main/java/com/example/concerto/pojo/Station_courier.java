package com.example.concerto.pojo;

public class Station_courier {
    Integer id;
    Integer station_no;
    Integer courier_no;

    public Station_courier(Integer id, Integer station_no, Integer courier_no) {
        this.id = id;
        this.station_no = station_no;
        this.courier_no = courier_no;
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

    public Integer getCourier_no() {
        return courier_no;
    }

    public void setCourier_no(Integer courier_no) {
        this.courier_no = courier_no;
    }
}
