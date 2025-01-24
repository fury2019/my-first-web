package kr.or.ddit.basic;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataIOTest01 {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = 
					new FileOutputStream("d:/d_other/test.data");
			
			// 기본 자료형 단위로 출력할 보조스트림 객체 생성
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(200);			// 정수형으로 출력
			dout.writeFloat(123.45f);	// 실수형으로 출력
			dout.writeBoolean(false);	// 논리형으로 출력
			dout.writeUTF("ABCDabcd");	// 문자열 형식으로 출력
			
			System.out.println("출력 완료");
			
			dout.close();	// 스트림 닫기
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
