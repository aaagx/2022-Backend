package com.example.concerto.pojo;

public class Express {
    Integer expressNo;
    String expressCompany;
    String productLink;
    String senderTel;
    String recipientTel;
    String senderName;
    String recipientName;
    String senderAddress;
    String recipientAddress;
    Integer status;

    public Express(Integer expressNo, String expressCompany, String productLink, String senderTel, String recipientTel, String senderName, String recipientName, String senderAddress, String recipientAddress, Integer status) {
        this.expressNo = expressNo;
        this.expressCompany = expressCompany;
        this.productLink = productLink;
        this.senderTel = senderTel;
        this.recipientTel = recipientTel;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.status = status;
    }

    public Express() {
    }

    public Integer getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(Integer expressNo) {
        this.expressNo = expressNo;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getRecipientTel() {
        return recipientTel;
    }

    public void setRecipientTel(String recipientTel) {
        this.recipientTel = recipientTel;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Express{" +
                "expressNo=" + expressNo +
                ", expressCompany='" + expressCompany + '\'' +
                ", productLink='" + productLink + '\'' +
                ", senderTel='" + senderTel + '\'' +
                ", recipientTel='" + recipientTel + '\'' +
                ", senderName='" + senderName + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", status=" + status +
                '}';
    }
}
