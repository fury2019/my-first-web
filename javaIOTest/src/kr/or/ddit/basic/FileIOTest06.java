package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
	Scanner객체를 이용하여 출력할 단을 입력 받아
	입력한 단에 맞는 구구단을 파일에 출력하는 프로그램을 작성하시오.
	(파일명 : gugudan.txt)
*/
public class FileIOTest06 {
	public static void main(String[] args) {
		// 바이트 기반 스트림을 이용한 처리
		
		Scanner scan = new Scanner(System.in);
		
		FileOutputStream fout = null;
		
		try {
			// 출력용 바이트 기반 스트림 객체 생성
			fout = new FileOutputStream("d:/d_other/gugudan.txt");
			
			System.out.println("출력할 단 입력 >> ");
			int dan = scan.nextInt();
			
			String title = dan + " 단\r\n";
			fout.write(title.getBytes("utf-8"));
			
			
			for(int i=1; i<=9; i++) {
				String result = dan + " * " + i + " = " + (dan * i) + "\r\n";
				
				//출력할 문자열을 byte타입으로 변환해서 출력
				fout.write(result.getBytes("utf-8"));
			}
				
			System.out.println("출력 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fout!=null) try { fout.close(); } catch(IOException e) {}
		}
	}
}
