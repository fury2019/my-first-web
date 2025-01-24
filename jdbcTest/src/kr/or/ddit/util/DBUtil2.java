package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// dbinfo.properties파일에 저장될 DB정보를 이용하여 설정하기

// 방법1) Properties 객체를 이용하기  

public class DBUtil2 {
	private static Properties prop;	// Properties 객체 변수 선언
	
	static {
		prop = new Properties(); // Properties 객체 생성
		File f =new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		
		
		try {
			// 입력용 스트림 객체 생성
			fin = new FileInputStream(f);
			
			prop.load(fin);  // 파일 내용 읽기
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName( prop.getProperty("driver") );
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패---");
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null; // 기본값 null설정
		try {
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1588/FREEPDB1", "KHS", "java");
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass"));
					
					
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 ---");
			e.printStackTrace();
		}
		return conn; // conn을 반환하여 다른 코드에서 그 연결을 사용할 수 있도록 하는 것
	}
}
