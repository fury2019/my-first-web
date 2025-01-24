package kr.or.ddit.basic.sec01;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/*
 	5명의 주민번호를 입력받아 ArrayList에 저장하고
 	이 ArrayList에 저장된 데이터 중에서 남자의 주민번호를 출력하시오
 	(입력은 Scanner 객체를 이용하여 처리한다.)
 */
public class ArrayList02_2 {
	public static void main(String[] args) {
		
		
		ArrayList<String> juminlist = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		
		System.out.println("주민번호 5개 입력");
		for(int i=0; i<5; i++) {
			System.out.println(i+"번째 주민번호 >>");
			String jumin = in.next();
			juminlist.add(jumin);
		}
		
		System.out.println();
		System.out.println("남자");
		for(int i=0; i<juminlist.size();i++) {
			String ju = juminlist.get(i);
			if(ju.charAt(7)=='1' || ju.charAt(7)=='3') {
				System.out.println(ju);
			}
			
		}
	}
}
