package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOTest05techer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		FileWriter fw = null;
		
		try {
			// 출력용 스트림 객체 생성
			fw = new FileWriter("d:/d_other/gugudan.txt");
			
			System.out.print("출력할 단 입력 >> ");
			int dan = scan.nextInt();
			
			//System.out.print( dan + "단\n");
			fw.write( dan + "단\n");
			
			for(int i=1; i <= 9; i++) {
				String result = dan + " * " + i + " = " + (dan * i) + "\n";
				
				//System.out.println(result);
				fw.write(result);
			}	
			
			System.out.println("출력 끝");
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//스트림 닫기
			if(fw!=null) try { fw.close(); }catch(IOException e) {}
			
		}
	}
}
