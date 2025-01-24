package kr.or.ddit.basic.sec01;

import java.util.ArrayList;

public class ArrayListTest01 {
	public static void main(String[] args) {
		// ArrayList객체 생성
		ArrayList<String> list1 = new ArrayList<String>();
		
		list1.add("AAAA");
		list1.add("BBBB");
		list1.add("CCCC");
		list1.add("DDDD");
		list1.add("EEEE");
		
		System.out.println("list1 => " + list1);
		System.out.println();
		
		// 데이터 찾기 ==>  contains(찾을자료)
		//          ==> Vector나 List에 '찾을자료'가 있으면 true, 없으면 false
		System.out.println("DDDD값 존재 여부 : " + list1.contains("DDDD"));
		System.out.println("ZZZZ값 존재 여부 : " + list1.contains("ZZZZ"));
		
		// 데이터 찾기 2 ==> indexOf(찾을자료)
		//					lastIndexOf(찾을자료)
		//			 ==>Vector나 List에 '찾을자료'가 있으면 '찾을자료'가 저장된 'index값'을
		//				반환하고 없으면 -1을 반환한다.
		//           ==> indexOf()메서드는 앞에서 뒤쪽방향으로 검색하고
		//			 	 lastIndexOf()메서드는 뒤에서 앞쪽 방향으로 검색한다.
		list1.add("AAAA");
		list1.add("BBBB");
		list1.add("CCCC");
		list1.add("DDDD");
		list1.add("EEEE");
		
		System.out.println("list1 => " + list1);
		System.out.println();
		
		System.out.println("DDDD의 위치값 : " + list1.indexOf("DDDD"));
		System.out.println("DDDD의 위치값 : " + list1.lastIndexOf("DDDD"));
		System.out.println("ZZZZ의 위치값 : " + list1.indexOf("ZZZZ"));
		System.out.println("ZZZZ의 위치값 : " + list1.lastIndexOf("ZZZZ"));
	
		// List 자료를 배열로 변환하기 ==> toArray()
		// 						   ==> 기본적으로 Object형 배열로 변환한다.
		
		//						  ==> toArray(new 제네릭타입[0])
		//						   ==> 제네릭타입의 배열로 변환해서 반환한다.
		Object[] strArr = list1.toArray();
		System.out.println("list1의 개수 : " + list1.size());
		System.out.println("strArr의 개수 : " + strArr.length);
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(i + "번째 자료 : " + strArr[i]);
			//String temp = (String)strArr[i];
		}
		System.out.println("-----------------------------------");
		
		// String[] strArr2 = (String[])list1.toArray();  // 오류 : 형변환 사용불가
		String[] strArr2 = list1.toArray(new String[0]);
		for(String s :strArr2) {
			System.out.println(s);
		}
		System.out.println("-----------------------------------");
		
	}
}
