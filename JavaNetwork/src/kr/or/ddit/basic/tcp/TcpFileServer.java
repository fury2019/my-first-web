package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
   private ServerSocket server;
   private Socket socket;
   
   private DataInputStream din;      
   
   private BufferedInputStream bin;
   private BufferedOutputStream bout;
   
   public static void main(String[] args) {
      new TcpFileServer().serverStart();
   }
   // 시작 메서드
   public void serverStart() {
      File saveDir = new File("d:/d_other/연습용");
      if(!saveDir.exists()) {      // 저장할 폴더가 없으면..
         saveDir.mkdir();      // 폴더 생성
      }
   
      try {
         server = new ServerSocket(7777);
         System.out.println("서버가 준비되었습니다...");
         System.out.println();
         
         socket = server.accept();   // 클라이언트의 요청을 기다린다.
         
         System.out.println("파일 수신 시작..");
         
         // 클라이언트가 첫번째로 보내온 파일명을 받기 위한 스트림 객체 생성
         din = new DataInputStream(socket.getInputStream());
         
         String fileName = din.readUTF();   // 파일명 읽기(수신)
         
         // 저장될 파일 정보를 갖는 File 객체 생성
         File savFile = new File(saveDir, fileName);
         
         // 소켓으로 읽어올 스트림 객체 생성
         bin = new BufferedInputStream(din);
         
         // 파일로 출력할 스트림 객체 생성
         bout = new BufferedOutputStream(new FileOutputStream(savFile));
         
         byte[] temp = new byte[1024];
         int len = 0;
         
         // 소켓으로 읽어서 파일로 출력
         while((len = bin.read(temp))>0) {
            bout.write(temp, 0, len);
         }
         bout.flush();
         
         System.out.println("파일 수신 작업 완료..");
      } catch (Exception e) {
         System.out.println("파일 수신 작업 실패!!");
         e.printStackTrace();
      }finally {
         // 자원 반납
         if(din!=null) try { din.close(); } catch(IOException e) {}
           if(bin!=null) try { bin.close(); } catch(IOException e) {}
           if(bout!=null) try { bout.close(); } catch(IOException e) {}
           if(socket!=null) try { socket.close(); } catch(IOException e) {}
           if(server!=null) try { server.close(); } catch(IOException e) {}
      }
   }
}
