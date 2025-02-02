package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

// 이 쓰레드 클래스는 소켓에서 메시지를 받아서 화면에 출력하는 역할을 담당한다.
public class Receiver extends Thread {
	private Socket socket;
	private DataInputStream din;
	private FileOutputStream fout;
	
	// 생성자
	public Receiver(Socket socket) {
		this.socket = socket;
		
		try {
			// 소켓으로 입력 받은 스트림 객체 생성
			din = new DataInputStream(this.socket.getInputStream());
				
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while(din!=null) {
			try {
				System.out.println(din.readUTF());				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
