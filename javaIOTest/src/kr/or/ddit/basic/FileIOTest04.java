package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {
	public static void main(String[] args) {
		// 문자 기반 스트림을 이용하여 사용자가 입력한 내용을 그대로 파일로 저장하기
		
		try {
			/*
			// System.in ==> 콘솔(표준 입출력 장치)의 입력 장치와 연결된 스트림 객체
			
			System.out.print("아무거나 입력 : ");
			int c = System.in.read();
			
			System.out.println();
			System.out.println("입력한 값 : " + (char) c);
			*/
			
			
			//	InputStreamReader 클래스 ==> 바이트 기반의 입력 스트림을
			//  문자 기반의 입력 스트림으로 변환해주는 보조 스트림 클래스이다.
			InputStreamReader isr = new InputStreamReader(System.in);
			
			FileWriter fw = new FileWriter("d:/d_other/mytest.txt");
			
			System.out.println("아무 내용이나 입력하세요 (입력의 끝은 Ctrl + z 입니다.)");
			
			int c;
			
			// 콘솔에서 입력할 때 입력의 끝은 'Ctrl' + 'z' 키를 누르면 된다.
			while((c=isr.read())!=-1) {
				// 콘솔로 입력 받은 데이터를 파일에 출력한다.
				fw.write(c);
			}
			
			
			// 스트림 닫기 
			isr.close();
			fw.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
