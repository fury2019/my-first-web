package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/*
10마리의 말들이 경주하는 경마 프로그램을 작성하시오

말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 
이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
(Comparable 인터페이스 구현)

-	경기 구간은 1 ~ 50 구간으로 되어 있다.

-	경기 중 중간 중간에 각 말들의 위치를 아래와 같이 출력한다.
	예)
	01번말 --->--------------------------------
	02번말 ------->----------------------------
...
	10번말 ------>-----------------------------

-	경주가 모두 끝나면 등수 순으로 출력한다.

*/

public class ThreadTest13techer {

	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] {
				new Horse("01번말"), new Horse("02번말"), new Horse("03번말"),
				new Horse("04번말"), new Horse("05번말"), new Horse("06번말"),
				new Horse("07번말"), new Horse("08번말"), new Horse("09번말"),
				new Horse("10번말")
		};
		
		GameState gs = new GameState(horseArr);
		
		
		for(Horse h : horseArr) {
			h.start();
		}
		
		gs.start();
		
		for(Horse h : horseArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		
		System.out.println("경기 끝");
		System.out.println();
		
		System.out.println("경기 결과");
		// 등수의 오름차순으로 정렬하기
		// 배열의 정렬은 Arrays.sort()메서드를 사용한다.
		Arrays.sort(horseArr);
		
		for(Horse h : horseArr) {
			System.out.println(h);
		}

	}

}
class Horse extends Thread implements Comparable<Horse>{
	
	public static int currentRank = 0;
	
	private String horseName;	//말이름
	private int location;		//현재위치
	int rank;			//등수
	
	// 생성자
	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}


	public String getHorseName() {
		return horseName;
	}


	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}


	public int getLoaction() {
		return location;
	}


	public void setLoaction(int loaction) {
		this.location = loaction;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	@Override
	public String toString() {
		return "경주마" + horseName + "는 " + rank + "등 입니다.";
	}
	
	// 등수를 기준으로 오름차순 정렬 기준 설정하기
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.rank);
	}
	
	// 쓰레드 처리
	@Override
	public void run() {
		// - 경기 구간은 1 ~ 50 구간으로 되어 있다.
		for(int i=1; i<=50; i++) {
			location = i;
			try {
				Thread.sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		// 한 마리의 말의 경주가 끝나면 현재의 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
	}
	
}
/*
	-	경기 중 중간 중간에 각 말들의 위치를 아래와 같이 출력한다.
	예)
	01번말 --->--------------------------------
	02번말 ------->----------------------------
	...
	10번말 ------>-----------------------------
*/
class GameState extends Thread{
	// 경주에 참가하는 말들을 저장할 배열 변수 선언
	private Horse[] horseArr;
	
	// 생성자
	public GameState(Horse[] horseArr) {
		super();
		this.horseArr = horseArr;
	}
	@Override
	public void run() {
		while(true) {
			// 모든 말들의 경기가 종료되었는지 여부 검사
			if(Horse.currentRank==horseArr.length) {
				break;
			}
			for(int i=1; i<=15; i++) {
				System.out.println();
			}
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName() + " : ");
				
				for(int j=1; j<=50; j++) {
					// 말의 현재 위치 표시하기
					if(horseArr[i].getLoaction()==j) {
						System.out.print(">");
					}
					System.out.print("-");
				}
				
				System.out.println();	// 줄바꿈
				
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
}
