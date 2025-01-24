package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.util.DBUtil;

/*
 	Member테이블에서 주소가 '충남'인 사람의 id, 이름, password, 주소를 출력하시오.
 	
 	
 */
public class JdacTest02 {
	public static void main(String[] args) {

		// DB작업에 필요한 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB 연결 ==> Connection 객체 생성
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1588/FREEPDB1", "KHS", "java");
			DBUtil.getConnection();
			// 3. 질의

			// 3-1. SQL문 작성
			String sql = "SELECT mem_id, mem_name, mem_pass, mem_add1\r\n"
					+ "FROM Member\r\n"
					+ "WHERE mem_add1 LIKE '%충남%' ";

			// 3-2. PreparedStatement객체 생성 ==> 질의 하는 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3-3. SQL문을 DB서버로 보내서 결과를 얻어온다.
			// (실행할 SQL문이 select문이기 때문에 실행 결과가
			// ResultSet객체에 저장되어 반환된다.)
			rs = pstmt.executeQuery();

			// 4. 결과 처리 ==> 한 레코드씩 화면에 출력하기

			// ResultSet에 저장된 데이터를 차례로 꺼내오려면
			// 반복문과 next()메서드를 이용한다.
			System.out.println("== 쿼리문 처리 결과 ==");

			// ResultSet객체의 next()메서드
			// ==> 데이터를 가리키는 포인터를 다음번째 레코드로 이동시키고
			// 그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.
			while (rs.next()) {
				// 포인터가 가리키는 곳의 자료 가져오기
				// 형식1) ResultSet객체.get자료형이름("컬럼명");
				// 형식2) ResultSet객체.get자료형이름("엘리어스명");
				// 형식3) ResultSet객체.get자료형이름(컬럼번호);
				// ==> 컬럼 번호는 1부터 시작한다.
				System.out.println("MEM_ID : " + rs.getString("MEM_ID"));
				System.out.println("MEM_NAME : " + rs.getString("MEM_NAME"));
				System.out.println("MEM_PASS : " + rs.getString(2));
				System.out.println("mem_add1 : " + rs.getString("mem_add1"));
				System.out.println("---------------------------------------");
			}
			System.out.println("출력 끝...");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
		}
	}
}
