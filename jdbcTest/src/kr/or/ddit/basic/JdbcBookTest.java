package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

/*
 create table TB_BOOK(
 	BOOK_ID VARCHAR2(10) NOT NULL,      --도서번호
    BOOK_TITLE VARCHAR2(100) NOT NULL,  --제목
    BOOK_AUTHOR VARCHAR2(30) NOT NULL,  --지은이
    BOOK_LOAN VARCHAR2(1) NOT NULL,     -- 대출여부(N:대출중, Y:대출가능)
    BOOK_DATE DATE,                     -- 등록 날짜
    CONSTRAINT PK_TB_BOOK PRIMARY KEY (BOOK_ID)
    
 	DB의 'TB_BOOK'테이블을 이용하여 아래의 메뉴를 구현하시오.
 	
 	1. 도서 정보 등록
 	2. 도서 정보 수정
 	3. 도서 정보 삭제
 	4. 도서 정보 검색
 	5. 전체 도서 정보 출력
 	0. 프로그램 종료
 	
 	조건1) 도서번호를 등록할 때 '도서 번호'는 중복되지 않는다.
 		  중복되는 '도서번호'를 입력하면 다시 입력 받는다.
 		  (등록할 때는 Y로)
 		  
 	조건2) 수정, 삭제 작업에는 '도서번호'를 이용하여 처리한다.
 	
 	조건3) 전체 출력은 도서번호의 오름차순으로 출력한다.
 	
 	조건4) 검색은 도서명의 일부분만 입력해도 검색되도록 한다.
 	
 */
