package com.example.concerto.pojo;

public class StationExpress {
    Integer id;
    Integer stationNo;
    Integer expressNo;

    public StationExpress(Integer id, Integer stationNo, Integer expressNo) {
        this.id = id;
        this.stationNo = stationNo;
        this.expressNo = expressNo;
    }

    public StationExpress() {
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

    public Integer getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(Integer expressNo) {
        this.expressNo = expressNo;
    }

    @Override
    public String toString() {
        return "StationExpress{" +
                "id=" + id +
                ", stationNo=" + stationNo +
                ", expressNo=" + expressNo +
                '}';
    }
}
