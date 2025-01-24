package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		// 입력용 스트림 객체 생성
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		
		
		// 출력용 스트림 객체 생성
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		int data;	//읽어온 자료가 저장될 변수
		
		//read() 메서드는 더 이상 읽어올 자료가 없으면 -1을 반환한다.
		while( (data = bin.read()) != -1 ) {
			// 이 반복문 안에서는 읽어온 자료를 처리하는 내용을 기술하면 된다.
			
			bout.write(data);	//읽어온 자료를 그대로 출력한다.
			
		}
		
		// 출력될 스트림 값을 배열로 변환하기
		outSrc = bout.toByteArray();
		
		// 스트림으로 작업이 완료되면 사용했던 스트림 자원을 반납해야 한다.
		//	==> 해당 스트림 객체의 close()메서드를 사용한다.
		
		try {
			bin.close();
			bout.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println(" inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
	}
}

