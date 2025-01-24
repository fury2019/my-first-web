package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class Log4jTest {
	
	// Logger 클래스의 인스턴스를 구한다.
	static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		// 로그 메시지 출력하기
		// 형식) Logger객체.로그레벨이름(메시지);
		logger.trace("이것은 Log4J의 trace레벨의 메시지입니다.");
		logger.debug("이것은 debug레벨의 메시지");
		logger.info("info레벨의 Log4J 메시지입니다.");
		logger.warn("Log4J의 warn레벨 메시지");
		logger.error("오류관련 error레벨 메시지입니다.");
		logger.fatal("이것은 fatal레벨의 메시지입니다.");
		
		System.out.println("작업끝");
	}
}
