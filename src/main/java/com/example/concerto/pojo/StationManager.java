package com.example.concerto.pojo;

public class StationManager {
    Integer id;
    Integer stationNo;
    Integer managerNo;

    public StationManager(Integer id, Integer stationNo, Integer managerNo) {
        this.id = id;
        this.stationNo = stationNo;
        this.managerNo = managerNo;
    }

    public StationManager() {
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

    public Integer getManagerNo() {
        return managerNo;
    }

    public void setManagerNo(Integer managerNo) {
        this.managerNo = managerNo;
    }

    @Override
    public String toString() {
        return "StationManager{" +
                "id=" + id +
                ", stationNo=" + stationNo +
                ", managerNo=" + managerNo +
                '}';
    }
}
