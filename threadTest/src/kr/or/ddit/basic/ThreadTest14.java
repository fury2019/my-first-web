package kr.or.ddit.basic;import java.awt.geom.PathIterator;
import java.nio.channels.Pipe;

/*
 	쓰레드에서 객체를 공통으로 사용하는 예제
 	
 	- 원주율을 계산하는 쓰레드와 
 	  계산된 원주율을 출력하는 쓰레드가 있다.
 	  
 	  원주율을 관리하는 객체가 필요하다.
 	  이 객체를 두 쓰레드에서 공통으로 사용해서 처리한다.
 */
public class ThreadTest14 {
	
	public static void main(String[] args) {
		// 공통으로 사용할 객체 생성
		ShareData shareData = new ShareData();
		
		// 쓰레드 객체를 생성하고 공통으로 사용할 객체를 각각의 쓰레드에 주입한다.
		CalcPIThread cTh = new CalcPIThread();
		cTh.setSd(shareData);
		
		PrintPIThread pTh = new PrintPIThread(shareData);
		System.out.println("계산을 시작합니다");
		
		cTh.start();
		pTh.start();
		
	}
}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;
	
	// 공통으로 사용할 객체를 주입하기
	
	// setter 이용
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
	/*
	 	원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ... ) * 4;
	 	
	 			 1  -  3   +   5  -  7  +  9...
	 			 0     1       2     3     4      ==> 2로 나눈 몫
	 */
		double sum = 0.0;
		for(int i=1; i<1_000_000_000; i+=2) {
			if ((i/2) % 2 == 0) {
				sum += (1.0/i);
			}else {
				sum-= (1.0 / i);
			}
		}
		
		// 계산된 결과 저장하기
		sd.result = sum * 4;
		sd.isOk = true;
	}
}



// 계산이 완료되면 계산된 원주율을 출력하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData sd;

	// 공통으로 사용할 객체를 주입하기
	
	// 생성자 이용
	public PrintPIThread (ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true) {
			if(sd.isOk == true) {
				break;	// 반복문 탈출
			}
			Thread.yield();
		}
		System.out.println();
		System.out.println("결과 : " + sd.result);
		System.out.println(" PI : " + Math.PI);
	}
}


// 원주율을 관리하는 클래스(공통으로 사용할 클래스)
class ShareData{
	public double result;		// 계산된 원주율이 저장될 변수
	
	public boolean isOk = false;	// 계산이 완료되었는지 여부를 나타내는 변수
	
}
