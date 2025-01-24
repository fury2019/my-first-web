package kr.or.ddit.basic;


public interface LambdaTestInterface01 {
	// 반환값이 없고 매개변수도 없는 메서드
	public void test();
}

@FunctionalInterface
interface LambdaTestInterface02{
	// 반환값이 없고 매개변수가 있는 메서드
	public void test(int a);
}

@FunctionalInterface
interface LambdaTestInterface03{
	// 반환값이 있고 매개변수도 있는 메서드
	public int test(int a, int b);
}


