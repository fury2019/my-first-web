package kr.or.ddit.basic.enumTest;

public enum Operator {
	
	// 추상 메서드의 구현은 각각의 상수에서 한다.
	PLUS("+"){
		 @Override
		public int calculate(int num1, int num2) {
			return num1 + num2; 
		}
	},
	MINUS("-"){
		@Override
		public int calculate(int num1, int num2) {
			// TODO Auto-generated method stub
			return num1 - num2;
		}
	},
	MULTIPLY("*"){
		@Override
		public int calculate(int num1, int num2) {
			// TODO Auto-generated method stub
			return num1 * num2;
		}
	},
	DIVIDE("/"){
		@Override
		public int calculate(int num1, int num2) {
			// TODO Auto-generated method stub
			return num1 / num2;
		}
	},
	MODULO("%"){
		@Override
		public int calculate(int num1, int num2) {
			// TODO Auto-generated method stub
			return num1 % num2;
		}
	};
	
	private String symbol;
	
	private Operator(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	// 추상 메서드를 추가해서 기능을 만들수 있다. 구현하기 전까지 오류 잔뜩생김.
	public abstract int calculate(int num1, int num2);
	
}
