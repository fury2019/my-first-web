package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	}

	// 시작 메서드
	public void clientStart() {
		Socket socket = null;
		try {
			socket = new Socket("192.168.142.23", 7777);
			System.out.println("서버에 연결되었습니다");
			System.out.println();
			// --------------------------------------
			// 전송용 쓰레드와 수신용 쓰레드 실행하기
			ClientSender sender = new ClientSender(socket);
			ClientReceiver receiver = new ClientReceiver(socket);

			sender.start();
			receiver.start();

		} catch (Exception e) {
			// TODO: handle exception
		}

	} // 시작 메서드 끝

	// --------------------------------------------

	// 메시지 전송용 쓰레드 클래스 작성
	class ClientSender extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;

		private String name; // 대화명 저장 변수
		private Scanner scan;

		// 생성자
		public ClientSender(Socket socket) {
			this.socket = socket;
			scan = new Scanner(System.in);
			try {
				// 수신용
				din = new DataInputStream(this.socket.getInputStream());

				// 송신용
				dout = new DataOutputStream(this.socket.getOutputStream());

				if (din != null) {

					// 클라이언트는 서버와 접속이 완료되면 첫번째로 '대화명'을
					// 입력 받아 전송하고, '대화명'의 중복 여부를 응답으로 받아서
					// 확인한다.
					while (true) {
						System.out.print("대화명 입력 >>");
						String name = scan.nextLine();

						dout.writeUTF(name); // '대화명'전송

						// 서버로부터 중복 여부의 응답결과를 수신한다.
						String feedBack = din.readUTF();

						if ("대화명 중복".equals(feedBack)) { // 대화명이 중복될 때
							System.out.println(name + "는 중복된 대화명입니다.");
							System.out.println("다른 대화명을 입력하세요");
							System.out.println();
						} else { // 중복되지 않을 때
							this.name = name;
							System.out.println(name + "대화명으로 대화방에 입장했습니다");
							break; // 반복문 탈출

						}
					} // while문 끝

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 생성자 끝

		@Override
		public void run() {
			try {
				while (dout != null) {
					// 키보드로 입력한 메시지를 서버로 전송한다.
					dout.writeUTF("[" + name + "]" + scan.nextLine());
					;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	} // 전송용 쓰레드 끝

	// -------------------------------------------

	// 메시지 수신용 쓰레드 클래스
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;

		// 생성자
		public ClientReceiver(Socket socket) {
			this.socket = socket;

			try {
				din = new DataInputStream(this.socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// 생성자 끝

		@Override
		public void run() {
			try {
				while (din != null) {
					// 서버로부터 수신 받은 메시지를 화면에 출력한다
					System.out.println(din.readUTF());
				} // while
			} catch (Exception e) {
				// TODO: handle exception

			}
		}
	}

}
