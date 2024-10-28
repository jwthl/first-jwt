package sec06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculatorjj extends JFrame {
	
	 private JTextField t1; // 결과와 입력된 값을 표시할 텍스트 필드
	    private double result = 0; // 현재까지의 계산 결과를 저장할 변수
	    private String operator = ""; // 현재 연산자를 저장할 변수
	    private boolean startNewNumber = true; // 새로운 숫자 입력 시작 여부를 나타내는 플래그
    
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
		// area가 아닌 텍스트필드로 수정
		JPanel p1 = new JPanel();
        JPanel panel = new JPanel(new GridLayout(2, 0));

        JLabel l1 = new JLabel();
        t1 = new JTextField("0");
        t1.setText("0"); // 초기값 0으로 설정하여 빈 화면 방지

        t1 = new JTextField(10);
        t1.setEnabled(false); 

        p1.add(l1);
        p1.add(t1);
       
        panel.add(p1);

		add(panel, BorderLayout.NORTH); // 북쪽에다 붙여라
	}

	void showCenter() {       //교재 643쪽 참고하여 코드 작성변경
		JPanel panel = new JPanel(); // 리셋 버튼을 담을 패널 생성
        JButton reset = new JButton("리셋"); // '리셋' 버튼 생성
        
       
        
        
        // 리셋 addActionListene 61,62번줄 챗gpt 검색 적용..
        
        
        reset.addActionListener(e -> resetCalculator()); // 리셋 버튼 클릭 시 resetCalculator() 호출
        panel.add(reset); // 패널에 리셋 버튼 추가
        add(panel, BorderLayout.CENTER); // 패널을 창의 중앙에 추가
	}

	void showSouth() {        //교재 627쪽 참고하여 코드 작성변경
		//String[] color = { "red", "blue" };

		JPanel panel = new JPanel(new GridLayout(4,4,10,10));
		//4줄 4칸 수평수직 1픽셀 만들기
		
		JButton btn7 = new JButton("7");
	    JButton btn8 = new JButton("8");
	    JButton btn9 = new JButton("9");
	    JButton btnPlus = new JButton("+");
	    JButton btn4 = new JButton("4");
	    JButton btn5 = new JButton("5");
	    JButton btn6 = new JButton("6");
	    JButton btnMinus = new JButton("-");
	    JButton btn1 = new JButton("1");
	    JButton btn2 = new JButton("2");
	    JButton btn3 = new JButton("3");
	    JButton btnMultiply = new JButton("*");
	    JButton btn0 = new JButton("0");
	    JButton btnDot = new JButton(".");
	    JButton btnEquals = new JButton("=");
	    JButton btnDivide = new JButton("/");

	    // 숫자 버튼에 대한 리스너 추가
	    btn7.addActionListener(new ButtonClickListener());
	    btn8.addActionListener(new ButtonClickListener());
	    btn9.addActionListener(new ButtonClickListener());
	    btnPlus.addActionListener(new ButtonClickListener());
	    btn4.addActionListener(new ButtonClickListener());
	    btn5.addActionListener(new ButtonClickListener());
	    btn6.addActionListener(new ButtonClickListener());
	    btnMinus.addActionListener(new ButtonClickListener());
	    btn1.addActionListener(new ButtonClickListener());
	    btn2.addActionListener(new ButtonClickListener());
	    btn3.addActionListener(new ButtonClickListener());
	    btnMultiply.addActionListener(new ButtonClickListener());
	    btn0.addActionListener(new ButtonClickListener());
	    btnDot.addActionListener(new ButtonClickListener());
	    btnEquals.addActionListener(new ButtonClickListener());
	    btnDivide.addActionListener(new ButtonClickListener());

	    // 각 버튼을 패널에 추가
	    panel.add(btn7);
	    panel.add(btn8);
	    panel.add(btn9);
	    panel.add(btnPlus);
	    panel.add(btn4);
	    panel.add(btn5);
	    panel.add(btn6);
	    panel.add(btnMinus);
	    panel.add(btn1);
	    panel.add(btn2);
	    panel.add(btn3);
	    panel.add(btnMultiply);
	    panel.add(btn0);
	    panel.add(btnDot);
	    panel.add(btnEquals);
	    panel.add(btnDivide);

		add(panel, BorderLayout.SOUTH);
	}
	
	
	
	
	
	
		
	 // 리셋 버튼 클릭 시 호출되는 메서드, 모든 필드를 초기화
    private void resetCalculator() {
        t1.setText("0"); // 텍스트 필드를 0으로 초기화
        result = 0; // 결과값을 0으로 초기화
        operator = ""; // 연산자를 빈 문자열로 초기화
        startNewNumber = true; // 새 숫자 입력 상태로 전환
    }

    // 버튼 클릭 이벤트를 처리하는 내부 클래스
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // 클릭된 버튼의 텍스트 가져오기

            // 숫자 및 소수점 입력 처리
            if (command.matches("[0-9.]")) {
                if (startNewNumber) { // 새로운 숫자 입력 시작 시
                    t1.setText(command); // 텍스트 필드를 입력된 숫자로 대체
                    startNewNumber = false; // 새로운 숫자 입력 상태 종료
                } else {
                    t1.setText(t1.getText() + command); // 기존 숫자에 이어 붙이기
                }
            }
            // 연산자 입력 처리
            else if (command.matches("[+\\-*/]")) {
                calculate(Double.parseDouble(t1.getText())); // 현재까지의 계산 수행
                operator = command; // 선택된 연산자를 저장
                startNewNumber = true; // 다음 숫자 입력 시 새로 시작하도록 설정
            }
            // '=' 버튼 처리
            else if (command.equals("=")) {
                calculate(Double.parseDouble(t1.getText())); // 최종 계산 수행
                t1.setText(String.valueOf(result)); // 계산 결과를 텍스트 필드에 표시
                operator = ""; // 연산자 초기화
                startNewNumber = true; // 새로운 숫자 입력 상태로 전환
            }
        }

        // 입력된 숫자와 연산자에 따라 계산을 수행하는 메서드
        private void calculate(double inputNumber) {
            switch (operator) {
                case "+": result += inputNumber; break; // 덧셈 수행
                case "-": result -= inputNumber; break; // 뺄셈 수행
                case "*": result *= inputNumber; break; // 곱셈 수행
                case "/": result /= inputNumber; break; // 나눗셈 수행
                default: result = inputNumber; break; // 초기 값 설정
            }
        }
    }

    // 프로그램 실행 진입점
    public static void main(String[] args) {
        new Calculatorjj(); // 계산기 창 실행
    }
}