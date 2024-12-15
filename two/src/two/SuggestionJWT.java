package two;

import javax.swing.*;
import java.awt.*;

//기본 GUI 창을 생성하는 프로그램
public class SuggestionJWT extends JFrame {
	SuggestionJWT() {
		setTitle("청주대 건의함");
		setLayout(new BorderLayout(10, 10)); //간격이 10만큼씩
		showNorth();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 420);
		setVisible(true); //보여줘라
	}

	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		JPanel panel = new JPanel(new GridLayout(3, 0)); //제일 먼저들어갈 레이블 3줄로 만들기

		JLabel L1 = new JLabel("건의 내용:"); //레이블 생성
		JLabel L2 = new JLabel("건의 장소:");

		JTextField t1 = new JTextField(20); //텍스트 필드 생성 입력활수 있도록 설정
		JTextField t2 = new JTextField(20);
		
		JButton b1 = new JButton("건의 추가"); // 건의를 추가하는 버튼
        JButton b2 = new JButton("파일로 저장"); // 파일 저장 버튼

		p1.add(L1); p1.add(t1);
		p2.add(L2); p2.add(t2);
		p3.add(b1); p3.add(b2);
		
		panel.add(p1); panel.add(p2); panel.add(p3);


		//3개의 레이블과 3개의 텍스트 필드를 패널에 추가 한다

		add(panel, BorderLayout.NORTH); // 북쪽에다 붙여라
	}

 // 메인 메서드
 public static void main(String[] args) {
     new SuggestionJWT(); // GUI 생성
 }
}
