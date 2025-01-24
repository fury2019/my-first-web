package kr.or.ddit.basic;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		// 사용자로부터 데이터 입력 받기
//		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
//		
//		System.out.println("입력한 값 : " + str);
		
		/*
		두 사람의 가위 바위 보를 입력 받아서 
		승패를 구해서 출력하는 프로그램을 작성하시오
		
		출력 예시)
			첫번째 사람 : 가위
			두번째 사람 : 바위
			결 과 : 두번째 사람 승!!
			
			
		*/
		 // 사용자로부터 두 사람의 선택을 입력 받기
        String firstPlayer = JOptionPane.showInputDialog("첫번째 사람의 선택 (가위, 바위, 보):");
        String secondPlayer = JOptionPane.showInputDialog("두번째 사람의 선택 (가위, 바위, 보):");

        // 결과를 저장할 변수
        String result;

        // 승패 결정 로직
        if (firstPlayer.equals(secondPlayer)) {
            result = "무승부!!";
        } else if ((firstPlayer.equals("가위") && secondPlayer.equals("보")) ||
                   (firstPlayer.equals("바위") && secondPlayer.equals("가위")) ||
                   (firstPlayer.equals("보") && secondPlayer.equals("바위"))) {
            result = "첫번째 사람 승!!";
        } else {
            result = "두번째 사람 승!!";
        }

        // 결과 출력
        System.out.println("첫번째 사람 : " + firstPlayer);
        System.out.println("두번째 사람 : " + secondPlayer);
        System.out.println("결 과 : " + result);
    }

}
