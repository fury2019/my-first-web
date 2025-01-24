package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesIOTest01 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		// 저장할 properties파일 정보를 갖는 File객체 생성
		File f =new File("res/kr/or/ddit/config/memo.properties");
		
		FileOutputStream fout = null;
		
		try {
			// Properties객체에 데이터 추가하기
			prop.setProperty("name", "홍길동");
			prop.setProperty("age", String.valueOf(20));
			prop.setProperty("tel", "010-1234-5678");
			prop.setProperty("addr", "대전시 중구 오류동");
			
			// Properties객체에 저장된 데이터를 저장할 출력 스트림 객체 생성
			fout = new FileOutputStream(f);
			
			// 파일로 저장하기
			prop.store(fout, "이 내용은 주석글 입니다.");
			System.out.println("출력 작업 완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fout!=null) try { fout.close(); }catch(IOException e) {}
		}
	}
}
