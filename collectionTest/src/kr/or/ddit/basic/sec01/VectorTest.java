package kr.or.ddit.basic.sec01;

import java.util.Vector;

// Collection들은 객체만 저장 가능하다.

public class VectorTest {

	public static void main(String[] args) {
		// Vector와 ArrayList는 그 구조와 기능이 같다.
		// 차이점은 동기화 처리가 되어 있는것(Vector)과 
		// 		  동기화 처리가 되어 있지 않은것(ArrayList) 이다.
		// 그래서 Vector가 자원을 많이 사용한다.(이것을 무겁다고 표현한다.)
		
		// 객체 생성하기
		// 형식) Vector<제네릭타입> 변수명 = new Vector<제네릭타입>();
		//  ==> 제네릭타입은 'Vector'에 저장할 데이터의 자료형 이름이고, 
		//      클래스명으로 지정한다.
		Vector<String> strVector = new Vector<String>();
		Vector<Integer> intVector = new Vector<Integer>();
		Vector<Character> charVector = new Vector<Character>();
		
		// size() ==> Vector에 저장된 데이터의 개수를 반환한다.
		System.out.println("strVector의 크기 : " + strVector.size());
		
		// 데이터 추가하기 ==> add(추가할 데이터)
		// 반환값 : 추가성공(true), 추가실패(false)
		strVector.add("홍길동");
		strVector.add("이순신");
		strVector.add("강감찬");
		//strVector.add(100);    // 오류 : 제네릭타입에 맞지 않은 자료를 입력하면 오류 발생
		
		intVector.add(new Integer(100));      // JDK 1.8이하
		intVector.add(Integer.valueOf(200));  // JDK1.9이상
		intVector.add(300);       // 오토 박싱
		intVector.add(400);
		intVector.add(600);
		boolean r = intVector.add(700);
		
		charVector.add('K');
		charVector.add('O');
		charVector.add('R');
		
		System.out.println("strVector의 크기 : " + strVector.size());
		System.out.println("strVector = " + strVector.toString());  
		System.out.println("strVector = " + strVector);  // .toSring()은 생략가능
		System.out.println();
		
		System.out.println("intVector의 크기 : " + intVector.size());
		System.out.println("intVector = " + intVector);
		System.out.println("반환값 : " + r);
		
		// 데이터 추가하기2 ==> add(index, 데이터)
		// 				==> 'index'번째에 '데이터'를 끼워 넣는다.
		//				==> 'index'는 0부터 시작한다.
		//              ==> 반환값이 없다.
		intVector.add(4, 500);
		System.out.println("intVector = " + intVector);
		
		// 데이터 꺼내오기 ==> get(index)
		//			    ==>'index'번쩨에 저장된 데이터를 꺼내서 반환한다.
		int iTemp = intVector.get(3);  //오토 언박싱
		System.out.println("iTemp = " + iTemp);
		// intVector[3] (배열과 같은 느낌)
		
		// 데이터 수정하기 ==>set(index, 새로운데이터)
		//			   ==> 'index'번째의 데이터를 '새로운데이터'로 변경한다.
		intVector.set(1, 1000);
		System.out.println(intVector);
		
		// 데이터 삭제하기 ==> remove(index)
		//              ==> 'index'번째의 데이터를 삭제한다.
		//				==> 반환값 : 삭제된 데이터
		int iTemp2 = intVector.remove(1);
		System.out.println("intVector = " + intVector);
		System.out.println("삭제된 데이터 " + iTemp2);
		System.out.println();
		
		// 데이터 삭제하기 ==> remove(삭제할데이터)
		//              ==> '삭제할데이터'를 찾아서 삭제한다.
		//              ==> '삭제할데이터'가 여러개이면 이 중에 제일 첫번째 자료가 삭제된다.
		//				==> 반환값 : 삭제성공(true), 삭제실패(false)
		//				==> '삭제할데이터'가 '정수형'이거나 'char형'일 경우에는 반드시 객체로
		//					변환해서 사용해야 한다.
		//intVector.remove(500);
		intVector.remove(Integer.valueOf(500));  // 삭제할 테이터를 객체화해서 지정한다.
		System.out.println("intVector = " + intVector);
		
		System.out.println("삭제 전 charVector = " + charVector);
		//charVector.remove('O');
		charVector.remove(Character.valueOf('O'));  // 삭제할 테이터를 객체화해서 지정한다.
		System.out.println("삭제 후 charVector = " + charVector);
		
		// 전체 자료 삭제 ==> clear()
		charVector.clear();
		System.out.println("clear 후 charVector = " + charVector);
		System.out.println();
		
		// 자료가 비었는지 여부 검사 ==> isEmpty()
		//						==> 자료가 하나도 없이 비어 있으면 true, 그렇지 않으면 false
		System.out.println("charVector.isEmpty() ==> " + charVector.isEmpty());
		System.out.println("intVector.isEmpty() ==> " + intVector.isEmpty());
		System.out.println();
		
		// Vector나 List에 저장된 데이터 전체를 차례로 가져와 처리하기
		System.out.println("for문 이용..........");
		for(int i=0; i<intVector.size(); i++) {
			System.out.println(i + " => " + intVector.get(i));
		}
		System.out.println();
		
		System.out.println("향상된 for문 이용............");
		for(int data : intVector) {
			System.out.println(data);
		}
	}

}
