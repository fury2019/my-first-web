package com.Hotel.service.Goods;

import java.util.List;

import com.Hotel.dao.Goods.Goods_CartDaoImpl;
import com.Hotel.dao.Goods.IGoods_CartDao;
import com.Hotel.vo.Goods_CartVO;

public class Goods_CartServiceImpl implements IGoods_CartService {
	
	private IGoods_CartDao dao;
	private static Goods_CartServiceImpl service;
	
	private Goods_CartServiceImpl() {
		dao = Goods_CartDaoImpl.getInstance();
	}
	
	public static Goods_CartServiceImpl getInstance() {
		if(service==null) service = new Goods_CartServiceImpl();
		return service;
	}
	
	 @Override
	    public int insertGoods_Cart(Goods_CartVO goodsCVo) {
	        Goods_CartVO existingItem = dao.getCartByGoodsId(goodsCVo.getGoods_id(), goodsCVo.getMem_id());
	        
	        if (existingItem != null) {
	            // 이미 존재하면 수량 업데이트
	            existingItem.setGoods_amt(existingItem.getGoods_amt() + goodsCVo.getGoods_amt());
	            return dao.updateGoods_Cart(existingItem);
	        } else {
	            // 존재하지 않으면 새로 추가
	            return dao.insertGoods_Cart(goodsCVo);
	        }
	    }
	
	@Override
	public int updateGoods_Cart(Goods_CartVO GoodsCVo) {
		return dao.updateGoods_Cart(GoodsCVo);
	}
	
	@Override
	public int deleteGoods_Cart(String cartNo) {
		return dao.deleteGoods_Cart(cartNo);
	}

	@Override
	public List<Goods_CartVO> getAllGoodsCart(String memId) {
		return dao.getAllGoodsCart(memId);
	}

	@Override
	public Goods_CartVO getCart(String cartNo) {
	    return dao.getCart(cartNo); // DAO에서 장바구니 정보를 조회하는 메서드 호출
	}
	
	
}
