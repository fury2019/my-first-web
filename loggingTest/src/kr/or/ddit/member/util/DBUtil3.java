package kr.or.ddit.member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;


//dbinfo.properties파일에 저장될 DB정보를 이용하여 설정하기

//방법2) ResourceBundle 객체를 이용하기  

public class DBUtil3 {
	private static final Logger logger = Logger.getLogger(DBUtil3.class);
	
	private static ResourceBundle bundle;	// ResourceBundle객체 변수 선언
	
	static {
		// 객체 생성 및 자료 읽어오기
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		logger.info("ResourceBundle객체 생성 - dbinfo.properties파일 읽기");
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Class.forName(bundle.getString("driver"));
			logger.debug("DB 드라이버 로딩 성공");
			
			
		}catch (Exception e) {
			//System.out.println("드라이버 로딩 실패---");
			logger.error("드라이버 로딩 실패", e);
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null; // 기본값 null설정
		try {
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1588/FREEPDB1", "KHS", "java");
			
			conn = DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));	
			logger.debug("DB 연결 성공 - Connection객체 생성 완료");
					
		} catch (SQLException e) {
//			System.out.println("DB 연결 실패 ---");
			logger.error("DB 연결 실패", e);
			e.printStackTrace();
		}
		return conn; // conn을 반환하여 다른 코드에서 그 연결을 사용할 수 있도록 하는 것
	}
}
