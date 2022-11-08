package com.example.concerto.pojo;

public class Express {
    Integer id;
    Integer express_no;
    String express_company;
    String product_link;
    String sender_tel;
    String recipient_tel;
    String sender_name;
    String recipient_name;
    String sender_address;
    String recipient_address;
    Integer status;

    public Express(Integer id, Integer express_no, String express_company, String product_link, String sender_tel, String recipient_tel, String sender_name, String recipient_name, String sender_address, String recipient_address, Integer status) {
        this.id = id;
        this.express_no = express_no;
        this.express_company = express_company;
        this.product_link = product_link;
        this.sender_tel = sender_tel;
        this.recipient_tel = recipient_tel;
        this.sender_name = sender_name;
        this.recipient_name = recipient_name;
        this.sender_address = sender_address;
        this.recipient_address = recipient_address;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExpress_no() {
        return express_no;
    }

    public void setExpress_no(Integer express_no) {
        this.express_no = express_no;
    }

    public String getExpress_company() {
        return express_company;
    }

    public void setExpress_company(String express_company) {
        this.express_company = express_company;
    }

    public String getProduct_link() {
        return product_link;
    }

    public void setProduct_link(String product_link) {
        this.product_link = product_link;
    }

    public String getSender_tel() {
        return sender_tel;
    }

    public void setSender_tel(String sender_tel) {
        this.sender_tel = sender_tel;
    }

    public String getRecipient_tel() {
        return recipient_tel;
    }

    public void setRecipient_tel(String recipient_tel) {
        this.recipient_tel = recipient_tel;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getRecipient_name() {
        return recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        this.recipient_name = recipient_name;
    }

    public String getSender_address() {
        return sender_address;
    }

    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
    }

    public String getRecipient_address() {
        return recipient_address;
    }

    public void setRecipient_address(String recipient_address) {
        this.recipient_address = recipient_address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
