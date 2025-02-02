package com.Hotel.dao.Goods;

import java.util.List;

import com.Hotel.vo.Goods_CartVO;

public interface IGoods_CartDao {
	
	public int insertGoods_Cart(Goods_CartVO GoodsCVo);
	
	public int deleteGoods_Cart(String GoodsCNo);
	
	public int updateGoods_Cart(Goods_CartVO GoodsCVo);

	public List<Goods_CartVO> getAllGoodsCart(String memId);
	
	public Goods_CartVO getCart(String cartNo);
	
	public Goods_CartVO getCartByGoodsId(String goodsId, String memId);
}
