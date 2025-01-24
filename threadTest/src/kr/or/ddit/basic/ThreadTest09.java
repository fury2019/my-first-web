package kr.or.ddit.basic;

import java.lang.Thread.State;

// 쓰레드의 상태를 출력하는 예제 

public class ThreadTest09 {

	public static void main(String[] args) {
		
		StatePrintThread th = new StatePrintThread(new TargetThread()); // 수정된 부분
		
		th.start();
		
	}

}


// 쓰레드 상태의 검사 대상이 되는 쓰레드 (숫자를 출력하고 1.5초 멈췄다가 출력하고 종료됨)
class TargetThread extends Thread{
	@Override
	public void run() {
		
		for(long i=1L; i<=2_000_000_000L; i++) {
			for(int j=1; j<3; j++) {
				long x = i + j;
			}
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		for(long i=1L; i<=2_000_000_000L; i++) {
			for(int j=1; j<3; j++) {
				long x = i + j;
			}
		}
	}
}


// 검사 대상 쓰레드(TargetThread)의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;

	// 생성자
	public StatePrintThread(TargetThread target) {
		super();
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true) {
			
			// target 쓰레드의 상태값 구하기
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값 : " + state);
			
			// target 쓰레드의 상태값이 NEW 상태이면...
			if(state == Thread.State.NEW) {
				target.start();		// TargetThread를 실행시킨다.
			}
			
			// target 쓰레드의 상태값이 종료(TERMINATED) 상태이면...
			if(state == Thread.State.TERMINATED) {
				break;	//반복문 탈출
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}




