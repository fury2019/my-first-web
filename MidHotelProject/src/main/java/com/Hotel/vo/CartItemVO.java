package com.Hotel.vo;

public class CartItemVO {
    private String cartNo; // 장바구니 번호
    private String goodsId; // 상품 ID
    private int goodsAmt; // 수량
    private double goodsPrice; // 상품 가격

    // 생성자, getter, setter 메서드
    public CartItemVO(String cartNo, String goodsId, int goodsAmt, double goodsPrice) {
        this.cartNo = cartNo;
        this.goodsId = goodsId;
        this.goodsAmt = goodsAmt;
        this.goodsPrice = goodsPrice;
    }

    public String getCartNo() {
        return cartNo;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public int getGoodsAmt() {
        return goodsAmt;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }
}
