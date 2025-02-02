package com.Hotel.service.FAQ;

import java.util.List;

import com.Hotel.vo.FAQVO;

public interface IFAQService {

	public int insertFAQ(FAQVO faqVo);
	
	public int deleteFAQ(String faqNo);

	public int updateFAQ(FAQVO faqVo);
	
	public List<FAQVO> getAllFAQ();
	
	public int getFAQCount(String faq_title);
	
	public FAQVO getFAQ(String faqNo);

	public List<FAQVO> getClassFAQ(String class_id);
	
	
}
