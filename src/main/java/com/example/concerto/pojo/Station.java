package com.example.concerto.pojo;

public class Station {
    Integer id;
    Integer stationNo;
    String address;
    String name;

    public Station(Integer id, Integer stationNo, String address, String name) {
        this.id = id;
        this.stationNo = stationNo;
        this.address = address;
        this.name = name;
    }

    public Station() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStationNo() {
        return stationNo;
    }

    public void setStationNo(Integer stationNo) {
        this.stationNo = stationNo;
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

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationNo=" + stationNo +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
