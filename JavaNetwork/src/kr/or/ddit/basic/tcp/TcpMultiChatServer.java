package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 Map객체
	// ==> key값 : 접속한 사람 이름, value값 : 접속한 Socket객체
	private Map<String, Socket> clientMap;

	// 생성자
	public TcpMultiChatServer() {
		// clientMap을 동기화 처리가 되도록 생성한다.
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
	}

	public static void main(String[] args) {
		new TcpMultiChatServer().serverStart();
	}

	// 시작 메서드
	private void serverStart() {
		ServerSocket server = null;
		Socket socket = null;

		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다");
			System.out.println();

			while (true) {
				socket = server.accept();

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속했습니다");
				System.out.println();
				// -----------------------------------------

				// 쓰레드 객체 생성 및 실행
				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (server != null)
				try {
					server.close();
				} catch (IOException e) {
				}
		}
	} // 시작 메서드 끝

	// clientMap에 저장된 전체 사용자에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {

		// clientMap의 데이터 개수만큼 반복
		for (String name : clientMap.keySet()) {
			try {
				// key값을 이용하여 Socket객체를 구하고 이 Socket객체를
				// 출력용 스트림 객체를 구해서 사용한다.
				DataOutputStream dout = new DataOutputStream(clientMap.get(name).getOutputStream());

				dout.writeUTF(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	} // sendToAll() 메서드 끝

	// ------------------------------------------------------

	// 서버에서 클라이언트로 메시지를 전송하는 Thread 클래스
	// ==> Inner 클래스로 작성한다.
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;

		// 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;

			try {
				// 수신용 스트림 객체 생성
				din = new DataInputStream(this.socket.getInputStream());

				// 송신용 스트림 객체 생성
				dout = new DataOutputStream(this.socket.getOutputStream());

			} catch (Exception e) {
				// TODO: handle exception
			}
		} // 생성자 끝

		@Override
		public void run() {
			String name = "";
			try {
				// 클라이언트가 연결이 성공하면 첫번째로 '대화명'을 입력받아 보낸다.
				// 서버는 이 '대화명'을 받아서 중복되는지 여부의 결과를 응답으로
				// 클라이언트에게 보낸다.

				// 클라이언트가 보내온 '대화명'이 중복되지 않을 때까지 반복한다.
				while (true) {
					name = din.readUTF(); // 클라이언트가 보내온 '대화명'받기

					// 수신 받은 '대화명'의 중복 여부 검사
					if (clientMap.containsKey(name)) { // 중복될 때
						dout.writeUTF("대화명중복"); // '대화명중복' 메시지 전송
					} else { // 중복되지 않을 때
						dout.writeUTF("OK");
						break; // 반복문 탈출
					}
				} // while문 끝

				// 접속한 대화명을 이용하여 다른 전체 클라이언트들에게
				// 대화방 참여 메시지를 전송한다.
				sendToAll("[" + name + "]님이 대화방에 입장했습니다");

				// 대화명과 접속한 Socket객체를 Map에 추가
				clientMap.put(name, socket);

				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");
				System.out.println();

				// 클라이언트가 보낸 메시지를 받아서 전체 클라이언트들에게
				// 다시 보낸다.
				while (din != null) {
					sendToAll(din.readUTF());
				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// 이 finally영역이 실행된다는 것은 클라이언트가 접속을 종료했다는
				// 의미이다.

				sendToAll("[" + name + "]님이 접속을 종료했습니다");

				// 사용자 목록(clientMap)에서 해당 대화명 정보를 삭제한다.
				clientMap.remove(name);

				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "] 에서 접속종료");
				System.out.println();
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");

			}
		} // run()메서드 끝

	} // ServerReceiver 클래스 끝

}
