package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
	public static void main(String[] args) throws IOException {
		
		// TCP소켓 통신을 위해 Port번호를 지정하여 ServerSocket객체를 생성한다.
		ServerSocket server = new ServerSocket(7777);
		System.out.println("접속을 준비중입니다");
		System.out.println();
		
		
		// accept()메서드
		//			==> 클라이언트의 연결 요청이 올 때까지 계속 기다린다.
		//			==> 연결 요청이 오면 새로운 Socket객체를 생성해서 클라이언트의
		//				Socket과 연결한다.
		Socket socket = server.accept();
		
		// accept()메서드 호출 이후의 내용은 클라이언트와
		// 연결된 후에 실행될 내용들이다.
		System.out.println("클라이언트가 연결되었습니다");
		
		// 연결이 완료되면 연결된 상대방의 정보를 알 수 있다.
		System.out.println("접속한 상대방 정보");
		System.out.println("IP 주소 : " + socket.getInetAddress().getHostAddress());
		System.out.println("Port 번호 : " + socket.getPort());
		System.out.println();
		
		System.out.println("내 컴의 정보");
		System.out.println("내컴의 IP주소 : " + socket.getLocalAddress());
		System.out.println("내컴의 Port 번호 : " + socket.getLocalPort());
		System.out.println();
		
		// 클라이언트가 보내온 메시지를 받아서 출력한 후
		// 받은 메시지를 그대로 클라이언트에게 보내기
		
		// 클라이언트가 보내온 메시지 받기
		// ==> Socket객체의 InputStream객체를 이용한다.
		// ==> Socket객체의 getInputStream()메서드를 이용하여 InputStream객체를
		//	   구할 수 있다.
		
		// 스트림 객체 생성
		InputStream in =socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 메시지를 받아서 출력하기
		String str = din.readUTF();
		System.out.println("클라이언트로부터 받은 메시지 : " + str);
		System.out.println();
		System.out.println("----------------------------------");
		
		// 받은 메시지를 다시 클라이언트로 보내기
		//		==> Socket객체의 OutputStream객체를 이용한다.
		//		==> Socket객체의 getOutputStream()메서드를 이용하여
		//			OutputStream객체를 구할 수 있다.
		OutputStream out = socket.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		
		// 메시지 보내기
		dout.writeUTF(str);
		System.out.println("클라이언트에게 메시지를 보냈습니다");
		System.out.println();
		
		System.out.println("연결을 종료합니다");
		
		// 사용했던 스트림과 소켓을 닫아준다.
		dout.close();
		din.close();
		socket.close();
		server.close();
		
		
	}
	
	
}
