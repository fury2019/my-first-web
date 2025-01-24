package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

//클라이언트는 서버에 접속이 완료되면 클라이언트 컴퓨터의 'f:/d_other/'폴더에 있는
//'lion.png'파일을 읽어서 서버로 전송한다.
// (파일스트림으로 읽어서 소켓 스트림으로 출력(저장) )
public class TcpFileClient {

   private Socket socket;
   private DataOutputStream dout; // 파밀명 전송용

   private BufferedOutputStream bout;
   private BufferedInputStream bin;

   public static void main(String[] args) {
      new TcpFileClient().ClientStart();
   }

   // 시작 메서드
   public void ClientStart() {
      // 전송할 파일 정보를 갖는 File객체 생성
//      File file = new File("f:/d_other/lion.png");
      File file = viewDialog("OPEN");
      
      if(file == null) {
         System.out.println("전송할 파일을 선택하세요...");
         return;
      }
      if (!file.exists()) {
         System.out.println(file.getPath() + " 파일이 없습니다.");
         System.out.println("전송 작업을 중단합니다...");
         return;
      }

      try {
         socket = new Socket("localhost", 7777);

         System.out.println("파일 전송 시작...");

         // 접속 후
         // 파일명을 전송하기 위한 스트림 객체 생성
         dout = new DataOutputStream(socket.getOutputStream());

         dout.writeUTF(file.getName()); // 파일명 전송

         // 전송할 파일을 읽어올 스트림 객체 생성
         bin = new BufferedInputStream(new FileInputStream(file));

         // 서버로 전송할 출력용 스트림 객체 생성(소켓이용)
         bout = new BufferedOutputStream(dout);

         byte[] temp = new byte[1024];
         int len = 0;

         // 파일을 읽어서 소켓으로 전송(출력)하기
         while ((len = bin.read(temp)) > 0) {
            bout.write(temp, 0, len);
         }
         bout.flush(); // 버퍼 사용후 지우기

         System.out.println("파일 전송 작업 완료...");

      } catch (Exception e) {
         System.out.println("파일 전송 작업 실패!!!");
         e.printStackTrace();
      } finally {
         // 자원 반납
         if (dout != null)
            try {
               dout.close();
            } catch (IOException e) {
            }
         if (bout != null)
            try {
               bout.close();
            } catch (IOException e) {
            }
         if (bin != null)
            try {
               bin.close();
            } catch (IOException e) {
            }
         if (socket != null)
            try {
               socket.close();
            } catch (IOException e) {
            }
      }
   }

   // Dialog 창을 나타내고 선택한 File객체를 반환하는 메서드
   private File viewDialog(String type) {
      // AWT -> SWING -> javaFX
      // SWING의 파일 열기, 파일 저장 창 연습

      JFileChooser chooser = new JFileChooser();
      
      // 화면에 보여줄 파일의 확장자 설정할 객체 생성
      FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word File", "docx", "doc"); // 가변 인수
      FileNameExtensionFilter img = new FileNameExtensionFilter("Images File", new String[] { "png", "jpg", "gif" }); // 배열
      FileNameExtensionFilter txt = new FileNameExtensionFilter("Text파일", "txt");

      // 확장자 목록 중에서 '모든 파일 목록' 표시 여부 설정(true:설정, false:해제)
      // ==> 기본값은 true이다.
      chooser.setAcceptAllFileFilterUsed(true);

      // 확장자 설정 객체를 Chooser객체에 추가한다.
      chooser.addChoosableFileFilter(doc);
      chooser.addChoosableFileFilter(img);
      chooser.addChoosableFileFilter(txt);

      // 설정한 확장자 중에서 기본적으로 선택될 확장자 지정하기 -> 설정하지 않으면 첫번째 필터가 선택된다.
      chooser.setFileFilter(txt); // 텍스트 파일을 처음부터 선택된 상태에서 창이 열림

      // Dialog 창에 나타날 기본 경로 설정하기 -> 처음에 나타날 디렉토리 설정
      chooser.setCurrentDirectory(new File("d:/d_other"));

      int result;
      // 창 띄우기4
      if ("OPEN".equals(type.toUpperCase())) {
         result = chooser.showOpenDialog(new Panel()); // 열기용
      } else if ("SAVE".equals(type.toUpperCase())) {
         result = chooser.showSaveDialog(new Panel()); // 저장용
      } else {
         System.out.println("viewDialog()메서드의 매개변수로 'OPEN'" + "또는 'SAVE'를 지정하세요");
         return null;
      }

      File selectedFile = null;
      // 띄어진 창에서 '저장' 또는 '열기' 버튼을 눌렀을 때 처리
      if (result == JFileChooser.APPROVE_OPTION) { // 저장 버튼이나 열기 버튼을 누를때
         selectedFile = chooser.getSelectedFile();
      }
      return selectedFile;
   }
}
