package kr.or.ddit.basic.sec01;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
  정렬과 관련된 인터페이스는 Comparable, Comparator 이렇게 두 가지가 있다.
  
  Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때(내부 정렬 기준)을 
  넣고 싶을 때 구현하는 인터페이스이고,
  
  Comparator은 외부에 별도로 정렬 기준(외부 정렬 기준)을 구현하고 싶을 때
  구현하는 인터페이스이다.
  
  Comparable에서는 compareTo() 메서드를 재정의하고, 
  Comparator에서는 compare()메서드를 재정의해야 한다.
  
  String 클래스, Wrapper 클래스, Date 클래스, File클래스 등에는 내부 정렬 기준이
  이미 구현되어 있다. (이 때 내부 정렬 기준은 오름차순으로 처리되도록 구현되어 있따)
  
 */

public class LIstSortTest01 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전 : " + list);
		
		// list의 정렬은 Collections.sort()메서드를 이용하여 정렬한다.
		// Collections.sort() 메서드는 기본적으로 내부 정렬 기준으로 정렬한다.
		Collections.sort(list);
		System.out.println("정렬후 : " + list);
		
		Collections.shuffle(list);   	// 데이터 섞기
		System.out.println("자료 섞기 후 : " + list);
		System.out.println();
		
		// 외부 정렬 기준을 적용해서 정렬하기
		// 형식) Collections.sort(List객체, 외부정렬기준객체);
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후 : " + list);
		
		
	}
}

// 외부 정렬 기준을 정해주는 class 작성하기 (Comparator 인터페이스 구현하여 작성)
class Desc implements Comparator<String>{

	// compare() 메서드를 이용하여 정렬하고자 하는 기준을 정해준다.
	
	// compare() 메서드의 매개변수는 서로 인접한 2개의 데이터를 의미한다.
	
	// compare() 메서드의 반환값
	// 반환값이 '0'이면 두 값이 같다.
	// 반환값이 '양수'이면 앞, 뒤의 데이터 순서를 바꾼다.
	// 반환값이 '음수'이면 앞, 뒤의 데이터 순서를 바꾸지 않는다.
	
	// 예) 오름차순일 경우 ==> 앞의 값이 크면 '양수',
//								  같으면 '0',
//								  작으면 '음수'를 반환하도록 구현하면 된다.
	
	@Override
	public int compare(String str1, String str2) {
		/*
		if(str1.compareTo(str2) > 0 ) {
			return -1;			// 내림차순으로 할 것이기에 음수 아무거나 반환
		}else if(str1.compareTo(str2) < 0) {
			return 1;			// 0보다 작다 ==> 앞의 값이 크다 ==>내림차순이므로 양수 아무거나 반환하여 그대로 
		} else {
		return 0;
		}
		*/
		
		return str1.compareTo(str2) * -1;
	}
	
}

