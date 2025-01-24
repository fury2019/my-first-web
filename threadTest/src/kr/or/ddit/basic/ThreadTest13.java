package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
    10마리의 말들이 경주하는 경마 프로그램을 작성하시오
    
    말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 
    이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
    그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
    (Comparable 인터페이스 구현)
    
-   경기 구간은 1 ~ 50 구간으로 되어 있다.
    
-   경기 중 중간 중간에 각 말들의 위치를 아래와 같이 출력한다.
    예)
    01번말 --->--------------------------------
    02번말 ------->----------------------------
    ...
    10번말 ------>-----------------------------
    
-   경주가 모두 끝나면 등수 순으로 출력한다.

*/
class Runner implements Runnable, Comparable<Runner> {
    private String name; // 말 이름
    private int placement; // 등수
    private int position; // 현재 위치
    private static AtomicInteger finishCount = new AtomicInteger(0); // 완료한 말 수

    public Runner(String name) {
        this.name = name;
        this.placement = 0;
        this.position = 0;
    }

    @Override
    public void run() {
        while (position < 50) {
        	
            position += (int) (Math.random() * 3); // 1~3칸 이동
            if (position > 50) {
                position = 50; // 최대 위치 50
            }
            printPosition();
            
            try {
                Thread.sleep(100); // 0.5초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        // 경주 완료 후 순위 설정
        placement = finishCount.incrementAndGet();
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        sb.append("-->"); // 현재 위치를 나타내는 화살표 추가
        
        for (int i = position; i < 50; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }

    @Override
    public int compareTo(Runner other) {
        return Integer.compare(this.placement, other.placement); // 등수에 따라 오름차순 정렬
    }

    public int getPlacement() {
        return placement;
    }

    public String getName() {
        return name;
    }
}

public class ThreadTest13 {
    public static void main(String[] args) {
        List<Runner> runners = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            runners.add(new Runner(String.format("%02d번말", i)));
        }

        // 각 말에 대해 쓰레드 생성
        List<Thread> threads = new ArrayList<>();
        for (Runner runner : runners) {
            Thread thread = new Thread(runner);
            threads.add(thread);
            thread.start();
        }

        // 모든 말이 경주를 마칠 때까지 대기
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 경주 결과 출력
        Collections.sort(runners); // 등수에 따라 정렬
        System.out.println("경주 결과:");
        for (Runner runner : runners) {
            System.out.println(runner.getName() + " : " + runner.getPlacement() + "등");
        }
    }
}
