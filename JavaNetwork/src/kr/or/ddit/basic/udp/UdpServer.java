package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 	UDP방식 : 비연결 지향, 데이터에 대한 신뢰성이 없다.
 			 데이터가 순서대로 도착한다는 보장이  없다.
 			 그렇지만 TCP방식보다 속도가 빠르다.
 			
 	DatagramSocket 객체와 DatagramPacket객체를 이용해서 통신한다.
 	- DatagramSocket => 데이터의 송수신과 관련된 작업을 수행한다. (우체부)
 	- DatagramPacket => 주고 받는 데이터와 관련된 작업을 수행한다. (소포)
 					 => 수신을 위한 생성자와 송신을 위한 생성자를 따로 제공한다.
 					 
 	TCP의 경우에는 스트림을 이용하여 송수신하지만
 	UDP의 경우에는 데이터그램을 이용하여 송수신한다.
 	
 */
public class UdpServer {
	
	public static void main(String[] args) {
		try {
			// 통신할 port번호를 지정하여 소켓을 생성한다.
			DatagramSocket socket = new DatagramSocket(8888);
			System.out.println("서버 실행 중");
			System.out.println();
			
			while(true) {
				// 수신 받은 메시지가 저장될 변수 선언
				byte[] inMsg = new byte[1024];
				
				// 수신용 패킷 객체 생성
				// ==> 데이터가 저장될 byte형 배열, 이 배열의 길이를 인수로 
				//     설정하여 생성한다.
				DatagramPacket inpacket = new DatagramPacket(inMsg, inMsg.length);
				
				// 데이터 수신하기 ==> DatagramSocket객체의 receiver()메서드 이용
				//   ==> 이 메서드는 데이터 올 때까지 기다린다.
				//	 ==> 수신된 데이터의 패킷정보는 receive()메서드를 호출할 때
				//		 지정한 '수신용 패킷'에 저장된다.
				socket.receive(inpacket);
				
				// 수신 받은 패킷에서 상대방의 주소, 포트번호 등을 알 수 있다.
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();
				
				System.out.println("상대방의 IP정보 : " + address);
				System.out.println("상대방의 Port번호 : " + port);
				System.out.println();
				
				// 상대방이 보낸 메시지를 화면에 출력하기
				// 수신용패킷객체.gerData() 
				//		   ==> 실제로 읽어온 데이터를 byte형 배열로 반환한다.
				//		   ==> 수신용패킷객체를 생성할 때 지정한 byte형 배열에도
				//			   수신 받은 데이터가 저장된다.
				
				// 수신용패킷객체.getLength() ==> 실제 읽어온 데이터의 길이를 반환
				
				// byte형 배열의 데이터를 문자열(String)로 변환해서 출력한다.
				String msg = new String(inMsg, 0, inpacket.getLength(), "utf-8");
				
				// 통신 작업 종료 메시지 확인하기
				if("/end".equals(msg)) {
					break;		// 반복문 탈출
				}
				
				
				
				System.out.println("상대방이 보낸 메시지 : " + msg);
				System.out.println();
				
				//--------------------------------------------------------
				
				// 상대방에게 메시지 보내기 ( 수신받은 메시지를 그대로 송신하기 )
				
				// 송신할 메시지를 byte형 배열로 변환한다.
				byte[] sendMsg = msg.getBytes("utf-8");
				
				// 송신용 패킷 객체 생성
				//		==> 전송할 데이터가 저장된 byte형 배열,
				//			전송할 자료의 길이(배열의 길이), 
				//			상대방의 IP정보,
				//			상대방의 Port번호
				//			이렇게 4가지를 생성자의 인수값으로 지정하여 생성한다.
				DatagramPacket outPacket = 
						new DatagramPacket(sendMsg, sendMsg.length, address, port);
				
				// 데이터 송신하기 ==> DatagramSocket객체의 send()메서드를 이용한다.
				//		==> 이 메서드를 호출할 때 인수값으로 송신용패킷객체를 지정한다.
				socket.send(outPacket);
				
				System.out.println("송신 완료");
				System.out.println();
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
