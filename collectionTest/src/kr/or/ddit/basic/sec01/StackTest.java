package kr.or.ddit.basic.sec01;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Browser b = new Browser();
		
		System.out.println("처음");
		b.history();
		
		b.goURL("1.네이버");
		b.history();
		
		b.goURL("2.야후");
		b.history();
		
		b.goURL("3.구글");
		b.history();
		
		b.goURL("4.다음");
		b.history();
		
		System.out.println("뒤로가기 후");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기 후");
		b.goBack();
		b.history();
		
		System.out.println("앞으로가기 후");
		b.goForward();
		b.history();
		
		System.out.println("새로운 사이트 접속하기");
		b.goURL("5.네이트");
		b.history();
	}
}

// 스택을 이용하여 웹브라우저의 앞으로가기, 뒤로가기 기능구현
class Browser{
	private Stack<String> back;  // 이전 방문 내역이 저장될 스택
	private Stack<String> forward; // 다음 방문 내역이 저장될 스택
	
	private String currentURL;     // 현재 페이지
	
	// 생성자
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	}
	
	// 사이트를 방문하는 메서드 ==> 매개변수에는 방문할 URL이 저장되어 호출된다.
	public void goURL(String url) {
		System.out.println(url + "사이트에 접속합니다");
		if(currentURL!=null && !currentURL.equals("")) { // 현재페이지가 있으면
			back.push(currentURL);		// 현재페이지를 back스택에 추가한다.
		}
		currentURL = url;		// 현재페이지를 변경한다.
		
		// 새로운 페이지를 방문하면 forward 정보가 모두 삭제된다.
		forward.clear();
		
	}
	
	// 뒤로가기
	public void goBack() {
		if(!back.isEmpty()) {  // 뒤로가기 할 정보가 있으면
			forward.push(currentURL);		// 현재 페이지를 forward에 추가
			currentURL = back.pop();		// back스택에서 1개의 요소를 꺼내와 현재페이지로 한다.	
		}
	}
	// 앞으로 가기
	public void goForward() {
		if(!forward.isEmpty()) {  // 앞으로가기 할 정보가 있으면
			back.push(currentURL);  // 현재페이지를 back스택에 추가
			currentURL = forward.pop();  // forward스택에서 1개의 요소를 꺼내와 현재페이지로 한다.
		}
	}
	
	// 방문 내역 확인용 메서드
	public void history() {
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("         방문기록");
		System.out.println("-------------------------");
		System.out.println("back => " + back);
		System.out.println("현재 =>" + currentURL);
		System.out.println("forward => " + forward);
	}
}
	
