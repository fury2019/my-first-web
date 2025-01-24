package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoTest {
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new LottoTest().lottoStart();
	}
	
	// 시작 메서드
	public void lottoStart() {
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1 : 	//로또 구입
				buyLotto();
;				break;  
			case 2 :	//종료
				System.out.println("감사합니다");
				return;	
			default :
				System.out.println("메뉴 번호를 잘못 입력했습니다. 다시입력하세요");
				
			}
		}	
	}
	// 로또 구입 처리 메서드
	private void buyLotto() {
		System.out.println();
		System.out.println("로또 구입시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.println("금액 입력 >> ");
		int money = scan.nextInt();
		
		System.out.println();
		
		// 입력 받은 금액의 범위를 검사한다.
		if(money<1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입실패");
			return;
		}
		
		if(money>101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입실패");
		}
		
		// 살 수 있는 로또의 개수 구하기
		 int count = money / 1000;
		 
		 Set<Integer> lottoSet = new HashSet<Integer>();
		 
		 System.out.println("행운의 로또번호는 아래와 같습니다");
		 for (int i=1; i<count; i++) {
			 
			 // 로또번호 (1 ~ 45사이의 중복되지 않는 난수 6개) 만들기
			 while(lottoSet.size() < 6) {
				 lottoSet.add((int)(Math.random() * 45 + 1));
				 
			 }
			 
			 // 만들어진 로또번호를 정렬하기 위해서 List에 넣어서 정렬한다.
			 List<Integer> lottoList = new ArrayList<Integer>(lottoSet);
			 Collections.sort(lottoList);
			 
			 System.out.println("로또번호" + i + " : " + lottoList);
			 
			 // Set을 비워준다.
			 lottoSet.clear();
			 
		 } // for문 끝.
		 
		 System.out.println("받은 금액은 " + money + "원이고, 거스름돈은 " 
				 		+ (money%1000) + "원 입니다.");
	}
	
	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println("=================");
		System.out.println("  Lotto프로그램");
		System.out.println("-----------------");
		System.out.println(" 1. Lotto 구입");
		System.out.println(" 2. 프로그램 종료");
		System.out.println("=================");
		System.out.println("메뉴 선택 >>");
		return scan.nextInt();
	}
}
