package chapter10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest {

	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		f.setLayout(new BorderLayout());
		Button btnClick = new Button("Button1");
		Button btnClick2 = new Button("Button2");
		Button btnClick3 = new Button("Button3");
		p.add(btnClick);	p2.add(btnClick2);	p3.add(btnClick3);
		f.add(p3, BorderLayout.SOUTH);
		f.add(p2, BorderLayout.CENTER);
		f.add(p, BorderLayout.NORTH);
		f.setTitle("버튼 테스트");
		f.setSize(300, 400);
		f.setVisible(true);
		
		//버튼의 이벤트 처리1 - 내부 클래스를 생성하여 액션 이벤트 처리
//		ButtonTest.ButtonActionListener action = new ButtonTest.ButtonActionListener();
		btnClick.addActionListener(new ButtonTest.ButtonActionListener());
		
		//버튼의 이벤트 처리2 - Anonymous(익명) 클래스를 생성하여 액션 이벤트 처리
		btnClick2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button2 Click!!!");
			}
		});
		
		//버튼의 이벤트 처리3 - 람다식(자바버전 8이상) 처리방식을 이용한 이벤트 처리
//		btnClick3.addActionListener((ActionEvent e) -> {
//			System.out.println("Button3 Click!!!");
//		});
		
//		btnClick3.addActionListener(e -> {
//			System.out.println("Button3 Click!!!");
//		});
		
		btnClick3.addActionListener(e -> System.out.println("Button3 Click!!!"));
		
		//Frame의 종료 이벤트
		f.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				System.out.println("- 프로그램 종료 -");
				System.exit(0);
			}
			public void windowDeactivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowOpened(WindowEvent e) {}
			
		});
		
		
		
	}//main
	
	/**
	 * 버튼의 이벤트 처리 클래스
	 */
	public static class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Click!!!!");
		}
	}//ButtonActionListener
	
}//class
