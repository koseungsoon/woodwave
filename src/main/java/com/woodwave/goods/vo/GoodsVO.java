package com.woodwave.goods.vo;

import org.springframework.stereotype.Component;

@Component
public class GoodsVO {

    //필드
    private int goods_id;
    private String goods_sort;
    private String goods_status;
    private String goods_title;
    private String goods_info;
    private int goods_sales_price;

    private String goods_fileName;

    private int goods_delivery_price;
    private String goods_size;
    private int goods_leadtime;

    //생성자
    public GoodsVO() {

    }

    //메서드


    public String getGoods_fileName() {
        return goods_fileName;
    }

    public void setGoods_fileName(String goods_fileName) {
        this.goods_fileName = goods_fileName;
    }






    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_sort() {
        return goods_sort;
    }

    public void setGoods_sort(String goods_sort) {
        this.goods_sort = goods_sort;
    }

    public String getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(String goods_status) {
        this.goods_status = goods_status;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }

    public int getGoods_sales_price() {
        return goods_sales_price;
    }

    public void setGoods_sales_price(int goods_sales_price) {
        this.goods_sales_price = goods_sales_price;
    }

    public int getGoods_delivery_price() {
        return goods_delivery_price;
    }

    public void setGoods_delivery_price(int goods_delivery_price) {
        this.goods_delivery_price = goods_delivery_price;
    }

    public String getGoods_size() {
        return goods_size;
    }

    public void setGoods_size(String goods_size) {
        this.goods_size = goods_size;
    }

    public int getGoods_leadtime() {
        return goods_leadtime;
    }

    public void setGoods_leadtime(int goods_leadtime) {
        this.goods_leadtime = goods_leadtime;
    }
}
