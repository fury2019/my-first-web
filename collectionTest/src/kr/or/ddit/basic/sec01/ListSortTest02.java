package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ListSortTest02 {
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		System.out.println("정렬전...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------");
		System.out.println();
		
		Collections.sort(memList);
		
		System.out.println("정렬후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------");
		System.out.println();
		
		// Member의 회원번호(num)를 기준으로 내림차순 정렬하는 외부 정렬 기준
		// 클래스를 이용하여 정렬하시오.(클래스명 : SortNumDesc)
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("회원번호 내림차순 정렬후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------");
		System.out.println();
	
		
	}

}
//회원번호(int), 회원이름, 전화번호 정보를 관리하는 Member 클래스 작성하기
// 회원번호(int), 회원이름, 전화번호 정보를 관리하는 Member클래스 작성하기
// 회원이름을 기준으로 오름차순 정렬이 되도록 내부 정렬기준을 추가해 보자.
//	(Comparable 인터페이스를 구현하여 작성한다.)
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String Tel;
	
	// 생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		Tel = tel;
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
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", Tel=" + Tel + "]";
	}
	
	//회원이름을 기준으로 오름차순 정렬이 되도록 재정의한다.
	@Override
	public int compareTo(Member mem) {
//		if(this.name.compareTo(mem.getName()) > 0) {
//			return 1;
//		}else if(this.name.compareTo(mem.getName()) < 0) {
//			return -1;
//		}
//			return 0;
			return this.name.compareTo(mem.getName());
	}
}
	
class SortNumDesc implements Comparator<Member>{
	
	@Override
	public int compare(Member mem1, Member mem2) {
//		if(mem1.getNum() > mem2.getNum()) {
//			return -1;
//		}else if(mem1.getNum() < mem2.getNum()) {
//			return 1;
//		}else {
//			return 0;
//		}
		
		// Wrapper 클래스를 이용하는 방법1 
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
//		return Integer.valueOf(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
		// Wrapper 클래스를 이요하는 방법2
		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
	}
}

