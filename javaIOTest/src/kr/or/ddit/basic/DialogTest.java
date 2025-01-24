package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {
	public static void main(String[] args) {
		// AWT -> SWING -> javaFX
		// SWING의 파일 열기 창, 파일 저장 창 연습
		
		JFileChooser chooser = new JFileChooser();
		
		// 화면에 보여줄 파일의 확장자를 설정할 객체 생성
		FileNameExtensionFilter doc = 
				new FileNameExtensionFilter("MS Word File", "docx", "doc");
		FileNameExtensionFilter img =
				new FileNameExtensionFilter("Images File", 
						new String[] {"png", "jpg", "gif"});
		FileNameExtensionFilter txt = 
				new FileNameExtensionFilter("Text파일", "txt");
		
		// 확장자 목록 중에서 '모든 파일 목록' 표시 여부 설정(true:설정, false:해제)
		//			==> 기본값은 true이다.
		chooser.setAcceptAllFileFilterUsed(false);
		
		// 확장자 설정 객체를 Chooser객체에 추가한다.
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		// 설정한 확장자들 중에서 기본적으로 선택될 확장자 지정하기
		chooser.setFileFilter(txt);
		
		// Dialog 창에 나타날 기본 경로 설정하기
		chooser.setCurrentDirectory(new File("d:/d_other"));
		
		
		// 창 띄우기
//		int result = chooser.showOpenDialog(new Panel());	// 열기용
		int result = chooser.showSaveDialog(new Panel());	// 저장용
		
		
		// 띄어진 창에서 '저장' 또는 '열기'버튼을 눌렀을 때 처리
		if( result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			System.out.println("선택한 파일 : " + selectedFile.getAbsolutePath());
		
			// '선택할 파일'을 이용하여 실제 입출력 작업은 스트림 객체를 이용하여 처리한다.
			// 스트림 객체를 이용하여 처리한다.
		}
		
		
	}
}
