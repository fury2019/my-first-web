package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {
	
	public static void main(String[] args) {
		new TcpClient02().chatClientStart();
	}
	
	// 시작 메서드
	// 소켓 객체를 생성해서 서버에 접속하고, 접속이 완료되면
	// 메시지를 받는 쓰레드와 메시지를 보내는 쓰레드에 이 소켓 객체를
	// 주입하고 이 쓰레드들을 실행시킨다.
	public void chatClientStart() {
		try {
			Socket socket = new Socket("localhost", 7777);
			
			System.out.println("서버에 연결되었습니다");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
