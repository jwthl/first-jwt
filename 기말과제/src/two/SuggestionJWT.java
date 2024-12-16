package two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//기본 GUI 창을 생성하는 프로그램
// 교재 640쪽 예제 15-11참조
public class SuggestionJWT extends JFrame {
	SuggestionJWT() {
		setTitle("청주대 건의함");
		setLayout(new BorderLayout(10, 10)); //간격이 10만큼씩
		showNorth(); 
		showCenter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 420);
		setVisible(true); //보여줘라
	}

	// 교재 641쪽 예제 15-12참조
	void showCenter() {
			JPanel panel = new JPanel();
			
			JTextArea area = new JTextArea(13,40); // 12행 40열 텍스트영역 생성
			area.setText("");
			area.setEditable(false); // 텍스트영역에 입력할 수 없도 설정
			
			panel.add(area);
			
			add(panel, BorderLayout.CENTER);
			
	}


	void showNorth() {
		JPanel p1 = new JPanel(); //"건의내용"
		JPanel p2 = new JPanel(); // "건의장소"
		JPanel p3 = new JPanel(); // "버튼을 위한 페널"

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
		
		
		// 건의 추가 버튼 동작 설정
		//교재 672쪽 예제 16-4 참조
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 입력 필드에서 내용 가져오기
                String content = L1.getText(); //"건의내용" 가져오기
                String location = L2.getText();//"건의장소" 가져오기

                // 입력값이 비어 있는지 확인
                if (content.isEmpty() || location.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "건의 내용과 장소를 모두 입력하세요!", "오류", JOptionPane.ERROR_MESSAGE);
                    return; // 건의를 추가하지 않고 종료
                }
            }
        });
	}
  
        
	

 // 메인 메서드
 public static void main(String[] args) {
     new SuggestionJWT(); // GUI 생성
     

	}
}
