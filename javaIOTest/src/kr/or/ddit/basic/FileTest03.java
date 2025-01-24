package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {

	public static void main(String[] args) {
		FileTest03 test = new FileTest03();
		
		
		File file = new File("d:/d_other");
		test.viewDir(file);
	}
	
	// 보고 싶은 디렉토리 정보를 매개변수로 받아서 해당 디렉토리에 있는
	// 모든 파일 및 디렉토리 목록을 출력하는 메서드
	public void viewDir(File dir) {
		if(!dir.isDirectory()) {
			System.out.println("디렉토리(폴더)만 가능합니다");
			return;
		}
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
		System.out.println();
		
		// 해당 디렉토리 안에 있는 모든 파일 및 디렉토리 목록을 구한다.
		File[] fileArr = dir.listFiles();
//		String[] fileStrArr = dir.list();
		
		// 출력할 날짜 형식 만들기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
				
		// 가져온 파일과 디렉토리 목록 개수만클 반복 처리한다.
		for(int i=0; i<fileArr.length; i++) {
			String fileName = fileArr[i].getName();
			String attr = "";	// 파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = "";	// 파일 크기
			
			if(fileArr[i].isDirectory()) {
				attr = "<DIR>";
			}else {
				size = fileArr[i].length() + "";
				attr = fileArr[i].canRead() ? "R" : "";
				attr += fileArr[i].canWrite() ? "W" : "";
				attr += fileArr[i].canExecute() ? "E" : "";
				attr += fileArr[i].isHidden() ? "H" : "";
			}
			
			// 파일의 마지막 변경 날짜를 출력할 날짜 형식에 맞게 만든다.
			String strDate = sdf.format(new Date(fileArr[i].lastModified()));
			
			System.out.printf("%s %5s %12s %s\n", strDate, attr, size, fileName);
			
		}
	}

}
