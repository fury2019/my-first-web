package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class FileIOTest02 {
	public static void main(String[] args) {
		// 파일 내용 쓰기 - 바이트 기반 스트림 이용
		
		try {
			// 파일 출력용 스트림 객체 생성 == 생성자에 출력할 파일 정보를 
			// 	                         매개변수로 저장한다.
			
			// 방법1
			FileOutputStream fout = new FileOutputStream("d:/d_other/out.txt");
			
			// 방법2
//			File file = new File("d:/d_other/out.txt");
//			FileOutputStream fout = new FileOutputStream(file);
			
			for(char ch='A'; ch<='Z'; ch++) {
				fout.write(ch);
			}
			fout.write('\r');
			fout.write('\n');
			for(char ch='a'; ch<='z'; ch++) {
				fout.write(ch);
			}
			
			System.out.println("파일 쓰기 작업 완료");
			
			fout.close();	//스트림 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
