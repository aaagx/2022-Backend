package com.example.concerto.pojo;

public class Station {
    Integer id;
    Integer station_no;
    String address;
    String name;

    public Station(Integer id, Integer station_no, String address, String name) {
        this.id = id;
        this.station_no = station_no;
        this.address = address;
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
