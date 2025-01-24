package kr.or.ddit.book.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.book.service.BookServiceImpl;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.BookVO;

public class BookController {
   private IBookService service;   // Service 객체 변수 선언
   
   private Scanner scan;
   
   public BookController() {
      service = new BookServiceImpl();  // Service 객체 생성
      scan = new Scanner(System.in);
   }

   public static void main(String[] args) {
      new BookController().bookStart();
      
   }

   // 시작 메서드
      public void bookStart() {
         System.out.println("+++++++++++++++++++++++++++++++++");
         System.out.println("       도 서 관 리 프 로 그 램");
         System.out.println("+++++++++++++++++++++++++++++++++");
         System.out.println();

         while (true) {
            int choice = displayMenu();
            switch (choice) {
            case 1:
               bookInsert();
               break;
            case 2:
               bookUpdate();
               break;
            case 3:
               bookDelete();
               break;
            case 4:
               bookSearch();
               break;
            case 5:
               bookDisplayAll();
               break;
            case 0:
               System.out.println();
               System.out.println("도서 관리 프로그램을 마칩니다.");
               return;
            default:
               System.out.println("작업 번호를 잘못 입력했습니다.");
               System.out.println("다시 입력하세요...");
            }
         }

      }
      
   // 전체 출력 메서드
   private void bookDisplayAll() {
      // 전체 자료 가져오기
      List<BookVO> bookList = service.bookDisplayAll();
      
      System.out.println();
      System.out.println("------------------------------------------------------");
      System.out.println("도서 번호    도서 제목        지은이    대출여부    등록 날짜 ");
      System.out.println("------------------------------------------------------");

      if(bookList==null || bookList.size()==0) {
         System.out.println("\t\t 도서 정보가 하나도 없습니다.");
      }else {
         
         for(BookVO bookVo : bookList) {
            String bookId = bookVo.getBook_id();
            String bookTitle = bookVo.getBook_title();
            String bookAuthor = bookVo.getBook_author();
            String bookLoan = bookVo.getBook_loan();
            String bookDate = bookVo.getBook_date();
            System.out.println(
                  bookId + "\t   " + bookTitle + "\t " + bookAuthor + "\t   " + bookLoan + "\t" + bookDate);
            
         }
      }
      System.out.println("------------------------------------------------------");
   }
      
   // 검색 메서드
   private void bookSearch() {
      
      scan.nextLine();
      
      System.out.println();
      System.out.println("검색할 도서 제목을 입력하세요.(일부만 입력 가능)");
      System.out.print("도서 제목 입력 >> ");
      String bookTitle = scan.nextLine();
      
      //검색 결과를 받아온다.
      List<BookVO> bookList = service.bookSearch(bookTitle);
      
      System.out.println("             === 검 색 결 과 ===");
      System.out.println("----------------------------------------------");
      if(bookList==null || bookList.size()==0) {
         System.out.println("\t\t 검색된 자료가 하나도 없습니다.");
         System.out.println("----------------------------------------------");
      }else {     // 검색된 데이터가 있을 때...
         for(BookVO bookVo : bookList) {
            System.out.println("도서 번호   : " + bookVo.getBook_id());
            System.out.println("도서 제목   : " + bookVo.getBook_title());
            System.out.println("지 은 이   : " + bookVo.getBook_author());
            System.out.println("대출가능여부 : " + bookVo.getBook_loan());
            System.out.println("도서등록날짜 : " + bookVo.getBook_date());
            System.out.println("----------------------------------------------");
         }
         
      }
   }
   
   // 삭제 메서드
   private void bookDelete() {
      System.out.println();
      System.out.println("삭제할 도서 번호를 입력하세요.");
      System.out.print("도서 번호 >> ");
      String bookId = scan.next();
      
      int count = service.getBookIdCount(bookId);

      if (count == 0) {
         System.out.println(bookId + "는(은) 없는 도서 번호 입니다.");
         System.out.println("삭제 작업을 마칩니다.");
         return;
      }
      
      int cnt = service.bookDelete(bookId);
      
      if(cnt > 0) {
         System.out.println(bookId + " 도서 정보 삭제 완료!!!");
      }else {
         System.out.println(bookId + " 도서 정보 삭제 실패...");
      }
         
   }
      
      
   // 수정 메서드
   private void bookUpdate() {
      System.out.println();
      System.out.println("수정할 도서 번호를 입력하세요.");
      System.out.println();
      System.out.print("수정할 도서번호 >> ");
      String bookId = scan.next();
      
      int count = service.getBookIdCount(bookId);
         
         if (count == 0) { // 없는 도서번호 이면....
            System.out.println(bookId + "는(은) 없는 도서번호 입니다.");
            System.out.println("수정 작업을 마칩니다.");
            return;
         }
         
         scan.nextLine();
      
         System.out.print("새로운 도서 제목 >> ");
         String newTitle = scan.nextLine();
         
         System.out.print("새로운 지은이 >> ");
         String newAuthor = scan.nextLine();
         
         System.out.print("새로운 대출가능 여부(Y/N) >> ");
         String newLoan = scan.next();
         newLoan = newLoan.toUpperCase();  
         
         // 입력받은 데이터를 VO객체에 저장한다.
         BookVO bookVo = new BookVO();
         bookVo.setBook_id(bookId);
         bookVo.setBook_title(newTitle);
         bookVo.setBook_author(newAuthor);
         bookVo.setBook_loan(newLoan);
         
         int cnt = service.bookUpdate(bookVo);
         
         if (cnt > 0) {
            System.out.println(" 도서 수정 완료!!!");
         } else {
            System.out.println(" 도서 수정 실패~~~");
         }
      }
      
   // 등록 메서드
   private void bookInsert() {
      System.out.println();
      System.out.println("추가할 도서 정보를 입력하세요.");
      int count = 0;
      String bookId = null;
      do {
         System.out.println();
         System.out.print("도서 번호 >> ");
         bookId = scan.next();
         count = service.getBookIdCount(bookId);

         if (count > 0) {
            System.out.println(bookId + "는(은) 이미 등록된 도서번호 입니다.");
            System.out.println("다른 도서번호를 입력하세요!");
         }

      } while (count > 0);
      
      scan.nextLine();  // 입력버퍼 비우기
      
      System.out.print("도서제목 입력 >> ");
      String bookTitle = scan.nextLine();
      System.out.print("지은이 >> ");
      String bookAuthor = scan.nextLine();
      
      // 입력받은 자료들을 VO 객체에 저장한다.
      BookVO bookVo = new BookVO();
      bookVo.setBook_id(bookId);
      bookVo.setBook_title(bookTitle);
      bookVo.setBook_author(bookAuthor);
      
      // Service 객체의 insert를 처리하는 메서드를 호출한다.
      // 이 때 입력한 자료가 저장된 VO객체를 매개변수로 전달한다.
      int cnt = service.bookInsert(bookVo);
      
      if(cnt>0) {
         System.out.println("도서 정보 등록 성공!!!");
      }else {
         System.out.println("도서 정보 등록 실패...");
      }
   }
   
   private int displayMenu() {
      System.out.println();
      System.out.println("-------------------------");
      System.out.println("  1. 도서 정보 등록");
      System.out.println("  2. 도서 정보 수정");
      System.out.println("  3. 도서 정보 삭제");
      System.out.println("  4. 도서 정보 검색");
      System.out.println("  5. 전체 도서 정보 출력");
      System.out.println("  0. 프로그램 종료");
      System.out.println("-------------------------");
      System.out.print("작업 번호 선택 >> ");
      return scan.nextInt();
   }
}
