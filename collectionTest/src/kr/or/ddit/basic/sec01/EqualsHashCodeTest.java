package kr.or.ddit.basic.sec01;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setNum(2);
//		p2.setName("일지매");
//		p2.setNum(1);
//		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1==p2);
		System.out.println(p1==p3);
		System.out.println();
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		
		HashSet<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("set의 개수 : " + testSet.size());
		
		System.out.println();
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
		
		
	}	
}		
/*
 - equals()메서드 ==> 두 객체의 내용이 같은지 비교 - 동등성
 - hashCode()메서드 ==> 두 객체가 같은 객체인지 비교 - 동일성
 
 - HashSet, HashMap, Hashtable과 같이 Hash로 시작하는 컬렉션 객체들은
   객체의 의미상의 동일성 비교를 위해 hashCode()메서드와 hashCode()메서드를 
   같이 재정의해야 한다.
   
 - hashCode()메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에 대해 같은
   hashCode값이 만들어질 수  있다.
   
 */
		
		
class Person{
	private int num;
	private String name;
	
	public Person() { // 기본생성자 (안만들어도 있는셈)
		
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// p1.equals(p2);
	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		
		if(obj==null) return false;
		
		// getClass() ==> 클래스의 정보 가져오는 메서드
		// 같은 종류의 클래스인지 검사 
		if(this.getClass() != obj.getClass()) return false;
		
		// 매개변수로 받은 데이터를 현재 객체 유형으로 형변환한다.
		Person that = (Person)obj;
		
		return this.num == that.num && Objects.equals(this.name, that.name);
		
		
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(num, name);
	}
	
}












