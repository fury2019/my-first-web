package kr.or.ddit.basic;

import javax.xml.crypto.Data;

public class ThreadTest19 {

	public static void main(String[] args) {
		DataBox box = new DataBox();
		
		SetValueThread sth = new SetValueThread(box);
		GetValueThread gth = new GetValueThread(box);
		
		sth.start();
		gth.start();
	}

}

// 데이터를 넣어주는 쓰레드 (공통객체의 setValue()메서드를 사용하는 쓰레드)
class SetValueThread extends Thread{
	private DataBox databox;

	// 생성자
	public SetValueThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		String[] dataArr = {"이순신", "홍길동", "강감찬", "이몽룡", "성춘향"};
		
		for(int i=0; i<dataArr.length; i++) {
			databox.setValue(dataArr[i]);
		}
	}
}
// 데이터를 꺼내서 사용하는 쓰레드 (공통객체의 getValue()메서드를 사용하는 쓰레드)
class GetValueThread extends Thread{
	private DataBox databox;
	
	//생성자
	public GetValueThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			String data = databox.getValue();
		
		}
	}
	
}

// 데이터를 공통으로 사용하는 클래스
class DataBox{
	private String value;
	
	// 데이터를 공급하는 메서드
	// ==> value변수에 값이 있으면 value가 null이 될 때까지 기다린다.
	//	   value가 null이 되면 새로운 data를 value에 저장한다.
	public synchronized void setValue(String data) {
		if(this.value != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		this.value = data;
		System.out.println("Thread에서 새로 저장한 데이터 : " + value);
		
		notify();
	}
	
	// 데이터를 사용(읽기)하는 메서드
	// ==> value 값이 null이면 value에 데이터가 채워질때까지 기다리고
	//     value에 값이 있으면 해당 문자열을 반환한다.
	//	   반환 후에는 value값을 null로 만든다.
	public synchronized String getValue() {
		if (value==null) {
			try {
			 	wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		String returnValue = value;
		System.out.println("쓰레드가 읽은 데이터 : " + value);
		
		value = null;
		
		notify();
		
		return returnValue;
	}
}