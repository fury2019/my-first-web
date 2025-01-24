package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {
	public static void main(String[] args) {
		// 파일 내용 읽기 - 바이트 기반 스트림 이용
		try {
			// 읽어올 파일을 매개변수로 받는 FileInputStream객체 생성
			
			// 방법1 ==> 읽어올 파일 정보를 문자열로 지정하는 방법
			//FileInputStream fin = new FileInputStream("d:/d_other/test.txt");
			
			// 방법2 ==> 읽어올 파일 정보를 File객체로 지정하는 방법
			File file = new File("d:/d_other/test.txt");
			FileInputStream fin = new FileInputStream(file);
			
			int c;	// 읽어온 자료가 저장될 변수 
			
			while((c = fin.read()) != -1) {	// 한 번에 1byte씩 읽어오기
				
				// 읽어온 자료를 화면에 출력하기 
				System.out.print((char)c);
			}
			
			// 작업 완료 후 스트림 닫기
			fin.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다");
			e.printStackTrace();
		}
	}
}
