package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
   5명의 사람 이름을 입력 받아 ArrayList에 저장한 후
   ArrayList에 저장된 사람들 중에 '김'씨 성의 이름을
   모두 출력하시오.(입력은 Scanner객체 이용)
 */
public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		System.out.println("5명의 사람 이름을 입력하세요.");
		for(int i=1; i<=5; i++) {
			System.out.println(i + "번째 사람 이름 입력 >> ");
			String name = scan.next();
			nameList.add(name);
		}
		System.out.println();
		
		System.out.println("김씨 성을 가진 사람들");
		for(String name : nameList) {
			
//			if(name.substring(0, 1).equals("김")) {
//				System.out.println(name);
//			}
			
//			if(name.charAt("0")=='김') {
//				System.out.println(name);
//			}
			
			
//			if(name.indexOf("김")==0) {  // 글자 위치찾기
//				System.out.println(name);
//			}
			
			if(name.startsWith("김")) {
				System.out.println(name);
			}
		}
		
		
	}
}
