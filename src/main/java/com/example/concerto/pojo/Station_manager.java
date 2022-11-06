package com.example.concerto.pojo;

public class Station_manager {
    String uuid;
    Integer station_no;
    Integer manager_no;

    public Station_manager(String uuid, Integer station_no, Integer manager_no) {
        this.uuid = uuid;
        this.station_no = station_no;
        this.manager_no = manager_no;
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

    public Integer getManager_no() {
        return manager_no;
    }

    public void setManager_no(Integer manager_no) {
        this.manager_no = manager_no;
    }
}
