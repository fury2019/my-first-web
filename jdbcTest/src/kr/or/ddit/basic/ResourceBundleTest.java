package kr.or.ddit.basic;

import java.util.ResourceBundle;

/*
 	ResourceBundle객체 ==> 파일의 확장자가 '.properties'인 파일의
 			내용을 읽어오 key값과 value값을 분리해서 갖고있는 객체
 */
public class ResourceBundleTest {
	
	public static void main(String[] args) {
		
		// ResourceBundle 객체를 이용하여 파일 읽어오기
		
		// ResourceBundle 객체 생성
		// ==> 읽어올 파일을 지정할 때 '패키지명.파일명'만 지정하고
		//	   확장자는 지정하지 않는다.
		//     (이유: 확장자는 항상 '.properties'이기 때문에...)
		// ==> 객체 생성이 완료되면 읽어온 파일이 REsourceBundle객체에 
		//	   저장되어 있다.
		ResourceBundle bundle = 
				ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		
		// 읽어온 내용 출력하기 ==> getString("key값")
		System.out.println("driver : " + bundle.getString("driver"));
		System.out.println("url : " + bundle.getString("url"));
		System.out.println("user : " + bundle.getString("user"));
		System.out.println("pass : " + bundle.getString("pass"));
		
	}
}
