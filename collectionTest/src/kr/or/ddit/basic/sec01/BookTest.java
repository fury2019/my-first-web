package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 	도서 관리 프로그램
 	
Book 클래스 => 도서번호, 제목, 지은이, 대출가능여부(boolean)로 구성된다.
		(도서번호는 중복되지 않는다.) -> 도서를 등록할 때 중복여부를 검사한다.
		전부 다 스트링
Map을 이용해서 관리한다. (key값 : 도서번호, value값 : Book의 인스턴스)

전체 도서 정보를 출력할 때는 도서번호의 오름차순으로 출력되도록 한다.

아래의 메뉴를 모두 구현하시오.


1. 도서 정보 등록
2. 도서 정보 수정
3. 도서 정보 삭제
4. 도서 정보 검색
5. 전체 도서 정보 출력
0. 프로그램 종료

 */
public class BookTest {
	private Map<String, Book> bookMap;
	private Scanner scan;
	
	
	// 생성자
	public BookTest() {
		 bookMap = new HashMap<String, Book>();
		 scan = new Scanner(System.in);
		 
	 }
	 
	public static void main(String[] args) {
		new BookTest().bookStart();
		
	}
	
	public void bookStart() {
		System.out.println("===========================================");
	      System.out.println("        도 서 관 리 프 로 그 램 ");
	      System.out.println("===========================================");
	      System.out.println();
	      
	      while(true) {
	         int choice = displayMenu();
	         
	         switch(choice) {
		         case 1 :         // 등록
		        	 insert();
		            break;
		         case 2 :         // 수정
		        	 update();
		            break;
		         case 3 :         // 삭제
		        	 delete();
		            break;
		         case 4 :         // 검색
		        	 search();
		            break;
		         case 5 :         // 전체 출력
		        	 displayAll();
	                 break;
		            
		         case 0 :         // 종료
		            System.out.println("프로그램을 종료합니다...");
		            return;
		         default :
		            System.out.println("작업 번호를 잘못 입력했습니다.");
		            System.out.println("다시 선택하세요...");
	         }
	     }      
	}
		private void displayAll() {
			List<String>bookNumList= new ArrayList<String>(bookMap.keySet());
			Collections.sort(bookNumList);	//정렬하기
			
			System.out.println();
			System.out.println("==================================");
			System.out.println("도서번호 \t 도서제목\t 지은이 \t 대출여부");
			System.out.println("==================================");
			if(bookNumList.size()==0) {
				System.out.println("  등록된 도서 정보가 하나도 없습니다");
			}else {
				for(String num:bookNumList) {
					Book b =bookMap.get(num);  //key값을 이용해서 value값 가져오기
					System.out.println(b.getNum() + "\t" + b.getTitle() + "\t" 
							+ b.getWriter() + "\t"
							+ (b.isBookLoan() ? "대출중" : "대출가능"));
				}
			}
			System.out.println("=================================");
		}
	
	
	   private void search() {
		   System.out.println();
		   System.out.println("검색할 도서정보를 입력하세요");
		   String writer = ScanUtill.nextLine("지은이 >>");
		   
		   System.out.println(" 도서번호 >> ");
		   String num = scan.next();
			
		   if(!bookMap.containsKey(num)) {
				System.out.println(num + "도서번호의 도서정보가 없습니다");
				return;
		  }
		   
		    Book book = bookMap.get(num); //검색된 도서정보 가져오기
		   
		
		    System.out.println();
			System.out.println("     검색한 도서정보");
			System.out.println("-----------------------");
			System.out.println("도서 번호  : " + book.getNum());
			System.out.println("도서 제목 : " + book.getTitle());
			System.out.println("지은이   : " + book.getWriter());
			System.out.println("대출상태 : " + (book.isBookLoan() ? "대출중" :" 대출가능"));
			System.out.println("-----------------------");
		   
	}
	   
	   
	private void delete() {
		System.out.println();
		System.out.println("삭제할 도서 정보를 입력하세요");
		   
		System.out.println(" 도서번호 >> ");
		String num = scan.next();
		   
		   // 삭제할 사람이 없으면 삭제 작업을 처리하지 못한다.
		if(!bookMap.containsKey(num)) {
			System.out.println(num + "도서번호의 도서정보가 없습니다");
			return;
		}
		
		if(bookMap.get(num).isBookLoan()) {
    		System.out.println("도서번호가 " + num + "인 도서는 대출중이라 수정할 수 없습니다.");
    		return;
    	}
			
		bookMap.remove(num);
		System.out.println("삭제 작업 완료");
			
	   }	
	
	
    private void update() {
    	System.out.println();
    	System.out.println("수정할 도서정보를 입력하세요");
    	
    	System.out.println("도서번호 >> ");
    	String num = scan.next();
    	
    	// 수정할 사람이 없으면 수정 작업을 처리하지 못한다.
    	if(!bookMap.containsKey(num)) {
    		System.out.println(num + " 도서번호 정보가 없습니다");
    		return;
    	}
    	
    	if(bookMap.get(num).isBookLoan()) {
    		System.out.println("도서번호가 " + num + "인 도서는 대출중이라 수정할 수 없습니다.");
    		return;
    	}
    	
    	scan.nextLine();  // 버퍼 비우기
    	
    	System.out.println("새로운 도서제목 >>");
    	String newTitle = scan.nextLine();
    	
    	System.out.println("새로운 지은이 >> ");
    	String newWriter = scan.next();
    	
    	// 같은 key값으로 새로운 데이터를 추가하면 나중에 추가한 데이터가 저장된다.
    	bookMap.put(num, new Book(num, newTitle, newWriter));
    	
    	System.out.println("수정 작업 완료");
    	}
	 
	 
    private void insert() {
    	System.out.println();
    	System.out.println("새롭게 추가할 도서정보를 입력하세요");
    	System.out.println();
    	
    	System.out.println("도서번호 >>");
    	
    	String num = scan.next();
    	
    	if(bookMap.containsKey(num)) {
    		System.out.println("도서번호가 " + num + "인 도서는 이미 등록된 도서입니다.");
    		return;
    	}
    	
    	scan.nextLine();
    	
    	System.out.println("도서제목 >> ");
    	String title = scan.nextLine();
    	
    	System.out.println("지은이 >> ");
    	String writer = scan.next();
    	
    	bookMap.put(num, new Book(num, title, writer));
    	
    	System.out.println("등록 작업 완료...");
    	
    	
    	
  }
	
