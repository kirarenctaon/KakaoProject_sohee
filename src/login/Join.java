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
		
		title=new JLabel("īī���� pc���� ȸ������");
		info=new JLabel("���� ��ư�� �����ø� ȸ�������� �Ϸ�˴ϴ�. ");
		panel=new JPanel();
		t_email = new JTextField("�̸����� �Է��ϼ���"); 
		t_pw= new JTextField("��й�ȣ�� �Է��ϼ���"); 
		bt=new JButton("����");
		
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
