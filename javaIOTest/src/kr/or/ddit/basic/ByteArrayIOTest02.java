package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];
		
		// 입력용 스트림 객체 생성
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		
		// 출력용 스트림 객체 생성
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			/*
			//available() ==> 읽어올 수 있는 데이터의 크기를 반환한다. 
			while(bin.available() > 0) {
//				bin.read(temp);
//				bout.write(temp);
				
				int len = bin.read(temp);  // 실제 읽어온 byte 수를 반환한다.
				
				// temp배열의 내용 중에서 0번째부터 len개수만큼 출력한다.
				bout.write(temp, 0, len);
				
				System.out.println("반복문 안에서 temp => " + Arrays.toString(temp));
			}
			*/
			int len;
			while ((len = bin.read(temp))>0) {
				bout.write(temp, 0, len);
				System.out.println("반복문 안에서 temp => " + Arrays.toString(temp));
			}
			
			
			outSrc = bout.toByteArray();
			
			System.out.println();
			System.out.println(" inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc));
			
			// 스트림 닫기
			bin.close();
			bout.close();
				
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
