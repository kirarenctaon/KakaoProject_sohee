package sample;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.Join;

public class profile extends JFrame {
	JPanel panel;
	JTextField t_id, t_pw, t_nick;

	Canvas can;
	BufferedImage image=null;
	URL url=this.getClass().getResource("/bg9.jpg");
	Join photo;

	
	public profile() {
		this.setUndecorated(true);
		
		panel=new JPanel();
		t_id = new JTextField("아이디를 입력하세요"); 
		t_pw= new JTextField("비밀번호를 입력하세요"); 
	
		try {
			image=ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		can=new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, 500, 500, this);
			}
		};
		can.setPreferredSize(new Dimension(500, 500));
		panel.add(can);
		
		panel.setPreferredSize(new Dimension(360, 590));
		panel.setBackground(new Color(255, 235, 051));
		
		panel.add(t_id);
		panel.add(t_pw);
		add(panel);
		
		
		this.setSize(380, 650);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("누름");
				System.exit(0);
			}
		});
		photo=new Join();
	}
	
	@Override
	public void paint(Graphics g) {

	}

	public static void main(String[] args) {
		new profile();
	}
	
}
