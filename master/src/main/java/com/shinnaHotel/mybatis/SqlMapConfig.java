package com.shinnaHotel.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	
	private static SqlSessionFactory factory;
	
	// 클래스 초기화 블럭 (클래스가 처음 로딩될 때 한번만 수행된다.)
	// 클래스가 로딩될 때 SqlSessionFactory 객체 생성
	static {
		
		try {
			//설정 파일의 경로 입력
			String resource = "./com/shinnaHotel/mybatis/config.xml";
			
			// 설정 파일의 경로 읽어오기
			Reader reader = Resources.getResourceAsReader(resource);

			// 리더로 읽어온 객체를 빌드
			factory = new SqlSessionFactoryBuilder().build(reader);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 클래스가 로딩될 때 만들어진 SqlFactory 객체를 리턴받는 메서드
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
