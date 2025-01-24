package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07techer {
	public static void main(String[] args) {
		GameCountDown gcd = new GameCountDown();
		
		// 난수를 이용해서 컴퓨터의 가위 바위 보를 정한다.
		String[] data = {"가위", "바위", "보"};
		int index = (int)(Math.random() * 3);	//0 ~ 2사이의 난수 만들기
		String com = data[index];	// 컴퓨터의 가위 바위 보 정하기
		
		// 사용자의 가위 바위 보 입력 받기
		gcd.start();
		
		String man;
		do {
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
		}while( !("가위".equals(man) || "바위".equals(man) || "보".equals(man)) );
		
		GameCountDown.inputCheck = true;
		
		 // 결과를 저장할 변수
        String result;

        // 승패 결정 로직
        if (man.equals(com)) {
            result = "무승부!!";
        } else if ((man.equals("가위") && com.equals("보")) ||
                   (man.equals("바위") && com.equals("가위")) ||
                   (man.equals("보") && com.equals("바위"))) {
            result = "당신 이겼습니다 승리!!";
        } else {
            result = "당신이 졌습니다";
        }

        // 결과 출력
        System.out.println(" == 결과 ==");
        System.out.println("컴퓨터 : " + com);
        System.out.println("사용자 : " + man);
        System.out.println("결 과 : " + result);
	}
}

class GameCountDown extends Thread{
	public static boolean inputCheck; // 입력이 완료되었는지 여부를 정하는 변수 선언
	
	@Override
	public void run() {
		System.out.println("카운트 다운 시작");
		
		for(int i=5; i>=1; i--) {
			
			if(inputCheck==true) return;
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(" == 결과 == ");
		System.out.println("시간 초과로 당신이 졌습니다");
		System.exit(0);
	}
}
