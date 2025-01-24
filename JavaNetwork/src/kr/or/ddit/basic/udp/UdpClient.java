package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			// 소켓 객체 생성 
			DatagramSocket socket = new DatagramSocket();
			
			// 상대방의 IP 정보 만들기
//			InetAddress address = InetAddress.getByName("localhost");
			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			while(true) {
				// 전송할 메시지 입력 
				System.out.println("전송할 메시지 입력 >>");
				String msg = scan.nextLine();
				
				byte[] sendMsg = msg.getBytes("utf-8");
				
				// 전송용 패킷객체 생성 
				DatagramPacket outPacket = 
						new DatagramPacket(sendMsg, sendMsg.length, address, 8888);
				
				// 전송하기
				socket.send(outPacket);
				
				if("/end".equals(msg)) {
					break;		// 반복문 탈출
				}
				
				System.out.println();
				
				// 메시지 수신하기
				byte[] inMsg = new byte[1024];
				
				// 수신용 패킷 객체 생성
				DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);
				
				// 수신하기
				socket.receive(inPacket);
				
				// 화면 출력
				String receiveMsg = new String(inMsg, 0, inPacket.getLength(), "utf-8");
				System.out.println("서버의 응답 메시지 : " + receiveMsg);
				System.out.println();
				
			}
			
			System.out.println("통신 끝");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
