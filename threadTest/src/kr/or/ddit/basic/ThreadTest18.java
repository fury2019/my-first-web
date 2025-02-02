package kr.or.ddit.basic;

/*
	- wait(), notify()를 이용하여 두 쓰레드가 번갈아 한번씩 실행하는 예제
	
	- wait(), nitify(), notifyAll()은 동기화 영역에서만 사용 가능하다.
*/


public class ThreadTest18 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		Thread thA = new ThreadA(workObj);
		Thread thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
	}

}


// WorkObject의 methodA()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.methodA();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}

// WorkObject의 methodB()메서드만 호출하는 메서드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.methodB();
		}
		
		synchronized (workObj) {
			workObj.notify();
		}
	}
}



// 공통으로 사용할 클래스
class WorkObject{
	public synchronized void methodA() {
		System.out.println("methodA() 메서드 실행중");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void methodB() {
		System.out.println("methodB() 메서드 실행중");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
}