package com.Hotel.service.FAQ;

import java.util.List;

import com.Hotel.dao.FAQ.FAQDaoImpl;
import com.Hotel.dao.FAQ.IFAQDao;
import com.Hotel.vo.FAQVO;

public class FAQServiceImpl implements IFAQService {
	
	private IFAQDao dao;
	private static FAQServiceImpl service;
	
	
	private FAQServiceImpl() {
		dao = FAQDaoImpl.getInstance();
	}
	
	public static FAQServiceImpl getInstance() {
		if(service==null) service = new FAQServiceImpl();
		return service;
	}
	
	@Override
	public int insertFAQ(FAQVO faqVo) {
		return dao.insertFAQ(faqVo);
	}

	@Override
	public int deleteFAQ(String faq_No) {
		return dao.deleteFAQ(faq_No);
	}

	@Override
	public int updateFAQ(FAQVO faqVo) {
		return dao.updateFAQ(faqVo);
	}

	@Override
	public List<FAQVO> getAllFAQ() {
		return dao.getAllFAQ();
	}

	@Override
	public int getFAQCount(String faq_title) {
		return dao.getFAQCount(faq_title);
	}
	
	@Override
	public FAQVO getFAQ(String faqNo) {
		return dao.getFAQ(faqNo);

	}

	@Override
	public List<FAQVO> getClassFAQ(String class_id) {
		return dao.getClassFAQ(class_id);
	}

}
