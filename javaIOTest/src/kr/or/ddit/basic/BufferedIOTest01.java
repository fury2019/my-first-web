package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		// 출력 버퍼 연습
		
		try {
			FileOutputStream fout = 
					new FileOutputStream("d:/d_other/bufferTest.txt");
			
			// 버퍼의 크기가 5인 버퍼 스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(int i='1'; i<='9'; i++) {
				bout.write(i);
			}
			
			// 출력 버퍼에 남아 있는 데이터를 모두 출력시키고 출력 버퍼를 비운다
			
			bout.flush();
			
			//fout.close();
			bout.close();	// 보조 스트림을 닫으면 보조 스트림에서 사용한
							// 기반 스트림도 자동으로 닫힌다.
			
			System.out.println("출력 작업 끝");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
