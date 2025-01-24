package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectIOTest02 {
	public static void main(String[] args) {
		// 파일에 저장된 객체를 읽어와 화면에 출력하기
		
		try {
			// 입력용 스트림 객체 생성
			ObjectInputStream oin = new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream("d:/d_other/memObj.bin") )  );
		
			Object obj = null;	// 읽어온 객체가 저장될 변수
			
			System.out.println("객체 읽기 작업 시작");
			
			
			// readObject()메서드가 데이터를 끝까지 다 읽어오면 
			// EOFExeption이 발생한다.
			while( (obj = oin.readObject()) != null) {
				// 읽어온 데이터는 원래의 객체형으로 변환 후 사용한다.
				Member mem = (Member)obj;
				
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("----------------------------");
			}
			
			System.out.println("객체 읽기 작업 끝---");
			oin.close();
			
			
		} catch (EOFException e) {
			System.out.println("읽기 작업 끝---");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
