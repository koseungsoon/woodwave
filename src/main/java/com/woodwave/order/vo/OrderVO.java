package com.woodwave.order.vo;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class OrderVO {

    private int order_sec_num;
    private int order_id;
    private int goods_id;
    private String goods_title;
    private int goods_sales_price;
    private int order_goods_qty;
    private String delivery_state;
    private String member_id;
    private String member_phone;
    private String receiver_name;
    private String receiver_phone;
    private String delivery_address;
    private String pay_method;
    private String card_company;
    private Date pay_order_time;

    public OrderVO() {
    }

    public OrderVO(int order_sec_num, int order_id, int goods_id, String goods_title, int goods_sales_price, int order_goods_qty, String delivery_state, String member_id, String member_phone, String receiver_name, String receiver_phone, String delivery_address, String pay_method, String card_company, Date pay_order_time) {
        this.order_sec_num = order_sec_num;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.goods_title = goods_title;
        this.goods_sales_price = goods_sales_price;
        this.order_goods_qty = order_goods_qty;
        this.delivery_state = delivery_state;
        this.member_id = member_id;
        this.member_phone = member_phone;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.delivery_address = delivery_address;
        this.pay_method = pay_method;
        this.card_company = card_company;
        this.pay_order_time = pay_order_time;
    }

    public int getOrder_sec_num() {
        return order_sec_num;
    }

    public void setOrder_sec_num(int order_sec_num) {
        this.order_sec_num = order_sec_num;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public int getGoods_sales_price() {
        return goods_sales_price;
    }

    public void setGoods_sales_price(int goods_sales_price) {
        this.goods_sales_price = goods_sales_price;
    }

    public int getOrder_goods_qty() {
        return order_goods_qty;
    }

    public void setOrder_goods_qty(int order_goods_qty) {
        this.order_goods_qty = order_goods_qty;
    }

    public String getDelivery_state() {
        return delivery_state;
    }

    public void setDelivery_state(String delivery_state) {
        this.delivery_state = delivery_state;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getCard_company() {
        return card_company;
    }

    public void setCard_company(String card_company) {
        this.card_company = card_company;
    }

    public Date getPay_order_time() {
        return pay_order_time;
    }

    public void setPay_order_time(Date pay_order_time) {
        this.pay_order_time = pay_order_time;
    }
}
