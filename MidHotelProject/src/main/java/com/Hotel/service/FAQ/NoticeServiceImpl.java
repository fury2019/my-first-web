package com.Hotel.service.FAQ;

import java.util.List;

import com.Hotel.dao.FAQ.INoticeDao;
import com.Hotel.dao.FAQ.NoticeDaoImpl;
import com.Hotel.vo.NoticeVO;

public class NoticeServiceImpl implements INoticeService {
	
	private INoticeDao dao;
	private static NoticeServiceImpl service;
	
	private NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if(service==null) service = new NoticeServiceImpl();
		return service;
	}

	@Override
	public List<NoticeVO> getAllNotice() {
		return dao.getAllNotice();
	}

	@Override
	public List<NoticeVO> getClassNotice(String class_id) {
		return dao.getClassNotice(class_id);
	}

	@Override
	public int insertNotice(NoticeVO noticeVo) {
		return dao.insertNotice(noticeVo);
	}

	@Override
	public int deleteNotice(String noticeNo) {
		return dao.deleteNotice(noticeNo);
	}

	@Override
	public int updateNotice(NoticeVO noticeVo) {
		return dao.updateNotice(noticeVo);
	}

	@Override
	public NoticeVO getNotice(String noticeNo) {
		return dao.getNotice(noticeNo);
	}

}
