package com.example.concerto.pojo;

public class StationCourier {
    Integer id;
    Integer stationNo;
    Integer courierNo;

    public StationCourier(Integer id, Integer stationNo, Integer courierNo) {
        this.id = id;
        this.stationNo = stationNo;
        this.courierNo = courierNo;
    }

    public StationCourier() {
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

    public Integer getCourierNo() {
        return courierNo;
    }

    public void setCourierNo(Integer courierNo) {
        this.courierNo = courierNo;
    }

    @Override
    public String toString() {
        return "StationCourier{" +
                "id=" + id +
                ", stationNo=" + stationNo +
                ", courierNo=" + courierNo +
                '}';
    }
}
