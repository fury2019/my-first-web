package com.Hotel.dao.FAQ;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.vo.FAQVO;
import com.Hotel.vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao {

	private static NoticeDaoImpl dao;
	
	private NoticeDaoImpl() {  }
	
	public static INoticeDao getInstance() {
		if(dao==null) dao = new NoticeDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<NoticeVO> getAllNotice() {
		
		SqlSession session = null;
		
		List<NoticeVO> noticeList = null;
		
		try {
			
			session = MybatisUtil.getSqlSession();
			
			noticeList = session.selectList("notice.getAllNotice");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return noticeList;
	}

	@Override
	public List<NoticeVO> getClassNotice(String class_id) {
		SqlSession session = null;
		
		List<NoticeVO> noticeVo = null;
		
		try {
			
			session = MybatisUtil.getSqlSession();
			
			noticeVo = session.selectList("notice.getClassNotice", class_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return noticeVo;
	}

	@Override
	public int insertNotice(NoticeVO noticeVo) {
		
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			String noticeNo = session.selectOne("notice.getNextNoticeNo");
			noticeVo.setNotice_no(noticeNo);
			
			cnt = session.insert("notice.insertNotice", noticeVo);
			if(cnt>0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteNotice(String noticeNo) {
		
		SqlSession session = MybatisUtil.getSqlSession(); 
		
		int cnt = 0;
		
		try {
			cnt = session.delete("notice.deleteNotice", noticeNo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO noticeVo) {
		SqlSession session = MybatisUtil.getSqlSession();  
		
		int cnt = 0;
		
		try {
			cnt = session.update("notice.updateNotice", noticeVo);
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public NoticeVO getNotice(String noticeNo) {
		
		SqlSession session = MybatisUtil.getSqlSession(); 
		
		NoticeVO noticeVo = null;
		
		try {
			
			noticeVo = session.selectOne("notice.getNotice", noticeNo);
			
		} catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if(session != null) session.close();
	    } 
	    return noticeVo;
	}
	
	
	
	
	
}
