package kr.or.ddit.basic;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터의 가위 바위 보는 난수를 이용해서 정하고,
 	사용자의 가위 바위 보는 showInputDialog()메서드를 이용해서 입력 받는다.
 	
 	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 	5초안에 입력이 없으면 게임에 진것으로 처리한다. 
 	
 	5초안에 입력이 있으면 승패를 구해서 출력한다.
 	
 	결과 예시)
 	1) 5초 안에 입력을 못했을 경우
 	
 		== 결과 ==
 	  시간 초과로 당신이 졌습니다
 	  
 	2) 5초 안에 입력했을 경우
 	
 	   == 결 과 ==
 	   컴퓨터 : 가위
 	   사용자 : 바위
 	   결  과 : 당신이 이겼습니다.
 */
public class ThreadTest07 {
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Thread th1 = new Input();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();

	}

}

// 데이터를 입력 받는 쓰레드 
class Input extends Thread{
	// 입력 여부를 확인하기 위한 변수 선언 (쓰레드에서 공통으로 사용할 변수)
	public static boolean inputCheck;
	
	@Override
	public void run() {
		
		 	Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        
	        String[] choices = {"가위", "바위", "보"};
	        
	        String userChoice = JOptionPane.showInputDialog("가위, 바위, 보 중 하나를 선택하세요: ");
	        
	        //String userChoice = scanner.nextLine();
	        
	        if (!userChoice.equals("가위") && !userChoice.equals("바위") && !userChoice.equals("보")) {
	            System.out.println("잘못된 선택입니다. 프로그램을 종료합니다.");
	            return;
	        }
	        
	        int computerIndex = random.nextInt(3);
	        String computerChoice = choices[computerIndex];
	        
	        System.out.println("컴퓨터의 선택: " + computerChoice);
	        
	        if (userChoice.equals(computerChoice)) {
	            System.out.println("무승부입니다!");
	        } else if ((userChoice.equals("가위") && computerChoice.equals("보")) ||
	                   (userChoice.equals("바위") && computerChoice.equals("가위")) ||
	                   (userChoice.equals("보") && computerChoice.equals("바위"))) {
	            System.out.println("당신이 이겼습니다!");
	        } else {
	            System.out.println("컴퓨터가 이겼습니다!");
	        }
	        ThreadTest07.inputCheck = true;
	        
	        scanner.close();
        
//		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
//		
//		inputCheck = true; // 입력이 완료되면 inputCheck변수를 true로 변경한다.
//		
//		System.out.println("입력한 값 : " + str);
		
	}
}

// 카운트 다운을 진행하는 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			
			// 입력 쓰레드에서 입력이 완료되었는지 여부를 검사해서
			// 입력이 완료되면 쓰레드를 종료시킨다.
			if(ThreadTest07.inputCheck==true) {
				return;		// run()메서드가 종료되면 해당 쓰레드가 종료된다.
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println("     == 결 과 ==");
		System.out.println("시간 초과로 당신이 졌습니다");
		System.exit(0);
	}
}