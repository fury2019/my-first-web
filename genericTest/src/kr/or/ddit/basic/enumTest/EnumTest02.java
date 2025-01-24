package kr.or.ddit.basic.enumTest;

import java.util.Scanner;

public class EnumTest02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*** 계산기 프로그램 ***");
		System.out.println("첫번째 숫자 입력 >>");
		int num1 = scan.nextInt();
		
		System.out.println("두번째 숫자 입력 >>");
		int num2 = scan.nextInt();
		
		System.out.println("연산자(+,-,*,/,% 중 하나) 입력 >> ");
		String op = scan.next();
		
		// Operator 열거형을 이용하여 계산하기
		
		// 연산자와 일치하는 상수를 구한다. 
		Operator enumOp = null;
		
		// 전체 상수의 갯수만큼 반복
		for(Operator myop : Operator.values()) {
			
			//연산자와 일치하는 상수를 구한다.
			if(op.equals(myop.getSymbol())) {
				enumOp = myop;
			}
		}
		
		// 잘못된 연산자 여부 검사
		if(enumOp==null) {
			System.out.println("연산자를 잘못 입력했습니다. 작업 중지");
			return;
		}
		
		// 선택된 상수에 구현된 메서드를 호출해서 계산한다.
		int result = enumOp.calculate(num1, num2);
		
		
		System.out.println(num1 + " " + enumOp.getSymbol() + " " + num2
				+ " = " + result);
		

		
		

	}

}
