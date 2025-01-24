package kr.or.ddit.basic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;;

// 이벤트 리스너를 외부 클래스로 작성해서 설정하기
class MyListener implements ActionListener{

   @Override
   public void actionPerformed(ActionEvent e) {
       System.out.println("버튼을 클릭했습니다...");
      
      // 이벤트가 발생한 객체 구하기
      JButton btn = (JButton)e.getSource();
      
      btn.setText("버튼이 눌렸습니다.");
   }
}

class MyFrame extends JFrame {
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JLabel label;
   
   private int count = 0;

   
   // 생성자
   public MyFrame() {
      setSize(600, 150);
      setTitle("이벤트 예제");
      setLayout(new FlowLayout());
      
      button1 = new JButton("박영규");
      button2 = new JButton("증 가");
      button3 = new JButton("Action");
      
      label = new JLabel("현재 count = " + count );
      
      // 버튼을 이벤트 리스너와 연결하기 
      button1.addActionListener(new MyListener());
      
      // 익명 구현체로 이벤트 설정
      button2.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            count++;
            label.setText("현재 count = " + count);
         }
      });
      
      // 람다식으로 이벤트 설정
      button3.addActionListener(
         (ActionEvent e) -> {
            if(e.getActionCommand().equals("Action")) {
               button2.setText("처 맞을 횟수");
               count = 0;
               label.setText("현재 count = " + count);
            } else {
               button3.setText("Action");
            }
         }
      );
      
      add(button1);
      add(button2);
      add(label);
      add(button3);

      setVisible(true);

   }
   
}

public class SwingButtonEventTest {

   public static void main(String[] args) {
      new MyFrame();

   }

}
