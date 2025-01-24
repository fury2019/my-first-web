package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferIOTest02 {
	public static void main(String[] args) {
		// 문자 기반의 입력 버퍼 스트림 사용 예제
		
		try {
			
			// 이클립스에서 자바 프로그램이 실행되는 현재 위치는 
			// 해당 프로젝트 폴더가 현재 위치가 된다.
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/FileTest01.java");
			BufferedReader br = new BufferedReader(fr);
			
			// 문자 기반의 버퍼 스트림 객체에서는 한 줄 단위로 읽어오는 메서드가 있다.
			//		==> 버퍼스트림객체.readLine()
			String temp = "";
			
			for(int i=1; (temp = br.readLine()) != null; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
