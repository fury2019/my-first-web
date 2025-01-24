package kr.or.ddit.basic.sec01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelTest {
	private Map<Integer, Room>hotelMap;
	private Scanner scan;
	
	// 생성자
	public HotelTest() {
		hotelMap = new HashMap<Integer, Room>();
		scan = new Scanner(System.in);
		
		// 객실 초기화
//		hotelMap.put(201, new Room(201, "싱글룸"));
		for(int i=2; i<=4; i++) {
			String type = null;
			switch(i) {
			case 2 : type = "싱글룸"; break;
			case 3 : type = "더블룸"; break;
			case 4 : type = "스위트룸"; break;
			}
			
			for(int j=1; j<=9; j++) {
				int num = i * 100 + j;
				hotelMap.put(num, new Room(num, type));
			}
		}
	} // 생성자 끝
	public static void main(String[] args) {
		new HotelTest().hotelStart();
	}
	
	public void hotelStart() {
		System.out.println("****************************************");
		System.out.println("호텔 문을 열었습니다. 어서오십시오");
		System.out.println("****************************************");
		System.out.println("\n\n");
		
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
				case 1 :	//체크인
					checkIn(); break;
				case 2 :	//체크아웃
					checkOut(); break;
				case 3 :	//객실상태
					displayRoomState(); break;
				case 4 :	//종료
					System.out.println("****************************************");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("****************************************");
					return;
				default :
					System.out.println("작업번호 잘못 입력 다시선택 ㄱ");
			}
		}
	}
	// 객실 상태 출력 메서드
	private void displayRoomState() {
		System.out.println();
		
		// 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 key값들)만
		// List에 넣어서 정렬하여 사용한다.
		List<Integer>numList = new ArrayList<Integer>(hotelMap.keySet());
		Collections.sort(numList); // 방번호를 오름차순으로 정렬하기
		
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태                                    ");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름                            ");
		System.out.println("----------------------------------------------");
		System.out.println();
		
		// List에서 방번호를 하나씩 차례로 꺼내와서 Map에서 해당 방번호와
		// 같이 저장된 Room객체를 구해서 출력한다.
		for(int num : numList) {
			Room r = hotelMap.get(num);
			System.out.println(r.getRoomNum() + "\t" + r.getRoomType()
					+ "\t" + (r.getGuestName() == null ? "-" : r.getGuestName() ));
		}
		System.out.println("-----------------------------------");
		
	}
	// 체크아웃 메서드
	private void checkOut() {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업                                    ");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.                           ");
		System.out.println("방번호 입력 >>                                     ");
		int num = scan.nextInt();
		
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다");
			return;
		}
		
		//해당 객실에 투숙객이 없으면
		if(hotelMap.get(num).getGuestName()==null) {
			System.out.println(num + "호 객실에는 체크인한 사람이 없습니다");
			return;
	}
		
		// 체크아웃 작업은 해당객실의 투숙객 이름을 null롤 변경하면 된다.
		String name = hotelMap.get(num).getGuestName();
		hotelMap.get(num).setGuestName(null);
		
		System.out.println(num + "호 객실의 " + name + "님이 체크아웃을 완료했습니다.");
	}
	
	// 체크인 메서드
	private void checkIn() {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업                                     ");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸                              ");
		System.out.println(" * 301~309 : 더블룸                              ");
		System.out.println(" * 401~409 : 스위트룸                             ");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >>  ");
		
		int num = scan.nextInt();
		
		//입력한 방번호가 Map의 key값에 없으면 잘못입력한 방번호다.
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 해당 객실에 다른 투숙객이 있는지 검사
		//  ==> 해당 객실의 Room객체를 구하고 이 Roon객체의 guestName속성이
		//		null이면 비어있는 방이 된다.
		if(hotelMap.get(num).getGuestName()!=null) {
			System.out.println(num + "호 객실에는 이미 다른 손님이 있습니다");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까??");
		System.out.println("이름 입력 >> ");
		String name = scan.next();
		
		// 입력 받은 이름을 해당 객실의 투숙객 명단에 저장한다.
		hotelMap.get(num).setGuestName(name);
		
		
		System.out.println(name + "씨가 " + "호 객실에 체크인 되었습니다");
	}                                                         
	
	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까");
		System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
		System.out.println("-------------------------------------------");
		System.out.println();
		System.out.println("선택 >>");
		
		return scan.nextInt();
	}
}

//Room클래스는 방번호(int), 방종류, 투숙객이름 필드로 구성되어있다.
class Room{
	private int roomNum;
	private String roomType;
	private String guestName;
	
	public Room(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;

	}
	



	public int getRoomNum() {
		return roomNum;
	}


	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getGuestName() {
		return guestName;
	}


	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}


	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomType=" + roomType + ", guestName=" + guestName + "]";
	}
	
	
}
