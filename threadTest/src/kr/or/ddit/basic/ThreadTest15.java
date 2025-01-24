package kr.or.ddit.basic;

public class ThreadTest15 {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		// 공통으로 사용할 객체 생성
		TestThread th1 = new TestThread("TEST01", sObj);
		TestThread th2 = new TestThread("TEST02", sObj);
		
		th1.start();
		th2.start();
	}
}

// 공통으로 사용할 클래스를 사용하는 쓰레드
class TestThread extends Thread{
	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			sObj.add();
		}
	}
	
	
}


// 공통으로 사용할 클래스 작성 
class ShareObject{
	private int sum = 0;
	
	// 동기화 처리하기
	
//	public synchronized void add() {	// 방법1 ==> 메서드에 동기화 설정하기 
	public void add() {	
		
		synchronized (this) {	// 방법2 ==> 동기화 블럭으로 설정하기
			
		int n = sum;
		
		n += 10;
		
		sum = n;
		
		// Thread.currentThread() ==> 현재 이 메서드를 사용하는 쓰레드 정보 가져오기
		// Thread.currentThread().getName() ==> 이 메서드를 사용하는 쓰레드 이름 구하기
		System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);
		}
	}
}
