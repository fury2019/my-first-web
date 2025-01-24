package kr.or.ddit.basic.sec01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Phone {
    String name;
    String address;
    String phoneNumber;

    public Phone(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 주소: " + address + ", 전화번호: " + phoneNumber;
    }
}

public class PhoneBookTest02 {
    public static void main(String[] args) {
        Map<String, Phone> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 전화번호 등록");
            System.out.println("2. 전화번호 수정");
            System.out.println("3. 전화번호 삭제");
            System.out.println("4. 전화번호 검색");
            System.out.println("5. 전화번호 전체 출력");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리

            if (menu == 0) {
                break;
            }

            switch (menu) {
                case 1: // 전화번호 등록
                    System.out.print("이름: ");
                    String name = sc.nextLine();
                    System.out.print("주소: ");
                    String address = sc.nextLine();
                    System.out.print("전화번호: ");
                    String phoneNumber = sc.nextLine();
                    phoneBook.put(name, new Phone(name, address, phoneNumber));
                    break;

                case 2: // 전화번호 수정
                    System.out.print("수정할 이름: ");
                    name = sc.nextLine();
                    if (phoneBook.containsKey(name)) {
                        System.out.print("새 주소: ");
                        address = sc.nextLine();
                        System.out.print("새 전화번호: ");
                        phoneNumber = sc.nextLine();
                        phoneBook.put(name, new Phone(name, address, phoneNumber));
                    } else {
                        System.out.println("해당 이름이 없습니다.");
                    }
                    break;

                case 3: // 전화번호 삭제
                    System.out.print("삭제할 이름: ");
                    name = sc.nextLine();
                    phoneBook.remove(name);
                    break;

                case 4: // 전화번호 검색
                    System.out.print("검색할 이름: ");
                    name = sc.nextLine();
                    Phone phone = phoneBook.get(name);
                    if (phone != null) {
                        System.out.println("콜");
                    } else {
                        System.out.println("해당 이름이 없습니다.");
                    }
                    break;

                case 5: // 전화번호 전체 출력
                    for (Phone p : phoneBook.values()) {
                        System.out.println(p);
                    }
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
