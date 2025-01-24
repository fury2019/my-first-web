package kr.or.ddit.basic.sec01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
	/*
	Map ==> key값과 value값을 한 쌍으로 관리하는 객체 
	    - key값은 중복을 허용하지 않고 순서(index)가 없다.(Set의 특징을 갖는다.)
	    - value값은 중복을 허용한다.
	 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 ==> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map의 크기 : " + map.size());
		System.out.println("map => " + map);
		
		// 자료 수정 ==> 데이터를 추가할 때 key값이 같으면 나중에 추가한 값이 저장된다.
		map.put("addr", "서울");
		System.out.println("map => " + map);
		System.out.println();
		
		/*
		// 자료 삭제 ==> remove(key값) : key값이 같은 자료를 찾아 삭제한다.
		//           반환값 : 삭제된 자료의 value값
		String removeTel = map.remove("tel");
		System.out.println("map => " + map);
		System.out.println("삭제된 value값 : " + removeTel);
		System.out.println();
		*/
		
		// 자료 읽기 ==> get(key값)
		System.out.println("이름 : " + map.get("name"));
		System.out.println();
		
		// key값이 존재하는지 여부 검사 ==> containsKey(key값)
		//               ==> 지정한 'key값'이 있으면 true, 없으면 false
		System.out.println("tel 키값의 존재 여부 : " + map.containsKey("tel"));
		System.out.println("tel 키값의 존재 여부 : " + map.containsKey("age"));
		
		// value값이 존재하는지 여부 검사 ==> containsValue(value값)
		System.out.println("'홍길동' 값의 존재 여부 : " + map.containsKey("홍길동"));
		System.out.println("'부산'값의 존재 여부 : " + map.containsKey("부산"));
		System.out.println();
		//--------------------------------------------------------
	
		// Map에 저장된 모든 자료를 읽어와 처리하기
		
		// 방법1 => 모든 key값을 가져와 처리하기
		//           ==> keySet()메서드 이용
		//        		   ==> Map의 모든 key값들을 Set에 담아서 반환한다.
		
		Set<String> keySet = map.keySet();
		
		// Iterator형으로 변환해서 사용하는 방법과 향상된 for문을 이용하는 방법이 있다.
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
	         String key = it.next();
	         String value = map.get(key);
	         System.out.println(key+":"+value);
	      }
	      System.out.println();
	      for(String key : keySet) {
	         String value = map.get(key);
	         System.out.println(key+":"+value);
	      }
	      System.out.println("----------------------------------");
	      
	      
	      // 방법2 ==> 모든 value값을 읽어와 처리하기
	      //          ==> values()메서드 사용
	      //		     ==> value값만 읽어와 Colletion에 담아서 반환한다.
	      for(String v : map.values()) {
	    	  System.out.println(v);
	      }
	      
	      /*
	        방법3 ==> Map에는 Entry라는 내부 class가 만들어져 있다.
	           		 이 Entry클래스는 key와 value라는 이름의 멤버변수로 구성되어 있다.
	           	     Map에서는 이 Entry클래스들을 Set형식으로 저장하여 관리한다.
	           	     
	        이 Entry객체 전체를 가져와 처리하기 ==> entrySet()메서드 이용
	        (가져온 Entry들은 Set형식으로 되어 있다.)
	       */
	      
	      // Entry라는 내부 객체 전체 가져오기
	      Set<Map.Entry<String, String>>mapSet = map.entrySet();
	      
	      Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
	      
	      while(entryIt.hasNext()) {
	    	  // Entry객체 1개 가져오기
	    	  Map.Entry<String, String> entry = entryIt.next();
	    	  
	    	  System.out.println("key값 : " + entry.getKey());
	    	  System.out.println("value값 : " + entry.getValue());
	    	  System.out.println();
	      }
	}
}
