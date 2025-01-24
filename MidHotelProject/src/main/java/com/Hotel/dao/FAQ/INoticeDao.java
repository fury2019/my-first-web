package com.Hotel.dao.FAQ;

import java.util.List;

import com.Hotel.vo.NoticeVO;

public interface INoticeDao {

	public List<NoticeVO> getAllNotice();
	
	public List<NoticeVO> getClassNotice(String class_id);
	
	public int insertNotice(NoticeVO noticeVo);
	
	public int deleteNotice(String noticeNo);
	
	public int updateNotice(NoticeVO noticeVo);
	
	public NoticeVO getNotice(String noticeNo);
	
}
