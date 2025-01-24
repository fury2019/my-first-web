package com.shinnaHotel.DAO;

import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.shinnaHotel.DTO.UsersDTO;
import com.shinnaHotel.mybatis.SqlMapConfig;

public class UsersDAO {

	
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public UsersDAO() {
		sqlSession = factory.openSession(true);
	}
	
	// 회원가입
	public boolean insertUsers(UsersDTO userdto) {
		boolean result = false;
		
		if(sqlSession.insert("User.insertUsers", userdto) == 1) {
			result = true;
		}
		
		return result;		
	}
	
	// 로그인
	public boolean login(String u_id, String u_password) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("u_id", u_id);
		datas.put("u_password", u_password);
		boolean result = false;		
		if((Integer)sqlSession.selectOne("User.login",datas) == 1) {
			result = true;
		}
		return result;		
	}
	
	// 내정보관리
	public List<UsersDTO> getInfo(String u_id) {
		List<UsersDTO> info = sqlSession.selectList("User.userInfo",u_id);		
		return info;
	}
	
	// 내정보 수정
	public boolean userUpdate(UsersDTO udto) {
		boolean result = false;		
		if(sqlSession.update("User.updateUser", udto) != 0) {
			result = true;
		}		
		return result;
	}
	
	// 회원탈퇴 예약내역 조회 
	public boolean withdrawSelect(String u_id) {		
		boolean result = false; 
		if((Integer)sqlSession.selectOne("User.selectExist" , u_id) != 0) {
			result = true;
		}
		return result;
	}

	public boolean withdrawOkupdate(String u_id) {
		boolean result = false;
		
		if(sqlSession.update("User.updateWithdraw", u_id) != 0 ) {
			result = true;
		}
		
		return result;
	}

	//중복체크
	public boolean idCheck(String u_id) {
        boolean result = false;
        int cnt = 0;

         cnt = sqlSession.selectOne("User.idCheck", u_id);

         if(cnt >= 1) { // 같은 아이디가 있다면
             result = true;
         }else { // 같은 아이디가 없다면
             result = false;
         }

        return result;
    }

}

