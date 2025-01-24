package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	 5명의 별명을 입력 받아  ArrayList에 저장한 후 
     ArrayList에 저장된 별명 중 제일 긴 별명들을 출력하시오.
     (각 별명의 길이는 같을 수 있다.)
 */
public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("별명을 5번 입력하세요...");
		for(int i=1; i<=5; i++) {
			System.out.print(i + "번째 별명 >>");
			String alias = scan.nextLine();
			aliasList.add(alias);
		}
		System.out.println();
		
		// 제일 긴 별명의 길이 찾기
		
		// 제일 긴 별명의 길이가 저장될 변수를 선언하고 
		// 이 변수에 첫번째 데이터의 길이를 저장한다.
		int maxLength = aliasList.get(0).length();
		for(int i=1; i<aliasList.size(); i++) {
			// 현재까지 제일 긴 별명의 길이와 List에서 하나씩 꺼내온 별명의
			// 길이를 비교해서 꺼내온 별명의 길이가 더 길면 이 길이를
			// 제일 긴 별명의 길이가 저장될 변수에 저장한다.
			if(maxLength < aliasList.get(i).length()) {
				maxLength = aliasList.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for(int i=0; i<aliasList.size(); i++) {
			if(maxLength == aliasList.get(i).length()) {
				System.out.println(aliasList.get(i));
			}
		}
		
	}
}
