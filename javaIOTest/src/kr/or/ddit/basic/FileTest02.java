package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("d:/d_other/test.txt");
		
		System.out.println(f1.getName() + "의 크기 : " + f1.length() + "byte(s)");
		System.out.println("path : " + f1.getPath());
		System.out.println("absolutePath : " + f1.getAbsolutePath());
		System.out.println();
		
		// 현재 위치 나타내기
		File f2 = new File(".");
		System.out.println("path : " + f2.getPath());
		System.out.println("absolutePath : " + f2.getAbsolutePath());
		System.out.println();
		
		if(f1.isFile()) {
			System.out.println(f1.getName() + "은 파일입니다");
		}else if(f1.isDirectory()) {
			System.out.println(f1.getName() + "은 디렉토리입니다");
		}else {
			System.out.println(f1.getName() + "은 뭘까요?");
		}
		
		File f3 = new File("d:/d_other/sample.txt");
		if(f3.isFile()) {
			System.out.println(f3.getName() + "은 파일입니다");
		}else if(f3.isDirectory()) {
			System.out.println(f3.getName() + "은 디렉토리입니다");
		}else {
			System.out.println(f3.getName() + "은 뭘까요?");
		}
		
		if(f3.exists()) {
			System.out.println(f3.getAbsolutePath() + "은 존재합니다");
		}else {
			System.out.println(f3.getAbsolutePath() + "은 존재하지 않습니다");
			try {
				if(f3.createNewFile()) {
					System.out.println(f3.getAbsolutePath()
							+ "파일을 새로 만들었습니다");
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
