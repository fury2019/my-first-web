package com.Hotel.dao.FAQ;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.FAQVO;

public class FAQDaoImpl implements IFAQDao {
	
	private static FAQDaoImpl dao;

	private FAQDaoImpl() {   }
	
	public static IFAQDao getInstance() {
		if(dao==null) dao = new FAQDaoImpl();
		
		return dao;
	}
	
	@Override
	public int insertFAQ(FAQVO faqVo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0; 
		try {
			String faqNo = session.selectOne("FAQ.getNextFaqNo");
			faqVo.setFaq_no(faqNo);
			
			cnt = session.insert("FAQ.insertFAQ", faqVo);
			if(cnt>0) session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteFAQ(String faq_No) {
		
		SqlSession session = MybatisUtil.getSqlSession(); 
		
		int cnt = 0;
		
		try {
			cnt = session.delete("FAQ.deleteFAQ", faq_No);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int updateFAQ(FAQVO faqVo) {
		SqlSession session = MybatisUtil.getSqlSession();  
		
		int cnt = 0;
		
		try {
			cnt = session.update("FAQ.updateFAQ", faqVo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public List<FAQVO> getAllFAQ() {

		SqlSession session = MybatisUtil.getSqlSession();  
		
		List<FAQVO> FAQList = null;
		
		try {

			FAQList = session.selectList("FAQ.getAllFAQ");
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return FAQList;
	}

	@Override
	public int getFAQCount(String faq_title) {
		SqlSession session = MybatisUtil.getSqlSession(); 
		
		int count = 0;
		
		try {
			count = session.selectOne("FAQ.getFAQCount", faq_title);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		
		return count;
	}
	
	@Override
	public FAQVO getFAQ(String faqNo) {
		SqlSession session = MybatisUtil.getSqlSession(); 

		FAQVO faqVo = null;

		try {
			faqVo = session.selectOne("FAQ.getFAQ", faqNo);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if(session != null) session.close();
	    } 
	    return faqVo;
	    		
		
	}

	@Override
	public List<FAQVO> getClassFAQ(String class_id) {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<FAQVO> faqVo = null;
		
		try {
			faqVo = session.selectList("FAQ.getClassFAQ", class_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return faqVo;
	}

}
