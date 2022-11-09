package com.example.concerto.pojo;

public class CourierExpress {
    Integer id;
    Integer courierNo;
    Integer expressNo;

    public CourierExpress(Integer id, Integer courierNo, Integer expressNo) {
        this.id = id;
        this.courierNo = courierNo;
        this.expressNo = expressNo;
    }

    public CourierExpress() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourierNo() {
        return courierNo;
    }

    public void setCourierNo(Integer courierNo) {
        this.courierNo = courierNo;
    }

    public Integer getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(Integer expressNo) {
        this.expressNo = expressNo;
    }

    @Override
    public String toString() {
        return "CourierExpress{" +
                "id=" + id +
                ", courierNo=" + courierNo +
                ", expressNo=" + expressNo +
                '}';
    }
}