	   private int displayMenu() {
		      System.out.println();
		      System.out.println("1. 도서정보 등록     ");
		      System.out.println("2. 도서정보 수정     ");
		      System.out.println("3. 도서정보 삭제     ");
		      System.out.println("4. 도서정보 검색     ");
		      System.out.println("5. 도서정보 전체 출력 ");
		      System.out.println("0. 프로그램 종료     ");
		      System.out.println("---------------------------");
		      System.out.println("작업 번호 선택 >> ");
		      
		      return scan.nextInt();
		   }
}
	
	class Book {
		  private String num;         // 도서번호 
		  private String title;        // 제목
		  private String writer;	  // 지은이
		  private boolean BookLoan;    //false대출가능 true 대출중
		  
		  
		public Book(String num, String title, String writer) {
			super();
			this.num = num;
			this.title = title;
			this.writer = writer;
		}


		public String getNum() {
			return num;
		}


		public void setNum(String num) {
			this.num = num;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getWriter() {
			return writer;
		}


		public void setWriter(String writer) {
			this.writer = writer;
		}


		public boolean isBookLoan() {
			return BookLoan;
		}


		public void setBookLoan(boolean bookLoan) {
			BookLoan = bookLoan;
		}


		@Override
		public String toString() {
			return "Book [num=" + num + ", title=" + title + ", writer=" + writer + ", BookLoan=" + BookLoan + "]";
		}
		  
		 
		 
	
		   
}
