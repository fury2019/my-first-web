package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClient01 {

   public static void main(String[] args) throws UnknownHostException, IOException {
      Scanner scan = new Scanner(System.in);
      
      // 통신에서 자신 컴퓨터를 나타내는 방법
      //  1) 원래의 IP주소 : 예) 192.168.142.3
      //  2) 지정된 IP주소 : 127.0.0.1
      //  3) 원래의 컴퓨터 이름 : 예) DESKTOP-0EJKKHV
      //  4) 지정된 컴퓨터 이름 : localhost
      
      System.out.println("서버에 접속 합니다...");
      
      // 접속할 서버의 IP주소와 Port번호를 지정하여 Soket객체를 생성한다.
      // Socket객체는 생성이 완료되면 지정한 서버로 요청 신호를 보낸다.
      
      Socket socket = new Socket("localhost", 7777);
      
      // Socket 객체가 생성이 완료되면 서버와 연결이 완료된 상태
      // 서버에 연결된 이후에 처리할 내용을 작성한다.
      System.out.println("서버에 연결되었습니다.");
      System.out.println();
      
      System.out.println("서버로 보낼 메세지 입력 >> ");
      String str = scan.nextLine();
      
      // 입력 받은 문자열을 서버로 보내기
      //       ==> Socket의 OutputStream객체 이용
      OutputStream out = socket.getOutputStream();
      DataOutputStream dout = new DataOutputStream(out);
      dout.writeUTF(str);
      System.out.println("서버로 메세지를 보냈습니다...");
      System.out.println("---------------------------------------------");
      System.out.println();
      
      // 서버가 보내준 메세지 받기
      //       ==> Socket의 InputStream객체 이용
      DataInputStream din = new DataInputStream(socket.getInputStream());
      
      System.out.println("서버로부터 받은 메세지 : " + din.readUTF());
      System.out.println();
      
      System.out.println("연결을 종료합니다...");
      		
      // 스트림과 소켓 닫기
      din.close();
      dout.close();
      socket.close();
      		
      
      
      
   }

}
