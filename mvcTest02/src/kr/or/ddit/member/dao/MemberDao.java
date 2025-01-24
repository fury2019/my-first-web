package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.util.DBUtil3;
import kr.or.ddit.member.vo.MemberVO;
/**
 * DAO객체 - 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서
 * 			Service에게 전달하는 역할을 수행하는 객체
 * 
 * 		 - 이 클래스의 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 */

public class MemberDao {

	public int insertMember(MemberVO memVo) {
		int cnt = 0;		// 반환값이 저장될 변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "insert into mymember"
					   + "(mem_id, mem_pass, mem_name, mem_tel, mem_addr) "
					   + "values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			// 매개변수로 받은 VO객체에서 자료를 꺼내와 ?자리에 셋팅한다
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		return cnt;
	}
	
	public int deleteMember(String memId) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
			try {
				conn = DBUtil3.getConnection();
				
				String sql = "delete from mymember where mem_id = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				
				cnt = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
				if(conn!=null) try { conn.close(); }catch(SQLException e) {}
			}
		return cnt;
	}
	
	public int updateMember(MemberVO memVo) {
		
		return 0;
	}
	
	public List<MemberVO> getAllMember(){
		return null;
		
	}
	

	    // 회원 ID의 개수를 반환하는 메서드
	    public int getMemberCount(String memId) {
	        int count = 0;

	        // SQL 쿼리
	        String sql = "SELECT COUNT(*) cnt FROM MYMEMBER "
					+ " WHERE MEM_ID = ?";
	        
	        try {
	            // DB 연결 가져오기
	            Connection conn = DBUtil3.getConnection();
	            // PreparedStatement 객체 생성
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	         
	            // 쿼리의 매개변수 설정
	            pstmt.setString(1, memId);

	            // 쿼리 실행
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    // 결과를 count 변수에 저장
	                    count = rs.getInt(1);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        // 로그 출력
	        System.out.println("확인할 회원 ID: " + memId + ", 개수: " + count);
	        return count;
	    }
	


}
