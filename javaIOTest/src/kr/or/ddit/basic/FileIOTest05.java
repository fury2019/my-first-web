package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 	Scanner객체를 이용하여 출력할 단을 입력 받아
 	입력한 단에 맞는 구구단을 파일에 출력하는 프로그램을 작성하시오.
 	(파일명 : gugudan.txt)
 	
 	FileOutputStream의 write() 메서드가 **문자열(String)**을 직접 받아들이지 않기 때문에 
 	FileOutputStream의 write() 메서드는 바이트 배열을 사용해야 한다.

    자바에서는 문자열을 파일에 쓰려면 문자열을 바이트 배열로 변환해야 한다. 
    String.getBytes()를 사용하여 문자열을 바이트 배열로 변환할 수 있다.
 */
public class FileIOTest05 {
	public static void main(String[] args) throws FileNotFoundException {
		// 파일 내용 읽기 - 바이트 기반 스트림 이용
		FileOutputStream fout = new FileOutputStream("d:/d_other/구구단테스트.txt");
		System.out.println("출력할 구구단의 단을 입력하세요: ");

		try {
			Scanner scanner = new Scanner(System.in);
			int dan = scanner.nextInt();

			// 읽어온 자료를 화면에 출력하기
			for (int i = 1; i <= 9; i++) {
				String result = dan + " x " + i + " = " + (dan * i) + "\n"; // 줄바꿈 추가
				fout.write(result.getBytes()); // 문자열을 바이트 배열로 변환하여 저장
			}
			
			System.out.println("구구단이 파일에 저장되었습니다.");
			fout.close(); // 스트림 닫기

		} catch (IOException e) {
			System.out.println("오류입니다");
			e.printStackTrace();
		}
	}
}
