package com.Hotel.dao.FAQ;

import java.util.List;

import com.Hotel.vo.FAQVO;

public interface IFAQDao {
	
	public int insertFAQ(FAQVO faqVo);

	public int deleteFAQ(String faq_No);

	public int updateFAQ(FAQVO faqVo);

	public List<FAQVO> getAllFAQ();

	public int getFAQCount(String faq_title);
	
	public FAQVO getFAQ(String faqNo);
	
	public List<FAQVO> getClassFAQ(String class_id);
	
}