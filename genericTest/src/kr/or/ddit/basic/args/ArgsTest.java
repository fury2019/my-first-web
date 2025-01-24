package kr.or.ddit.basic.args;

// 매개변수로 받은 정수들의 합계를 구하는 메서드를 작성하려고 한다.
// 그런데 매개변수로 받은 정수들의 개수는 상황에 따라 다르다. 

/*
 	가변 인자 ==> 메서드를 호출할때마다 인자의 개수가 다를 때 사용한다. 
 	   - 가변 인자는 메서드 안에서는 배열로 처리된다.
 	   - 가변 인자는 
 */

public class ArgsTest {
	
	// 배열을 이용한 메서드 작성하기 
	public int sumArr(int[] data ) {
		int sum = 0;
		
		/*
		for(int i=0; i<data.length; i++) {
			
		}
		*/
		
		/*
		for(int x : data) {
			sum += x;
		}
		*/
		return sum;
	}
	
	// 가변 인자를 이용한 메서드 작성하기
	public int sumArg(int...data) {
		int sum = 0;
		
		
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		
		/*
		for(int x : data) {
			sum += x;
		}
		*/
		return sum;
	}
	
	// 가변 인자와 매개변수를 같이 사용할 경우에는
	// 가변 인자를 제일 뒤쪽에 배치해야 한다.
	public int sumArg2(String name, int...data) {
		int sum = 0;
		
		
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		
		
		return sum;
	}
	
	public void t(int a) {
		
	}
	
	
	
	public static void main(String[] args) {
		ArgsTest test = new ArgsTest();
		
		int[] nums = {100, 200, 300};
		System.out.println( test.sumArr(nums) );
		
		
		// 배열 선언과 동시에 초기화할때만 사용가능
		int[] arr1 = {1,2,3,4,5,6,7,8,9};
		
//		int[] arr1;
//		arr1 = {1,2,3,4,5,6,7,8,9}; //사용불가

		
		// 배열선언과 동시에 초기화 할 때와 
		// 배열선언 후에 나중에 초기화 할 때 모두 사용가능
		//int[] arr2 = new int[] {1,2,3,4,5,6,7,8,9};
		int[] arr2;
		arr2 = new int[] {1,2,3,4,5,6,7,8,9};	
		
		// 1,2,3,4,5,6,7,8,9 데이터를 갖는 배열 넣기
		System.out.println( test.sumArr( new int[] {1,2,3,4,5,6,7,8,9} ) ); 
		
		
		System.out.println();
		System.out.println( test.sumArg(100,200,300) );
		System.out.println( test.sumArg(1,2,3,4,5,6,7,8,9));
		System.out.println();

		
		System.out.println( test.sumArg2("홍길동", 1,2,3,4,5,6,7,8,9));
		
		
		
	}
}
