package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIOTest07 {
	public static void main(String[] args) {
		// 파일을 읽어올 때 인코딩 방식을 지정해서 읽어오기
		
		try {
			/*
//			FileReader fr = new FileReader("d:/d_other/test_utf8.txt");
			FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
			
			int c;
			
			while((c=fr.read()) != -1) {
				System.out.print( (char)c );
			}
			
			fr.close();
			*/
			
			//-------------------------------------------------------
			// 인코딩 방식을 지정해서 읽어오려면 InputStreamReader객체를 
			// 이용해야 한다.
			
			FileInputStream fin = new FileInputStream("d:/d_other/test_utf8.txt");
			
			// 인코딩 방식을 지정해서 InputStreamReader객체 생성하기
			
			// 인코딩 방식 예시
			// - MS949 또는 CP949 ==> 윈도우의 기본 한글 인코딩 방식(ANSI방식과 같다.)
			// - UTF-8			 ==> 유니코드 UTF-8 인코딩 방식
			// - US-ASCII		 ==> 영문 전용 인코딩 방식
			
			// 인코딩 방식을 지정하지 않으면 기본 인코딩 방식으로 읽어온다.
//			InputStreamReader isr = new InputStreamReader(fin);
			
			// 인코딩 방식을 지정해서 생성
//			InputStreamReader isr = new InputStreamReader(fin, "ms949");
			InputStreamReader isr = new InputStreamReader(fin, "utf-8");
			
			int c;
			
			while((c=isr.read()) != -1) {
				System.out.print( (char)c );
			}
			
			isr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
}
