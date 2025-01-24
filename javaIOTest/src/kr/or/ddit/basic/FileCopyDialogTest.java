package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
    'e:/d_other/' 폴더에 저장된 'lion.png'파일을 
    'e:/d_other/연습용' 폴더에 '복사본_lion.png'파일로 복사하는 프로그램을 만드세요. 
 */
public class FileCopyDialogTest {
   
   public static void main(String[] args) {
      new FileCopyDialogTest().copyStart();
   }

   public void copyStart() {
//      File file = new File("e:/d_other/lion.png");
      File file = viewDialog("OPEN");
      
      if(file == null) {
         System.out.println("복사할 원본 파일을 선택");
         return;
      }
      
      if(!file.exists()) {
         System.out.println(file.getPath()+" 파일이 없습니다.");
         System.out.println("복사 작업을 중지합니다.");
         return;
      }
      
      File targetFile = viewDialog("save");
      if(targetFile == null) {
         System.out.println("대상 파일을 선택한 후 사용하세요");
         return;
      }
      
      FileInputStream fin = null;
      FileOutputStream fout = null;
      
      try {
         // 원본 파일을 읽어올 스트림 객체 생성 
         fin = new FileInputStream(file);
         
         // 대상 파일에 저장할 스트림 객체 생성
         fout = new FileOutputStream("e:/d_other/연습용/복사본_lion.png");
         
         System.out.println("복사 시작 ... ");
         
         int data; // 읽어온 데이터를 저장할 변수 
         
         while((data=fin.read()) != -1) {
            fout.write(data);
         }
         
         System.out.println("복사 작업 완료 ...");
         
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if(fin!=null) try { fin.close(); } catch(IOException e) {}
         if(fout!=null) try { fout.close(); } catch(IOException e) {}
      }
      
   }
   
   // Dialog 창을 나타내고 선택한 File객체를 반환하는 메서드
   private File viewDialog(String type) {
      // AWT -> SWING -> javaFX
      // SWING의 파일 열기 창, 파일 저장 창 연습
            
      JFileChooser chooser = new JFileChooser();
            
      // 화면에 보여줄 파일의 확장자 설정하기
      FileNameExtensionFilter doc =                  // 가변인수
            new FileNameExtensionFilter("MS Word File", "docx", "doc");
      FileNameExtensionFilter img =                   // 스트링 배열
            new FileNameExtensionFilter("Images File", new String[] {"png","jpg","gif"});
      FileNameExtensionFilter txt = 
            new FileNameExtensionFilter("Text파일", "txt");
            
      // 확장자 목록 중에서 '모든 파일 목록' 표시 여부 설정(true: 설정, false: 해제)
      //         ==> 기본값은 true이다.
      chooser.setAcceptAllFileFilterUsed(true);
            
      // 확장자 설정 객체를 Chooser 객체에 추가한다.
      chooser.addChoosableFileFilter(doc);
      chooser.addChoosableFileFilter(img);
      chooser.addChoosableFileFilter(txt);
            
      // 설정한 확장자들 중에서 기본적으로 선택될 확장자 지정하기
      //chooser.setFileFilter(txt);
      
      // Dialog 창에 나타날 기본 경로 설정하기 
      chooser.setCurrentDirectory(new File("e:/d_other"));
      
      int result;
      // 창 띄우기
      if("OPEN".equals(type.toUpperCase())) {
         result = chooser.showOpenDialog(new Panel()); // 열기용
      } else if("SAVE".equals(type.toUpperCase())) {
         result = chooser.showSaveDialog(new Panel()); // 저장용
      } else {
         System.out.println("viewDialog()메서드의 매개변수로 'OPEN'"
               +"또는 'SAVE'를 지정하세요.");
          return null;
      }
      
      File selectedFile = null;
      // 띄어진 창에서 '저장' 또는 '열기' 버튼을 눌렀을 때 처리
      if( result == JFileChooser.APPROVE_OPTION) {
         selectedFile = chooser.getSelectedFile();
         System.out.println("선택한 파일 : "+selectedFile.getAbsolutePath());
      }
      return selectedFile;
   }
}
