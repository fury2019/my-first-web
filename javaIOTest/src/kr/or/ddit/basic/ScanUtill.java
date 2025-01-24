package kr.or.ddit.basic;

import java.util.Scanner;

// Scanner 객체를 손쉽게 사용하기 위한 클래스
// 이 클래스의 모든 메서드는 static으로 작성한다.
public class ScanUtill {
	private static Scanner scan = new Scanner(System.in);
	
	public static String nextLine() {
		return scan.nextLine();
	}

	
	public static String nextLine(String title) {
		System.out.println(title);
		return nextLine();
	}
	
	public static int nextInt() {
		while(true) {
			try {
				int result = Integer.parseInt(scan.nextLine() );
				return result;
			}catch(NumberFormatException e) {
				System.out.println("** 잘못 입력 !!! (숫자를 입력하세요)");
			}
		}
	}
	public static int nextInt(String message) {
		System.out.print(message);
		return nextInt();
	}


	public static String next() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
