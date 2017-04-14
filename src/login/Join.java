package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Join extends JFrame{
	JLabel title, info;
	JPanel panel;
	JTextField t_email, t_pw;
	JButton bt;
	
	public Join() {
		
		title=new JLabel("카카오톡 pc버젼 회원가입");
		info=new JLabel("다음 버튼을 누르시면 회원가입이 완료됩니다. ");
		panel=new JPanel();
		t_email = new JTextField("이메일을 입력하세요"); 
		t_pw= new JTextField("비밀번호를 입력하세요"); 
		bt=new JButton("다음");
		
		setLayout(new BorderLayout());
		//panel.setLayout(new GridLayout(1,1));
		//panel.setPreferredSize(new Dimension(360, 590));
		panel.setBackground(new Color(255, 235, 051));
		title.setBackground(new Color(255, 235, 051));
		info.setBackground(new Color(255, 235, 051));
		bt.setBackground(new Color(113	, 92, 94));
		
		
		panel.add(t_pw);
		panel.add(bt);
		add(panel, BorderLayout.NORTH);
			
		setSize(380, 650);
		setVisible(true);
	}

}
