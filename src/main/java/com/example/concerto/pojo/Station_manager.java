package com.example.concerto.pojo;

public class Station_manager {
    Integer id;
    Integer station_no;
    Integer manager_no;

    public Station_manager(Integer id, Integer station_no, Integer manager_no) {
        this.id = id;
        this.station_no = station_no;
        this.manager_no = manager_no;
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

    public Integer getManager_no() {
        return manager_no;
    }

    public void setManager_no(Integer manager_no) {
        this.manager_no = manager_no;
    }
}
