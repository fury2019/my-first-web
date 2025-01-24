package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.IJdbcBoardService;
import kr.or.ddit.board.service.JdbcBoardServiceImpl;
import kr.or.ddit.vo.JdbcBoardVO;

public class BoardController {
	private Scanner scan;
	
	private IJdbcBoardService service;

	// 생성자
	public BoardController() {
		scan = new Scanner(System.in);
		service = JdbcBoardServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new BoardController().boardStart();
	}
	
	private void insertBoard() {
		int count = 0;
		//String title = null;
		
		scan.nextLine();  //버퍼비우기
		
		System.out.println("제  목 : <-- 입력");
		String BOARD_TITLE = scan.nextLine();

		System.out.println("작성자 : <-- 입력");
		String BOARD_WRITER = scan.nextLine();

		System.out.println("내  용 : <-- 입력");
		String BOARD_CONTENT = scan.nextLine();
		
		
	

		JdbcBoardVO boardVo = new JdbcBoardVO();
		
		boardVo.setBoard_title(BOARD_TITLE);
		boardVo.setBoard_writer(BOARD_WRITER);
		boardVo.setBoard_content(BOARD_CONTENT);

		// Service객체를 이용하여 insert작업을 수행한다.

		int cnt = service.insertBoard(boardVo);
		if (cnt > 0) {
			System.out.println("insert 작업 성공!!!");
		} else {
			System.out.println("insert 작업 실패~~~");
		}
	}

	private void boardStart() {
		System.out.println("-----------------------------");
		System.out.println("           게 시 판");
		System.out.println("-----------------------------");

		String searchTitle = null;
		
		while (true) {
			int choice = displayMenu(searchTitle);
			
			switch (choice) {
			case 1: 
				insertBoard();
				searchTitle = null;
				break;
			case 2: 
				BoardContent();
				searchTitle = null;
				break;
			case 3: 
				searchTitle = searchBoard();
				break;
			case 0:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("숫자 잘못 입력");
				System.out.println("다시 입력해주세요");
			}

		}
	}
	private String searchBoard() {
		scan.nextLine();	//입력 버퍼 비우기
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("-------------------------");
		System.out.println("- 검색할 제목 입력 >> ");
		
		return scan.nextLine();
	}

	private int displayMenu(String searchTitle) {
		List<JdbcBoardVO> boardList = null;
		
		if(searchTitle == null) {
			boardList = service.getAllBoard();			
		}else {
			boardList = service.getSearchBoard(searchTitle);			
		}
		
		System.out.println("-----------------------------------------------------");
		System.out.println(" No\t제 목\t작성자\t조회수");
		System.out.println("-----------------------------------------------------");
		
		for (JdbcBoardVO board : boardList) {
			System.out.printf(" %d\t%s\t%s\t%d\n", board.getBoard_no(), board.getBoard_title(), board.getBoard_writer(), board.getBoard_cnt());
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업 번호 선택 >> ");
		return scan.nextInt();

	}
	
	private void BoardContent() {
		System.out.println();
		System.out.println("보기를 원하는 게시물 번호 입력 >>");
		int boardNo = scan.nextInt();

		JdbcBoardVO boardVo = service.getBoard(boardNo);
		
		if(boardVo==null) {
			System.out.println(boardNo + "번의 게시글이 존재하지 않습니다");
			return;
		}
		
		System.out.println("------------------------------------------------------------");	
		System.out.println("- 제 목 : " + boardVo.getBoard_title());
		System.out.println("- 작성자 : " + boardVo.getBoard_writer());
		System.out.println("- 내 용 : " + boardVo.getBoard_content());
		System.out.println("- 작성일 : " + boardVo.getBoard_date());
		System.out.println("- 조회수 : " + boardVo.getBoard_cnt());
		System.out.println("------------------------------------------------------------");	
		System.out.println("메뉴 : 1. 수정 2. 삭제 3. 리스트로 가기");
		
		System.out.print("작업선택 >> ");
		int num = scan.nextInt();
		
		switch(num) {
		case 1:		//수정
			updateBoard(boardNo); break;
		case 2:		//삭제
			deleteBoard(boardNo); break;
		case 3:		//리스트로 가기
			return;
		}	
	}
	
	private void deleteBoard(int boardNo) {
		int cnt = service.deleteBoard(boardNo);
		
		if(cnt>0) {
			System.out.println(boardNo+"번글이 삭제되었습니다");
		}else {
			System.out.println(boardNo+"번글 삭제 실패");
		}
	}
	
	private void updateBoard(int boardNo) {
		scan.nextLine();	//입력 버퍼비우기
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("------------------------------------");
		System.out.println("- 제 목 >> ");
		String newTitle = scan.nextLine();
		
		System.out.println("- 내 용 >> ");
		String newContent = scan.nextLine();
		
		// VO에 저장
		JdbcBoardVO boardVo = new JdbcBoardVO();
		boardVo.setBoard_title(newTitle);
		boardVo.setBoard_content(newContent);
		boardVo.setBoard_no(boardNo);
		
		int cnt = service.updateBoard(boardVo);
		
		if(cnt>0) {
			System.out.println(boardNo + "번글이 수정되었습니다");
		}else {
			System.out.println(boardNo + "번글 수정 실패");
		}
	}
}
