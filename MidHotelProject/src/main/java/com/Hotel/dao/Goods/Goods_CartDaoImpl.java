package com.Hotel.dao.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.Goods_CartVO;

public class Goods_CartDaoImpl implements IGoods_CartDao {
	
	private static Goods_CartDaoImpl dao;
	
	private Goods_CartDaoImpl() {}
	
	public static IGoods_CartDao getInstance() {
		if(dao == null) dao = new Goods_CartDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertGoods_Cart(Goods_CartVO goodsCVo) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    int cnt = 0; 

	    try {
	        int nextCartNo = session.selectOne("Goods_Cart.getNextGoodsCartNo");
	        goodsCVo.setCart_no(String.valueOf(nextCartNo));
	        cnt = session.insert("Goods_Cart.insertGoodsCart", goodsCVo);
	        if (cnt > 0) session.commit();
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 처리 개선 가능
	    } finally {
	        if (session != null) session.close();
	    }

	    return cnt;
	}

	@Override
	public int deleteGoods_Cart(String GoodsCNo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.delete("Goods_Cart.deleteGoodsCart", GoodsCNo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int updateGoods_Cart(Goods_CartVO GoodsCVo) {
		SqlSession session = MybatisUtil.getSqlSession();  
		
		int cnt = 0;
		
		try {
			cnt = session.update("Goods_Cart.updateGoodsCart", GoodsCVo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public List<Goods_CartVO> getAllGoodsCart(String memId) {
	    SqlSession session = MybatisUtil.getSqlSession();  
	    List<Goods_CartVO> goodsCartList = new ArrayList<>();

	    try {
	        goodsCartList = session.selectList("Goods_Cart.getAllGoodsCart", memId);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    } 

	    return goodsCartList;
	}

	@Override
	public Goods_CartVO getCart(String cartNo) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    Goods_CartVO goodsCVo = null;

	    try {
	        goodsCVo = session.selectOne("Goods_Cart.getCart", cartNo); // SQL 매핑 ID 사용
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    }

	    return goodsCVo;
	}
	
	@Override
	public Goods_CartVO getCartByGoodsId(String goodsId, String memId) {
	    SqlSession session = MybatisUtil.getSqlSession();
	    Goods_CartVO cartItem = null;
	    try {
	        cartItem = session.selectOne("Goods_Cart.getCartByGoodsId", new HashMap<String, String>() {{
	            put("goodsId", goodsId);
	            put("memId", memId);
	        }});
	    } finally {
	        session.close();
	    }
	    return cartItem;
	}
	
}