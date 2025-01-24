package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			System.out.println("드라이버 로딩 실패---");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null; // 기본값 null설정
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1588/FREEPDB1", "KHS", "java");
					
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 ---");
			e.printStackTrace();
		}
		return conn; // conn을 반환하여 다른 코드에서 그 연결을 사용할 수 있도록 하는 것
	}
}
