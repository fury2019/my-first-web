package com.Hotel.dao.reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.Hotel.common.util.MybatisUtil;
import com.Hotel.dao.reservation.IRoom_ServiceResDao;
import com.Hotel.vo.Room_ReservationVO;
import com.Hotel.vo.Room_ServiceVO;

public class Room_ServiceResDaoImpl implements IRoom_ServiceResDao {
	private static Room_ServiceResDaoImpl dao;
	
	private Room_ServiceResDaoImpl() {
		
	}
	
	public static Room_ServiceResDaoImpl getInstance() {
		if(dao == null)
			dao = new Room_ServiceResDaoImpl();
		return dao;
	}
	
	// 부가서비스 insert
	@Override
	public int insertService(Room_ServiceVO roomService) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("res.insertService", roomService);
			if(cnt>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			session.close();
		}
		
		return cnt;		
	}

	// 부가서비스 delete
	@Override
	public int deleteService(String resId) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			System.out.println("서비스 삭제");
			cnt = session.delete("res.deleteService", resId);
			
			if(cnt>0)
				session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			session.close();
		}
		
		return cnt;		
	}
	
	// 부가서비스 예약 내역 (객실예약번호에 맞춰서...)
	public List<Room_ServiceVO> getServiceRes(String resId){
		SqlSession session = null;
		List<Room_ServiceVO> serviceList = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			serviceList = session.selectList("res.getServiceRes",resId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
			session.close();
		}
	
		
		return serviceList;

		
	}
	
	public List<Room_ReservationVO> getServicePrice(Map<String, Object> params) {
	    SqlSession session = null;
	    List<Room_ReservationVO> servicePrices = null; // 리스트로 변경

	    try {
	        session = MybatisUtil.getSqlSession();
	        String mem_id = (String) params.get("mem_id");
	        String r_res_no = (String) params.get("r_res_no");
	        // selectList 메서드를 사용하여 여러 행을 조회
	        
	        // 디버깅 로그
	        System.out.println("mem_id: " + mem_id);
	        System.out.println("r_res_no: " + r_res_no);

	        // params 맵을 사용하여 쿼리 실행
	        servicePrices = session.selectList("res.getServicePrice", params);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }

	    return servicePrices; // 리스트 반환
	}

}
