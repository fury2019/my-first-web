package kr.or.ddit.member.controller;

import java.util.Scanner;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.util.ScanUtill;
import kr.or.ddit.member.vo.MemberVO;

public class MemberController {
	private Scanner scan;
	private MemberService service;
	
	//생성자
	public MemberController() {
		
		service = new MemberService();
	}
	
	public static void main(String[] args) {
		new MemberController().MyMemberStart();
	}
	
	private int displayMenu() {
		System.out.println("==========================");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 전체 항목 수정");
		System.out.println("4. 전체자료 출력");
		System.out.println("5. 자료 선택 항목 수정");
		System.out.println("0. 작업 끝");
		System.out.println("==========================");
		System.out.println("작업 번호 선택 >> ");
		
		return ScanUtill.nextInt();
	}
	public void MyMemberStart() {
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println("       회 원 관 리 프 로 그 램     ");
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1 : 	// 자료 추가
				insertMember();
				break;
			case 2 : 	// 자료 삭제
				deleteMember();
				break;
			case 3 :    // 자료 수정
				updateMember();
				break;
			case 4 : 	// 전체 자료 출력
//				displayAllMember();
				break;
			case 5 :    // 선택 자료 수정
//				chooseUpdate();
				break;
			case 0 :	// 작업 끝
				System.out.println("회원 관리 프로그램을 종료합니다");
				return;
			default : 
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 선택하세요.");
			}
		}
	}
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원정보를 입력하세요.");
		String memId = ScanUtill.nextLine("수정할 회원 ID >>");
		
		int count = service.getMemberCount(memId);
		if(count==0) {
			System.out.println(memId + "는 없는 회원ID입니다.");
			System.out.println("수정 작업을 마칩니다.");
			return;
		}
		System.out.println();
		System.out.println("수정 할 내용을 입력하세요.");
		String newMemPass = ScanUtill.nextLine("새로운 비밀번호 >> ");
		String newMemName = ScanUtill.nextLine("새로운 회원이름 >>");
		String newMemTel = ScanUtill.nextLine("새로운 전화번호 >> ");
		String newMemAddr = ScanUtill.nextLine("새로운 회원주소 >> ");
	}
	
	
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요");
		System.out.println("삭제할 회원ID >> ");
		String memId = ScanUtill.nextLine();
		
		int count = service.getMemberCount(memId); // 회원ID의 존재 여부를 확인하기 위해 getMemberCount 메서드 사용
		
		if(count==0) {
			System.out.println(memId + "는 없는 회원ID입니다.");
			System.out.println("삭제작업을 마칩니다.");
			return;
		}
		
		int cnt = service.deleteMember(memId);
		
		if(cnt>0) {
			System.out.println("delete 작업성공");
		}else {
			System.out.println("delete 작업실패");
		}
	}
	
	private int getMemberCount(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 정보를 입력하세요");
		int count = 0;			// 회원ID의 개수가 저장될 변수
		String memId = null;	// 회원ID가 저장될 변수
		do {
			memId = ScanUtill.nextLine("회원ID >> ");
			count = service.getMemberCount(memId);
			
			if(count>0) {
				System.out.println(memId + "는 이미 등록된 회원ID입니다.");
				System.out.println("다른 회원ID를 입력하세요");
			}
		}while(count>0);
		
		String memPass = ScanUtill.nextLine("비밀번호 >> ");
		String memName = ScanUtill.nextLine("회원이름 >> ");
		String memTel = ScanUtill.nextLine("전화번호 >> ");
		String memAddr = ScanUtill.nextLine("회원주소 >>");
		
		// 입력 받은 자료를 MemberVO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		// Service객체를 이용하여 insert작업을 수행한다.
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("insert 작업 성공");
		}else {
			System.out.println("insert 작업 실패");
		}
	}
	
	
	
}
