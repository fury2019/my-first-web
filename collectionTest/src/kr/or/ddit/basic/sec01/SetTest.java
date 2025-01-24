package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class SetTest {

	public static void main(String[] args) {
	/*
	   - List와 Set의 차이점
	1. List
	   - 데이터의 순서(index)가 있다.
	   - 중복되는 데이터를 저장할 수 있다.
	   
	2. Set
	   - 데이터의 순서(index)가 없다.
	   - 중복되는 데이터를 저장할 수 없다.    	 
	 */
		 HashSet<String> hs1 = new HashSet<String>();
		 
		 // 데이터 추가 ==> add()메서드 사용
		 hs1.add("AA");
		 hs1.add("우리나라");
		 hs1.add("홍길동");
		 hs1.add("대전시");
		 hs1.add("BB");

		 System.out.println("set의 크기 : " + hs1.size());
		 System.out.println("hs1 => " + hs1.toString());
		 System.out.println();
		 
		 // Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		 boolean isAdd = hs1.add("KK");
		 System.out.println("중복되지 않을 때 " + isAdd);
		 System.out.println("hs1 => " + hs1);
		 
		 boolean isAdd2 = hs1.add("BB");
		 System.out.println("중복될 때 " + isAdd2);
		 System.out.println("hs1 => " + hs1);
		 System.out.println();
		 
		 // 데이터 삭제하기 ==> remove(삭제할데이터)
		 // 			 ==> '삭제할데이터'를 찾아서 삭제한다.
		 //				 ==> 반환값 : 삭제성공(true), 삭제실패(false)
		 // 전체 삭제하기 ==> clear()
		 hs1.remove("KK");
		 System.out.println("삭제후 hs1 => " + hs1);
		 
		 /*
		 hs1.clear();
		 System.out.println("clear()후 hs1 => " + hs1);
		 */
		 /*
		  	 Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		  	 그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 한다.
		  	 
		  	 Set의 자료들을 Iterator형 객체로 변환하는 메서드 ==> iterator()
		  	 
		  */
		 Iterator<String> it = hs1.iterator();  // Set 데이터를 Iterator로 변환하기
		 
		 // Iterator객체의 hasNext()메서드
		 // ==> Iterator의 포인터가 가리키는 곳 다음번째에 데이터가 있는지 검사한다.
		 //     데이터가 있으면 true, 없으면 false를 반환한다.
		 
		 while(it.hasNext()) {
			 // 데이터가 있을 때 처리되는 곳....
			 
			 // Iterator객체의 next()메서드
			 //  ==> Iterator의 포인터를 다음번째 위치로 이동한 후 그 곳의 데이터를 읽어서 반환한다.
			 
			 String str = it.next();
			 System.out.println(str);
		 }
		 System.out.println("-------------------------------------");
		 // 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		 // 번호는 1번부터 17번까지 있고, 추첨할 인원은 3명이다.
		 // 당첨 번호를 출력하시오.
		 HashSet<Integer> testSet = new HashSet<Integer>();
		 
		 while(testSet.size()<3) {
			 testSet.add((int)(Math.random() * 17 + 1));
		 }
		 
		 System.out.println("당첨자 번호 : " + testSet);
		 System.out.println();
		 
		 // Set유형의 자료를 List형으로 변환하기
		 
		 // List 객체를 생성할 때 List객체의 생성자에 Set자료를 넣어서 생성한다.
		 ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
		 
		 System.out.println("List 데이터 출력하기");
		 for(int i=0; i<testList.size(); i++) {
			 System.out.println(testList.get(i));
		 }
		 
	}

}
