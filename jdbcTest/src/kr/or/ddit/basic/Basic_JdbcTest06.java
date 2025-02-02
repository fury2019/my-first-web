package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
	회원 관리를 하는 프로그램을 작성하시오. (MYMEMBER 테이블 이용)
	
	아래 메뉴의 기능을 모두 구현하시오. (CRUD기능 구현하기)
	C - Create  ==> insert 문 
	R - Read 	==> select 문
	U - Update	==> update 문
	D - Delete	==> delete 문
	
	예시메뉴)
	-------------------
	1. 자료 추가
	2. 자료 삭제
	3. 자료 수정
	4. 전체 자료 출력
	0. 작업 끝
	-------------------
	
	조건)
	1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
	2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
	3) 자료 수정에서 '회원ID'는 변경되지 않는다.

*/
public class Basic_JdbcTest06 {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		new Basic_JdbcTest06().memberStart();
	}
	
	// 시작 메서드
	public void memberStart() {
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("       회 원 관 리 프 로 그 램");
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 :		// 추가
					insertMember(); break;
				case 2 :		// 삭제
					deleteMember(); break;
				case 3 :		// 수정  ==> 전체 항목 수정
					updateMember(); break;
				case 4 :		// 전체 출력
					displayAllMember(); break;
				case 5 :		// 수정  ==> 선택 항목 수정
					updateMember2(); break;
				case 0 :
					System.out.println("회원 관리 프로그램을 마칩니다.");
					return;
				default :
					System.out.println("작업 번호를 잘못 입력했습니다.");
					System.out.println("다시 입력하세요...");
					
			}
		}
	}
	
	// update ==> 선택 항목 수정
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID >> ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		if(count==0) {   // 없는 회원이면...
			System.out.println(memId + "는(은) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 마칩니다...");
			return;
		}
		
		int num;	
		String updateField = null;		// 컬럼명이 저장될 변수
		String updateTitle = null;		// 새로운 값을 입력 받을 때 출력할 항목명이 저장될 변수
		
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요...");
			System.out.println("1.비밀번호  2.회원이름  3.전화번호  4.회원주소");
			System.out.println("--------------------------------------");
			System.out.print("수정할 항목 선택 >> ");
			num = scan.nextInt();
			
			switch(num) {
				case 1 : updateField = "mem_pass"; updateTitle = "비밀번호";
					break;
				case 2 : updateField = "mem_name"; updateTitle = "회원이름";
					break;
				case 3 : updateField = "mem_tel"; updateTitle = "전화번호";
					break;
				case 4 : updateField = "mem_addr"; updateTitle = "회원주소";
					break;
				default :
					System.out.println("수정 항목을 잘못 선택했습니다. 다시 선택하세요...");
			}
			
		}while(num<1 || num>4);
		
		scan.nextLine();  // 입력 버퍼 비우기
		
		System.out.print("새로운 " + updateTitle + " >> ");
		String newData = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set " + updateField + " = ? "
					+ " where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newData);
			pstmt.setString(2, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(updateTitle + " 항목 수정 완료!!!");
			}else {
				System.out.println(updateTitle + " 항목 수정 실패~~~");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		
	}
	
	
	// insert
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		int count = 0;			// 회원ID의 개수가 저장될 변수
		String memId = null;	// 회원ID가 저장될 변수
		do {
			System.out.println();
			System.out.print("회원ID >> ");
			memId = scan.next();
			count = getMemberCount(memId);
			
			if(count>0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요...");
			}
			
		}while(count>0);
		
		System.out.print("비밀번호 >> ");
		String memPass = scan.next();
		
		System.out.print("회원이름 >> ");
		String memName = scan.next();
		
		System.out.print("전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into mymember "
					+ " (mem_id, mem_pass, mem_name, mem_tel, mem_addr) "
					+ " values( ?, ?, ?, ?, ? ) ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(memId + " 회원 정보 추가 완료!!");
			}else {
				System.out.println(memId + " 회원 정보 추가 실패~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		
	}
	
	// delete
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("삭제할 회원ID >> ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		
		if(count==0) {
			System.out.println(memId + "는(은) 없는 회원ID 입니다.");
			System.out.println("삭제 작업을 마칩니다...");
			return;
		}
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(memId + " 회원 정보 삭제 완료!!!");
			}else {
				System.out.println(memId + " 회원 정보 삭제 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	// update  ==> 전체 항목 수정
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID >> ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		if(count==0) {   // 없는 회원이면...
			System.out.println(memId + "는(은) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 마칩니다...");
			return;
		}
		
		System.out.println();
		System.out.println("수정할 내용을 입력하세요.");
		
		System.out.print("새로운 비밀번호 >> ");
		String newMemPass = scan.next();
		
		System.out.print("새로운 회원이름 >> ");
		String newMemName = scan.next();
		
		System.out.print("새로운 전화번호 >> ");
		String newMemTel = scan.next();
		
		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("새로운 회원주소 >> ");
		String newMemAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set mem_pass = ?, mem_name = ?,"
					+ " mem_tel = ?, mem_addr = ? "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newMemPass);
			pstmt.setString(2, newMemName);
			pstmt.setString(3, newMemTel);
			pstmt.setString(4, newMemAddr);
			pstmt.setString(5, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(memId + " 회원 정보 수정 완료!!!");
			}else {
				System.out.println(memId + " 회원 정보 수정 실패~~~");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	// 전체 출력
	private void displayAllMember() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println(" ID    비밀번호    이름    전화번호    주소");
		System.out.println("-------------------------------------------------");
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			int cnt = 0;
			while(rs.next()) {
				cnt++;
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "\t" + memPass + "\t" + memName
							+ "\t" + memTel + "\t" + memAddr);
			}
			if(cnt==0) {
				System.out.println("\t등록된 회원이 한 명도 없습니다.");
			}
			System.out.println("-------------------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	// 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
	private int getMemberCount(String memId) {
		int count = 0;   	// 반환값이 저장될 변수
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) cnt from mymember "
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return count;
	}
	
	
	
	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("-------------------");
		System.out.println("  1. 자료 추가");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 전체 항목 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료 선택 항목 수정");
		System.out.println("  0. 작업 끝");
		System.out.println("-------------------");
		System.out.print("작업 번호 선택 >> ");
		return scan.nextInt();
	}
	
	// 사용했던 자원을 반환하는 메서드
	private void disConnect() {
		if(rs!=null) try { rs.close(); }catch(SQLException e) {}
		if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
		if(conn!=null) try { conn.close(); }catch(SQLException e) {}
	}

}
