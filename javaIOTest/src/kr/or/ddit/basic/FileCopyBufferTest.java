package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	'd:/d_other/' 폴더에 저장된 'lion.png'파일을
	'd:/d_other/연습용' 폴더에 '복사본_lion.png'파일로
	복사하는 프로그램을 작성하시오.
*/
public class FileCopyBufferTest {

	public static void main(String[] args) {
		File file = new File("d:/d_other/lion.png");
		
		if(!file.exists()) {
			System.out.println(file.getPath() + "파일이 없습니다.");
			System.out.println("복사 작업을 중지합니다.");
			return;
		}
		
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			
			// 대상 파일에 저장할 스트림 객체 생성
			fout = new FileOutputStream("d:/d_other/연습용/복사본_lion.png");
			bout = new BufferedOutputStream(fout);
			
			System.out.println("복사 시작");
			
			int data;	// 읽어온 데이터를 저장할 변수
			
//			while((data = fin.read()) != -1) {
//				fout.write(data);
//			}
			
			while((data = bin.read()) != -1) {
				bout.write(data);
			}
			
			bout.flush();
			
			System.out.println("복사 작업 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if(fin!=null) try { fin.close(); } catch (IOException e) {}
//			if(fin!=null) try { fout.close(); } catch (IOException e) {}
			if(bin!=null) try { bin.close(); } catch (IOException e) {}
			if(bout!=null) try { bout.close(); } catch (IOException e) {}
			
		}
	}

}
