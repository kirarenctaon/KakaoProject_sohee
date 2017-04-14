package sample;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Photo2 extends JFrame{
	JPanel panel;
	JTextField t_id, t_pw, t_nick;

	Canvas can;
	BufferedImage image=null;
	URL url=this.getClass().getResource("/p1.jpg");
	Photo2 join;

	
	public Photo2() {
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
		panel.setOpaque(false);
		panel.add(can);
		
		panel.setPreferredSize(new Dimension(360, 590));
		panel.setBackground(new Color(255, 235, 051));
		
		panel.add(t_id);
		panel.add(t_pw);
		add(panel);
		
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("누름");
				System.exit(0);
			}
		});
	
		this.setSize(380, 650);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
	
	@Override
	/*public void paint(Graphics g) {
		Path2D p = new Path2D.Double();
		
		//Creates a circular hole at the centre of window
		int radius = getWidth()/4, leftX = getWidth()/2-radius, 
		topY = getHeight()/2-radius;
		p.append(new Ellipse2D.Double(leftX, topY, 2*radius, 2*radius), false);
		setShape(p);
		super.paint(g);
	}*/

	public void paint(Graphics g){}
	
	public static void main(String[] args) {
		new Photo2();
	}
	

}
