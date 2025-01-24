package kr.or.ddit.basic.sec01;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
   4. 이름, 주소, 전화번호를 멤버로 갖는 Phone 클래스를 만든다.
   Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
   (이 Map의 key값은 '이름'을 사용하고, value값은 Phone클래스의 
    인스턴스로 한다.)
   HashMap<String, Phone> 변수;

   아래 메뉴의 기능을 구현하시오.
   1. 전화번호 등록
   2. 전화번호 수정
   3. 전화번호 삭제
   4. 전화번호 검색
   5. 전화번호 전체 출력
   0. 프로그램 종료
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
- 삭제, 검색기능은 '이름'을 입력 받아 처리한다.
*/
public class PhoneBookTest {
   private HashMap<String, Phone> phoneBookMap;
   private Scanner scan;
   
   // 생성자
   public PhoneBookTest() {
      phoneBookMap = new HashMap<String, Phone>();
      scan = new Scanner(System.in);
      
   }
   
   public static void main(String[] args) {
      new PhoneBookTest().phoneBookStart();

   }
   
   // 시작 메소드
   public void phoneBookStart() {
      System.out.println("===========================================");
      System.out.println("        전 화 번 호 관 리 프 로 그 램 ");
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
   // 검색하는 메서드
   private void search() {
	   System.out.println();
	   System.out.println("검색할 전화번호 정보를 입력하세요");
	   String name = ScanUtill.nextLine("이 름 >>");
	   
	   // 검색할 사람이 없으면 검색 작업을 처리하지 못한다.
		if(!phoneBookMap.containsKey(name)) {
    		System.out.println(name + "씨의 전화번호 정보가 없습니다...");
    		return;
    	}
		
		// 입력한 name을 키값으로 Phone 객체를 구한다.
		Phone p = phoneBookMap.get(name);
		System.out.println(name + "씨의 전화번호 정보");
		System.out.println("-----------------------");
		System.out.println("이  름  : " + p.getName());
		System.out.println("전화번호 : " + p.getTel());
		System.out.println("주  소  : " + p.getAddr());
		System.out.println("-----------------------");
	   
}
   
   // 전화번호 정보를 삭제하는 메서드
   private void delete() {
	   System.out.println();
	   System.out.println("삭제할 전화번호 정보를 입력하세요");
	   
	   String name = ScanUtill.nextLine("이 름 >>");
	   
	   // 삭제할 사람이 없으면 삭제 작업을 처리하지 못한다.
		if(!phoneBookMap.containsKey(name)) {
    		System.out.println(name + "씨의 전화번호 정보가 없습니다...");
    		return;
    	}
		
		phoneBookMap.remove(name);
		
		System.out.println(name + "씨 정보를 불러오지 못했습니다...");
   }
   
   // 전화번호 정보를 수정하는 메서드
    private void update() {
    	System.out.println();
    	System.out.println("수정할 전화번호 정보를 입력하세요");
    	
    	System.out.println("이 름 >> ");
    	String name = ScanUtill.nextLine();
    	
    	// 수정할 사람이 없으면 수정 작업을 처리하지 못한다.
    	if(!phoneBookMap.containsKey(name)) {
    		System.out.println(name + "씨의 전화번호 정보가 없습니다...");
    		return;
    	}
    	
    	System.out.print("새로운 전화번호 >> ");
    	String newTel = ScanUtill.nextLine();
    	
    	String newAddr = ScanUtill.nextLine("새로운 주소 >> ");
    	
    	// 같은 key값에 새로운 전화번호 정보를 저장한다.  ==> 수정작업
    	phoneBookMap.put(name, new Phone(name, newTel, newAddr));
    	
    	System.out.println(name + "씨 전화번호 정보를 변경했습니다");
    }
    
    private void insert() {
    	System.out.println();
    	System.out.println("새롭게 추가할 전화번호를 입력하세요");
    	System.out.println();
    	
    	System.out.println("이  름 >>");
    	
    	String name = ScanUtill.nextLine();
    	
    	if(phoneBookMap.containsKey(name)) {
    		System.out.println(name + "씨는 이미 등록된 사람입니다");
    		return;
    	}
    	String tel = ScanUtill.nextLine("전화번호 >> ");
    	
    	String addr = ScanUtill.nextLine("주 소 >> ");
    	
    	phoneBookMap.put(name, new Phone(name,tel, addr));
    	
    	System.out.println(name + "씨 전화번호 등록 완료");
    	
  }
    
    // 전체 자료를 출력하는 메소드
    private void displayAll() {
       System.out.println();
       
       // 전체 key값 정보를 구한다.
       Set<String> phoneKeyset = phoneBookMap.keySet();
       
       System.out.println("-----------------------------------------------------");
       System.out.println("번호\t 이름\t   전화번호\t      주 소");
       System.out.println("-----------------------------------------------------");
       
       if(phoneKeyset.size() == 0) {
          System.out.println("등록된 전화번호 정보가 하나도 없습니다...");
       }else {
          int cnt = 0 ;      // 번호를 출력하기 위한 변수 선언
          // Set에 저장된 key값을 차례로 가져와 처리하기 ==> 향상된 for문 사용
          for(String key : phoneKeyset) {
             cnt++;
             // key값을 이용하여 Map에서 value값을 구한다.
             Phone p = phoneBookMap.get(key);
             
             System.out.println(cnt + "\t" + p.getName() + "\t" 
                         + p.getTel() + " " + p.getAddr());
             
          } // for문 끝.
          
       } // else문 끝.
       System.out.println("-----------------------------------------------------");

    }

   
   // 메뉴를 출력하고 입력 받은 작업 번호를 반환하는 메소드
   private int displayMenu() {
      System.out.println();
      System.out.println("1. 전화번호 등록     ");
      System.out.println("2. 전화번호 수정     ");
      System.out.println("3. 전화번호 삭제     ");
      System.out.println("4. 전화번호 검색     ");
      System.out.println("5. 전화번호 전체 출력 ");
      System.out.println("0. 프로그램 종료     ");
      System.out.println("---------------------------");
      System.out.println("작업 번호 선택 >> ");
      
      return scan.nextInt();
   }

}


// phone 클래스 작성
class Phone {
   private String name;         // 이름
   private String tel;            // 전화번호
   private String addr;         // 주소
   
   // 생성자
   public Phone(String name, String tel, String addr) {
      super();
      this.name = name;
      this.tel = tel;
      this.addr = addr;
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   public String getAddr() {
      return addr;
   }
   public void setAddr(String addr) {
      this.addr = addr;
   }
   
   @Override
   public String toString() {
      return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
   }

}
