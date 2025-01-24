package kr.or.ddit.basic;

import java.io.Serializable;
/*
 	마샬링(Marshalling) ==> 메모리 상의 객체를 저장 또는 전송하기 위해 다른 형태로
 						  변환하는 작업을 말한다.
 						  
 	직렬화 ==> 마샬링 작업의 일종으로 '객체 데이터를 일련의 byte Stream으로 
 			  변환하는 작업을 말한다.
 */

public class Member implements Serializable {

	private static final long serialVersionUID = -3226646391742381334L;
	
	// transient ==> 직렬화가 되지 않을 멤버변수에 지정한다.
	
	private String name;
	private transient int age;
	private transient String addr;
	
	// 생성자
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
