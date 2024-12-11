package two;

import javax.swing.*;
import java.awt.*;

//기본 GUI 창을 생성하는 프로그램
public class SuggestionJWT {

	
	
 // GUI를 구성하는 메서드
	// 교재 643 예제 15-14코드 참조 기본 틀 구성하였습니다.
	
 public SuggestionJWT() {
     // JFrame(프로그램 창) 생성
     JFrame frame = new JFrame("청주대 건의함"); // 창 제목 설정
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 설정
     frame.setSize(400, 300); // 창 크기 설정
     frame.setLayout(new BorderLayout()); // 레이아웃 설정

     // 상단에 입력 필드와 버튼 추가
     JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // 2행 2열 레이아웃
     JLabel contentLabel = new JLabel("건의 내용:"); // 라벨
     JTextField contentField = new JTextField(); // 텍스트 입력 필드
     JButton addButton = new JButton("건의 추가"); // 버튼

     // 입력 필드와 버튼을 패널에 추가
     inputPanel.add(contentLabel);
     inputPanel.add(contentField);
     inputPanel.add(new JLabel()); // 빈 공간 추가
     inputPanel.add(addButton);

     // 프레임에 패널 추가
     frame.add(inputPanel, BorderLayout.NORTH); // 입력 패널을 창 상단에 배치

     // 창을 보이도록 설정
     frame.setVisible(true); // 창이 표시됨
 }

 // 메인 메서드
 public static void main(String[] args) {
     SwingUtilities.invokeLater(SuggestionJWT::new); // GUI 생성
 }
}
