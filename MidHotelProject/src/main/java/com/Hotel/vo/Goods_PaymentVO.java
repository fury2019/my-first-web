package com.Hotel.vo;

public class Goods_PaymentVO {
    private String payId; // 필드 이름
    private String cart_no;
    private String goods_id;
    private int p_use_point;
    private String coupon_no;
    private int p_earn_point;
    private int p_tot_price;
    private int p_price;
    private String p_date;

    // 수정된 getter 메소드
    public String getPayId() { // 메소드 이름 수정
        return payId;
    }
    
    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getCart_no() {
        return cart_no;
    }

    public void setCart_no(String cart_no) {
        this.cart_no = cart_no;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public int getP_use_point() {
        return p_use_point;
    }

    public void setP_use_point(int p_use_point) {
        this.p_use_point = p_use_point;
    }

    public String getCoupon_no() {
        return coupon_no;
    }

    public void setCoupon_no(String coupon_no) {
        this.coupon_no = coupon_no;
    }

    public int getP_earn_point() {
        return p_earn_point;
    }

    public void setP_earn_point(int p_earn_point) {
        this.p_earn_point = p_earn_point;
    }

    public int getP_tot_price() {
        return p_tot_price;
    }

    public void setP_tot_price(int p_tot_price) {
        this.p_tot_price = p_tot_price;
    }

    public int getP_price() {
        return p_price;
    }

    public void setP_price(int p_price) {
        this.p_price = p_price;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }

    @Override
    public String toString() {
        return "Goods_PaymentVO [payId=" + payId + ", cart_no=" + cart_no + ", goods_id=" + goods_id
                + ", p_use_point=" + p_use_point + ", coupon_no=" + coupon_no + ", p_earn_point=" + p_earn_point
                + ", p_tot_price=" + p_tot_price + ", p_price=" + p_price + ", p_date=" + p_date + "]";
    }
}
