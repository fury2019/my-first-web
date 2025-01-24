package kr.or.ddit.basic;
		
public class ThreadTest03 {
	public static void main(String[] args) {
		// 쓰레드가 실행되는 시간을 체크해 보기
		Thread th = new Thread(new MyRunner());
		
		// 1970년 1월 1일 0시0분0초(표준시간)부터 현재 시간까지 
		// 경과한 시간을 1ms 단위로 반환한다.
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		// Thread객체.join()메서드 
		//		==> 'Thread객체'의 작업이 모두 끝날 때까지
		//			기다린다.
		try {
			th.join();
		} catch(InterruptedException e) {
			
		}

		long endTime = System.currentTimeMillis();
		
		System.out.println("경과 시간 : " + (endTime - startTime));
	}	
}



class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for(long i=1L; i<=1_000_000_000L; i++) {
			sum += i;
		}
		System.err.println("합계 : " + sum);
	}
}
