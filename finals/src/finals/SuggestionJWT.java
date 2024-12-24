package finals;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;




//기본 GUI 창을 생성하는 프로그램
// 교재 640쪽 예제 15-11참조
public class SuggestionJWT extends JFrame {
	private JTextArea textArea; // 건의 내용을 출력하기 위한 텍스트 영역
    private ArrayList<SuggestionJWT> suggestions; // 입력된 건의를 저장하는 리스트
    private String content;
    private String location;

	SuggestionJWT() {
        suggestions = new ArrayList<>(); // 리스트 초기화
		setTitle("청주대 건의함");
		setLayout(new BorderLayout(10, 10)); //간격이 10만큼씩
		showNorth(); 
		showCenter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 420);
		setVisible(true); //보여줘라
	}
	
	public SuggestionJWT(String content, String location) {
        this.content = content;
        this.location = location;
    }
	

    // 건의 내용을 출력하기 위해 문자열 형식으로 반환
    @Override
    public String toString() {
        return "건의 내용: " + content + " | 장소: " + location;
    }

    // 파일 저장 시 문자열 형식
    public String toCsvString() {
        return content + "," + location;
    }

	// 교재 641쪽 예제 15-12참조
	void showCenter() {
			JPanel panel = new JPanel();
			textArea = new JTextArea(13,40); // 13행 40열 텍스트영역 생성
			panel.add(new JScrollPane(textArea)); // 스크롤이 가능한 텍스트 영역 추가
		    textArea.setEditable(false); // 편집 불가능하게 설정
			
			
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
		
		
		// 교재 667~672쪽 KeyListener 참조해본다
		 // KeyListener 추가
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // 키 입력이 완료될 때 발생
            }

            @Override
            public void keyPressed(KeyEvent e) { // 교재 672쪽 예제 16-4 참조!
                // 특정 키 입력에 따라 동작 추가 가능
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JOptionPane.showMessageDialog(null, "엔터 키가 눌렸습니다!", "알림", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 키 떼는 이벤트 처리
            }
        };

        t1.addKeyListener(keyListener);
        t2.addKeyListener(keyListener);
		
		
		// 건의 추가 버튼 동작 설정
        
        
        //챗GPT 검색병행 처리하였습니다 ㅜㅜ
		//교재 672쪽 예제 16-4 참조
        b1.addActionListener(new ActionListener() {    // b1 건의 추가 버튼에 대한 이벤트처리..?

			public void actionPerformed(ActionEvent e) {
                // 입력 필드에서 내용 가져오기
            	 String content = t1.getText().trim(); // "건의 내용" 입력값 가져오기
                 String location = t2.getText().trim(); // "건의 장소" 입력값 가져오기

                // 입력값이 비어 있는지 확인
                if (content.isEmpty() || location.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "건의 내용과 장소를 모두 입력하세요!", "오류", JOptionPane.ERROR_MESSAGE);
                    return; // 건의를 추가하지 않고 종료
                }
                

                
             // 건의 객체 생성 및 추가
                SuggestionJWT suggestion1 = new SuggestionJWT(content, location); // 새로운 건의 생성
                suggestions.add(suggestion1); // 리스트에 추가
                textArea.append(suggestion1.toString() + "\n"); // 텍스트 영역에 추가

                
                
                // 입력 필드 초기화
                t1.setText("");
                t2.setText("");

                // 성공 메시지 표시
                JOptionPane.showInputDialog(null, "건의가 추가되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
            
        }
        });
        
        //챗GPT 검색병행 처리하였습니다 ㅜㅜ
        //교재 541쪽~545쪽을 같이 참고하였다.
        b2.addActionListener(new ActionListener() { //"b2" 버튼 액션리스너
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "suggestions.csv"; // 고정된 파일 이름으로 저장하게한다

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                	// BufferedWriter와 FileWriter를 사용해 파일 쓰기 
                	//교재  542쪽 참조
                    for (SuggestionJWT suggestion : suggestions) {
                        writer.write(suggestion.toCsvString());
                        writer.newLine(); //작성 후 줄바꿈 추가
                    }
                    JOptionPane.showMessageDialog(null, "파일이 성공적으로 저장되었습니다!\n파일 이름: " + fileName, "성공", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "파일 저장 중 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
	}
	
 // 메인 메서드
 public static void main(String[] args) {
     new SuggestionJWT(); // GUI 생성
     
	}
}




// 교재 책의 예제코드와 챗GPT코드 검색 활용하여 작성하였지만...그래도 어려웠습니다ㅜㅜㅜㅜ
// 짧은 학기 시간동안 쉽게 많은 지도 해주셔서 감사합니다.