package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;
		
public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		
		// www.naver.com의 IP정보 가져오기
		InetAddress nIp = InetAddress.getByName("www.nate.com");
		
		System.out.println("HostName : " + nIp.getHostName());
		System.out.println("HostAddress : " + nIp.getHostAddress());
		System.out.println("toString : " + nIp.toString());
		System.out.println();
		
		// 자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내컴의 HostName : " + localIp.getHostName());
		System.out.println("내컴의 HostAddress : " + localIp.getHostAddress());
		
		// IP주소가 여러개인 호스트의 정보 가져오기 
//		InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
		InetAddress[] ipArr = InetAddress.getAllByName("www.google.com");
		for(InetAddress ip : ipArr) {
			System.out.println(ip.toString());
		}
		
		
		
	}
}
