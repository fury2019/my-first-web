package kr.or.ddit.basic;

// * 200개 출력하기, $ 200개 출력하기
public class ThreadTest02 {

	public static void main(String[] args) {
		// 멀티 쓰레드 프로그래밍
		
		// Thread를 사용하는 방법
		
		// 방법1)
		// Thread 클래스를 상속한 class를 작성하고
		// 작성된 class의 인스턴스를 생성한 후
		// 이 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
//		th1.run();
		
		
		// 방법2)
		// Runnable 인터페이스를 구현한 class를 작성하고
		// 작성된 class의 인스턴스를 Thread 클래스의 생성자에
		// 인자값으로 넣어서 Thread 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start();
//		th2.run();
		
		// 방법2-2)
		// Runnable 인터페이스의 익명구현체를 이용하는 방법
		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					
					try {
						Thread.sleep(100);
					}catch (InterruptedException e) {
						
					}
				}
			}
		};
		
		System.out.println("main()메서드 끝");
	}

}

// 방법1 --> Thread 클래스를 상속한 class 작성
class MyThread1 extends Thread{
	@Override
	public void run() {
		// 이 run()메서드는 쓰레드가 처리할 내용을 기술하는 영역이당.
		for(int i=1; i<=200; i++) {
			System.out.print("*");
			
			try {
				// Thread.sleep(시간)메서드 ==> 주어진 시간동안
				// 			작업을 잠시 멈춘다.
				//			'시간'은 밀리세컨드 단위를 사용한다.
				//			즉, 1000은 1초를 의미한다.
				
				Thread.sleep(100);
			}catch (InterruptedException e) {
				
			}
		}
	}
}

// 방법2 --> Runnaable 인터페이스를 구현한 class 작성
class MyThread2 implements Runnable{
	@Override
	public void run() {
		// 이 run()메서드는 쓰레드가 처리할 내용을 기술하는 영역이다.
		for(int i=1; i<=200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				
			}
		}
	}
}










