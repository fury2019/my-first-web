package kr.or.ddit.basic.sec01;

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