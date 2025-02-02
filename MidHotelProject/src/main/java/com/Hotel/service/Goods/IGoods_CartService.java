package com.Hotel.service.Goods;

import java.util.List;

import com.Hotel.vo.Goods_CartVO;

public interface IGoods_CartService {

	public int insertGoods_Cart(Goods_CartVO GoodsCVo);
	
	public int deleteGoods_Cart(String GoodsCNo);
	
	public int updateGoods_Cart(Goods_CartVO GoodsCVo);

	public List<Goods_CartVO> getAllGoodsCart(String memId);
	
	public Goods_CartVO getCart(String cartNo);
}
