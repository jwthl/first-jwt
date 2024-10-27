package sec06;

import javax.swing.*;
import java.awt.*;


public class Calculatorjj extends JFrame {
	Calculatorjj() {
		//setTitle("원 넓이 구하기");
		setTitle("계산기");


		setLayout(new BorderLayout(10, 10)); //간격이 10만큼씩
		showNorth(); //기존의 "원의 반지름,원의 넓이를 계산기 표시창으로 만들어본다.
		showCenter();
		showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 300); //교재 도전과제 646쪽 사이즈 참고
		setVisible(true); //보여줘라
	}

	void showNorth() {        //교재 641쪽 참고하여 코드 작성변경
		JPanel p1 = new JPanel();
        JPanel panel = new JPanel(new GridLayout(2, 0));

        JLabel l1 = new JLabel();
        JTextField t1 = new JTextField();

        t1 = new JTextField(10);
        t1.setEnabled(false); 

        p1.add(l1);
        p1.add(t1);
       
        panel.add(p1);

		add(panel, BorderLayout.NORTH); // 북쪽에다 붙여라
	}

	void showCenter() {       //교재 643쪽 참고하여 코드 작성변경
		JPanel panel = new JPanel();
		JButton reset = new JButton("리셋"); //계산창을 삭제 용도의 리셋 버튼 만든다
		panel.add(reset);

		add(panel, BorderLayout.CENTER); // 중앙에 붙여라
	}

	void showSouth() {        //교재 627쪽 참고하여 코드 작성변경
		//String[] color = { "red", "blue" };

		JPanel panel = new JPanel(new GridLayout(4,4,10,10));
		//4줄 4칸 수평수직 1픽셀 만들기
		
		panel.add(new JButton("7")); //교재 627쪽 참고 작성..
		panel.add(new JButton("8"));
		panel.add(new JButton("9"));
		panel.add(new JButton("+"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		panel.add(new JButton("6"));
		panel.add(new JButton("-"));
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("*"));
		panel.add(new JButton("0"));
		panel.add(new JButton("."));
		panel.add(new JButton("="));
		panel.add(new JButton("/"));
		
		add(panel, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new Calculatorjj();

	}

}
