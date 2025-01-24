package enumTest;

/*
 	enum(열거형) ==> 서로 관련있는 상수들의 집합을 나타낸다.
 			    ==> 클래스처럼 보이게 하는 상수
 	
 	- 작성 방법
 		1) 클래스처럼 독립된 java 파일에 만들 수 있다.
 		2) 하나의 java 파일에 클래스와 같이 만들 수 있다.
 		3) 클래스의 내부에 내부 클래스처럼 만들 수 있다.
 		
 	- 열거형의 속성 및 메서드
 	 1) 열거형변수.name()  ==> 열거형 상수의 이름을 문자열로 반환한다.
 	 2) 열거형변수.ordinal() ==> 열거형 상수가 정의된 순서값(index값)을 반환한다.
 	 						   (0부터 시작한다.)
 	 3) 열거형이름.valueOf("열거형상수명") ==> 인수값으로 지정한 '열거형상수명'과
 	 				일치하는 열거형 상수를 반환한다.
 	 4) 열거형이름.상수명	   ==> valueOf()메서드와 같다.
	 5) 열거형이름.values()  ==> 모든 상수들을 배열 형태로 가져온다.
	 
//------------------------------------------------------
 	- 열거형 선언하기
 	형식1) enum 열거형이름 {상수명1, 상수명2, 상수명3, ... }
 	
 	형식2) enum 열거형이름 {
 			   상수명1(값들1,...),
 			   상수명2(값들2,...),
 			   ...
 			   상수명n(값들n...);
 			   
 			   // '값들'이 저장될 변수들을 선언한다.
 		 	   private 자료형이름 변수명;
 		 	   private 자료형이름 변수명;
 		 	   ...
 		 	   
 		 	   // 열거형의 생성자를 만든다.
 		 	   // 열거형의 생성자는 '열거형상수'에 '값들'을 셋팅하는 역할을 한다.
 		 	   // 열거형 생성자는 묵시적으로 'private'이다.
 		 	   // 열거형 생성자의 매개변수는 '값들'과 갯수가 같고, 자료형이 맞아야 된다.
 		 	   private 열거형 이름(자료형이름 변수명1, ...){
 		 	   		위에 선언된 변수들을 초기화 한다.
 		 	   		...
 			   }
 			   
 			   // 위에 선언한 변수들을 외부에서 불러올 수 있는 getter 메서드를 작성한다.
 			   
 			
 	
 */
public class EnumTest {
	// 클래스 내부에 내부 클래스처럼 만들기 
	public enum Color { RED, GREEN, BLUE }
	public enum Count { ONE, TWO, THREE }  //0 1 2 순서
	
	public static void main(String[] args) {
		// 열거형 변수 선언 및 초기화 히기
		Color mycol;	// 변수 선언
		mycol = Color.RED; // 초기화  ==> Color.valueOf("RED")와 같다.
		
		Count mycnt = Count.valueOf("THREE");  // ==> Count.THREE와 같다.
		
		System.out.println("mycol : " + mycol);
		System.out.println("mycnt : " + mycnt.name());
		System.out.println();
		
		System.out.println("mycol의 ordinal : " + mycol.ordinal());
		System.out.println("mycnt의 ordinal : " + mycnt.ordinal());
		System.out.println();
		
		for(Count temp : Count.values()) {
			System.out.println("name : " + temp.name());
			System.out.println("ordinal : " + temp.ordinal());
			System.out.println("--------------------------");
		}
		
		System.out.println("---------------------------------------s");
		//mycol = Color.GREEN;
		// 열거형의 데이터를 if문으로 비교할 때는 '=='연산자를 사용한다.
		if(mycol == Color.GREEN) {
			System.out.println("GREEN이 맞다.");
		}else {
			System.out.println("GREEN이 아니다.");
		}
		
		/*
		if(Color.RED == Count.ONE) {  // 다른 종류의 열거형끼리의 비교는 불가능하다.
			
		}
		*/
		
		// 열거형을 switch문에서 비교하기
		// case 옆에는 '상수명'만 기술해야 한다.
		switch(mycol) {
			case RED :
				System.out.println("RED입니다."); break;
			case GREEN : 
				System.out.println("green이네요"); break;
			case BLUE : 
				System.out.println("파랑이군요"); break;
//			case Color.BULE :   //case 열거형이름.상수명 : ==> 이것은 사용불가
//                      break;
		}
		
		//-----------------------------------------------
		System.out.println("=========================");
		//Season ss = Season.valueOf("봄");
		
		for(Season ss : Season.values()) {
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println("temp : " + ss.getTemp());
		System.out.println();
	}
}

// 하나의 Java파일에 클래스와 같이 만들기
enum Season{
	// 상수명 (값들...) 형식의 선언
	봄("3월부터 5월까지", 13), 
	여름("6월부터 8월까지", 27), 
	가을("9월부터 11월까지", 15), 
	겨울("12월부터 2월까지", 1);
	
	// 값들이 저장될 변수들 선언 
	private String span;
	private int temp;
	
	// 생성자 만들기
	// ==> private Season(String months, int temp){ // 와 같다.
	Season(String months, int temp){  
		span = months;
		this.temp = temp;
	}
	
	// getter 메서드 작성
	public String getSpan() {
		return span;
	}
	
	public int getTemp() {
		return temp;
	}
}
}