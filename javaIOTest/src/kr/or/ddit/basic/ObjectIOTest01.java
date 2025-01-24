package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectIOTest01 {
	public static void main(String[] args) {
		// Member의 인스턴스 생성
		Member mem1 = new Member("김현수", 22, "대전");
		Member mem2 = new Member("신찬희", 59, "청주");
		Member mem3 = new Member("신영희", 45, "춘천");
		Member mem4 = new Member("신창희", 50, "공주");
		Member mem5 = new Member("신희경", 55, "오송");
		
		// 객체를 파일에 저장하기
		try {
			// 출력용 스트림 객체 생성 
			FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			// 쓰기(출력) 작업
			System.out.println("객체 저장 작업 시작..");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);
			oout.writeObject(mem5);
			
			// 객체를 저장할 때 마지막에 null을 저장하여 EOFException을 방지할 수 있다.
			
			System.out.println("객체 저장 작업 완료!!");
			
			oout.close();	//스트림 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
