package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Comparator;

/*
	학번(int), 이름, 국어점수,영어점수,수학점수,총점,
  	등수를 멤버로 갖는 Student클래스를 만든다.
  	이 Student클래스의 생성자에서는 학번,이름,국어,영어,
  	수학점수만 매개변수로 받아서 초기화 처리를 한다.
  	(이 때 총점은 세 과목의 점수를 이용해서 초기화 한다.)

  	이 Student객체는 List에 저장하여 관리한다.
  	(등수는 List에 데이터가 모두 추가된 후에 구한다.)
  	
  	List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을
  	구현하고, 
  	
  	총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로
  	정렬되는 외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
 */
public class StudentTest {
	private List<Student> stdList = new ArrayList<Student>();
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new StudentTest().stdStart();
	}
	
	// 등수 구하는 메서드
	private void createRank() {
		for(Student std1 : stdList) { // 기준 자료 (등수 구할 자료)
			int rank = 1;		// 등수는 처음에는 1로 초기화 한다.
			for(Student std2 : stdList) {  // 비교할 자료
				if( std1.getTot() < std2.getTot()) {
					rank++;
				}
			}
			
			std1.setRank(rank);  // 구해진 등수를 Student객체에 저장
		}
	}
	
	
	
	// 시작 메서드
	public void stdStart() {
		/*
		System.out.println("학생 성적 정보를 입력하세요...");
		while(true) {
			System.out.print("학번 >> ");
			int num = scan.nextInt();
			
			System.out.println("이름 >> ");
			String name = scan.next();
			
			System.out.println("국어 점수 >> ");
			int kor = scan.nextInt();
			
			System.out.println("영어 점수 >> ");
			int eng = scan.nextInt();
			
			System.out.println("수학 점수 >> ");
			int mat = scan.nextInt();
			
			
			stdList.add(new Student(num, name, kor, eng, mat));
			
			System.out.print("입력을 계속하시겠습니까?(y/n) >> ");
			String again = scan.next();
			
			if(!again.equalsIgnoreCase("y")) {
				break;      // 반복문 탈출
			}
		}  //while문 끝
		*/

		stdList.add(new Student(1, "홍길동", 90, 95, 80));
		stdList.add(new Student(3, "성춘향", 90, 75, 70));
		stdList.add(new Student(7, "강감찬", 90, 95, 80));
		stdList.add(new Student(5, "변학도", 80, 95, 90));
		stdList.add(new Student(2, "일지매", 100, 85, 80));
		stdList.add(new Student(4, "이순신", 70, 75, 70));
		stdList.add(new Student(6, "이몽룡", 90, 100, 90));
		
		
		createRank();   // 등수 구하는 메서드 호출
		
		
		System.out.println(" == 학생 성적 결과 == ");
		System.out.println("정렬전");
		for(Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("----------------");
		
		// 학번의 오름차순으로 정렬 (내부정렬기준)
        Collections.sort(stdList);
        
        System.out.println("학번 오름차순 정렬후");
        for (Student std : stdList) {
            System.out.println(std);
        }
        System.out.println("----------------");
        System.out.println();
        
        // 총점의 내림차순으로 정렬 (총점이 같을경우 이름 내림차순으로 정렬)
        Collections.sort(stdList, new SortByTotal());
        
        System.out.println("총점의 역순으로 정렬후");
        for (Student std : stdList) {
            System.out.println(std);
        }
        System.out.println("----------------");
        System.out.println();
	}
}

// Student클래스 작성
class Student implements Comparable<Student>{
	private int stdNum;
	private String stdName;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int rank;
	
	public Student(int stdNum, String stdName, int kor, int eng, int mat) {
		super();
		this.stdNum = stdNum;
		this.stdName = stdName;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor + eng + mat;
	}
	public int getStdNum() {
		return stdNum;
	}
	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", stdName=" + stdName + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat
				+ ", tot=" + tot + ", rank=" + rank + "]";
	}	
	
	// 학버느이 오름차순으로 정렬되는 기준만들기
	@Override
	public int compareTo(Student std) {
		return Integer.compare(this.stdNum, std.getStdNum());
	}
	    
}


// 총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로
// 정렬되는 외부 정렬 기준 클래스
class SortByTotal implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTot() == std2.getTot()) { // 총점이 같을때
			return std1.getStdName().compareTo(std2.getStdName());
		}else {
			return Integer.compare(std1.getTot(), std2.getTot()) * -1;		
		}
	}
	
}