public class JdbcBookTest {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new JdbcBookTest().bookStart();
	}
	
	// 시작 메서드
	public void bookStart() {
		while(true) {
			int choice = displayMenu();
			switch(choice) {
				case 1 :		// 등록
					 bookInsert(); break;
				case 2 :		// 수정
					 bookUpdate(); break;
				case 3 :		// 삭제  
					 bookDelete(); break;
				case 4 :		// 검색
					 bookSearch(); break;
				case 5 :		// 전체출력
					 bookDisplayAll(); break;
				case 0 :
					System.out.println("회원 관리 프로그램을 마칩니다.");
					return;
				default :
					System.out.println("작업 번호를 잘못 입력했습니다.");
					System.out.println("다시 입력하세요...");
					
			}
		}
	}
	private void bookSearch() {
		
		scan.nextLine();	// 입력 버퍼 비우기
		
		System.out.println();
		System.out.println("검색할 도서 정보를 입력하세요");
		System.out.print("도서 제목 입력 >> ");
		String bookTitle = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from tb_book "
					+ "where book_title like '%' || ? ||'%'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookTitle);
			
			rs = pstmt.executeQuery();
			
			System.out.println("   === 검색 결과 ===");
			int cnt = 0;
			while(rs.next()) {
				cnt++;
				System.out.println("도서 번호 : " + rs.getString("book_id"));
				System.out.println("제   목 : " + rs.getString("book_title"));
				System.out.println("지 은 이 : " + rs.getString("book_author"));
				System.out.println("대출가능여부 : " + rs.getString("book_loan"));
				System.out.println("등록 날짜 : " + rs.getString("book_date"));
				System.out.println("------------------------------------------");
			}
			
			if(cnt==0) {
				System.out.println(" 검색된 도서 정보가 하나도 없습니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
			
	}
	
	private void bookDelete() {
		System.out.println();
		System.out.println("삭제할 도서정보를 입력하세요.");
		System.out.print("삭제할 도서번호 입력 >> ");
		String bookId = scan.next();
		
		int count = getBookIdCount(bookId);
		
		if(count==0) {
			System.out.println("도서번호가" + bookId + "인 도서정보는 없습니다");
			System.out.println("삭제 작업을 마칩니다...");
			return;
		}
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "delete from tb_book where book_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(bookId + " 도서 정보 삭제 완료!!!");
			}else {
				System.out.println(bookId + " 도서 정보 삭제 실패~~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}
	
	// 도서 정보를 수정하는 메서드
	private void bookUpdate() {
		System.out.println();
		System.out.println("수정할 도서정보를 입력하세요");
		System.out.println("도서번호 입력 >>");
		String bookId =scan.next();
		
		int count = getBookIdCount(bookId);
		
		if(count==0) {
			System.out.println("도서번호가 " + bookId + "인 도서정보는 없습니다");
			System.out.println("수정 작업을 마칩니다");
			return;
		}
		
		scan.nextLine();	//입력 버퍼 비우기
		
		System.out.print("새로운 도서 제목 >> ");
		String newTitle = scan.nextLine();
		
		System.out.print("새로운 지은이 >> ");
		String newAuthor = scan.nextLine();
		
		System.out.print("새로운 대출가능 여부(Y/N) >> ");
		String newLoan = scan.next();
		newLoan = newLoan.toUpperCase();	// 대문자로 변환
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update tb_book 	set book_title=?, book_author = ?, "
					+ " book_loan = ?, book_date = sysdate "
					+ "where book_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newTitle);
			pstmt.setString(2, newAuthor);
			pstmt.setString(3, newLoan);
			pstmt.setString(4, bookId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("수정 작업 성공");
			}else {
				System.out.println("수정 작업 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		
	}
	// 전체 도서 정보를 출력하는 메서드
	private void bookDisplayAll() {
		System.out.println();
		System.out.println("============================================");
		System.out.println("  도서번호  도서제목  지은이  대출가능여부  등록날짜  ");
		System.out.println("============================================");
		
		try {
//			conn =DBUtil.getConnection();
//			conn =DBUtil2.getConnection();
			conn =DBUtil3.getConnection();
			
			String sql = "select * from tb_Book";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			int count = 0;
			
			while(rs.next()) {
				count++;
				
				String bookId = rs.getString("book_Id");
				String bookTitle = rs.getString("book_Title");
				String bookAuthor = rs.getString("book_Author");
				String bookLoan = rs.getString("book_Loan");
				String bookDate = rs.getString("book_Date");
				
				System.out.println(bookId + "   " + bookTitle + "   "
						+ "   " + bookAuthor + "   " + bookLoan
						+ "   " + bookDate);
			}
			
			if(count==0) {
				System.out.println("   등록된 도서 정보가 하나도 없습니다");
			}
			
			System.out.println("============================================");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}
	
	// 도서 정보를 추가하는 메서드
	private void bookInsert() {
		System.out.println();
		System.out.println("추가할 도서정보를 입력하세요");
		
		int count = 0;
		String bookId = null;		// 도서번호가 저장될 변수
		
		do {
			System.out.println("도서번호 입력 >> ");
			bookId = scan.next();
			
			count = getBookIdCount(bookId);
			
			if(count>0) {
				System.out.println("도서번호" + bookId + "는 이미 등록된 번호입니다");
				System.out.println("다른 도서번호를 입력하세요");
				System.out.println();
			}
		}while(count>0);
		
		scan.nextLine();	// 입력 버퍼 비우기
		
		System.out.println("도서제목 입력 >>");
		String title = scan.nextLine();
		
		System.out.println("지은이 입력 >>");
		String author = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "insert into TB_BOOK "
					+ " (book_id, book_title, book_author, book_loan, book_date) "
					+ " values(?,?,?, 'Y', sysdate) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("도서 정보 등록 완료");
			}else {
				System.out.println("도서 정보 등록 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}
	
	// 매개변수로 도서번호를 받아서 해당 도서번호의 개수를 반환하는 메서드
	private int getBookIdCount(String bookId) {
	    int count = 0;  // 반환값이 저장될 변수

	    try {
	        conn = DBUtil.getConnection();

	        String sql = "select count(*) cnt from tb_book where book_id = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bookId);

	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            count = rs.getInt("cnt");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disConnect();
	    }

	    return count;
	}
		
	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("    1. 도서 정보 등록   ");
		System.out.println("    2. 도서 정보 수정   ");
		System.out.println("    3. 도서 정보 삭제   ");
		System.out.println("    4. 도서 정보 검색   ");
		System.out.println("    5. 전체 도서 정보 출력");
		System.out.println("    0. 프로그램 종료    ");
		System.out.println("--------------------------");
		System.out.println("원하는 작업 선택 >>");
		return scan.nextInt();
	}
	
	// 자원 반납 메서드
	private void disConnect() {
		if(rs!=null) try { rs.close(); }catch(SQLException e) {}
		if(pstmt!=null) try { pstmt.close(); }catch(SQLException e) {}
		if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		
	}
}
