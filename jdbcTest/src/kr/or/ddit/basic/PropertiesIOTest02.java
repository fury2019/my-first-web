package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesIOTest02 {
	
	public static void main(String[] args) {
		// properties파일의 내용을 읽어오기
		
		Properties prop = new Properties();
		
		//읽어올 properties파일 정보를 갖는 File객체 새엇ㅇ
		File f= new File("res/kr/or/ddit/config/memo.properties");
		
		FileInputStream fin = null;
		
		try {
			// properties파일을 읽어올 스트림 객체 생성
			fin = new FileInputStream(f);
			
			// 입력 스트림을 이용하여 파일 내용을 읽어와
			//Properties객체에 저장하기
			prop.load(fin);	// 파일 내용을 읽어오 key값과 value값을
							// 분리해서 Properties 객체에 저장한다.
			
			// 읽어온 정보 출력해보기
			System.out.println("name : " + prop.getProperty("name"));
			System.out.println("age : " + prop.getProperty("age"));
			System.out.println("tel : " + prop.getProperty("tel"));
			System.out.println("addr : " + prop.getProperty("addr"));
			System.out.println("--------------------------------------");
			System.out.println("읽기 작업 완료");
			
		} catch (IOException e) {
			// TODO: handle exception
		}finally {
			if(fin!=null) try { fin.close(); }catch(IOException e) {}
		}
		
	}
}
