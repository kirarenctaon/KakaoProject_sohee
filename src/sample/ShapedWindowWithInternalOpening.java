package sample;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import login.Join;

class ShapedWindowWithInternalOpening extends JFrame implements ActionListener{
	JButton   exit = new JButton("Exit");
	
	
	Canvas can;
	BufferedImage image=null;
	URL url=this.getClass().getResource("/bg9.jpg");
	Join join;
	
	
	public ShapedWindowWithInternalOpening() {
		super("Shaped Window");
		this.setUndecorated(true);
		
		exit.addActionListener(this);
		
		JPanel p1 = new JPanel(new FlowLayout());
		p1.setBackground(Color.BLACK);
		p1.setPreferredSize(new Dimension(150, 300));
		p1.add(exit);
		this.getContentPane().add(p1, BorderLayout.NORTH);
		
		
		try {
			image=ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		can=new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, 1000, 300, this);
			}
		};
		can.setPreferredSize(new Dimension(500, 300));
		p1.add(can);
		
		
		
		join=new Join();
		
		this.setSize(380, 650);
		Dimension d = this.getToolkit().getScreenSize();
		//this.setLocation(d.width/2-250, d.height/2-150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		

	 
		
	}
	
	@Override
	public void paint(Graphics g) {
		Path2D p = new Path2D.Double();
		
		
		p.append(new RoundRectangle2D.Double(0,0, getWidth(), getHeight(), 0, 0), true);
		//p.append(new RoundRectangle2D.Double(0,0, getWidth(), getHeight(), 200, 200), false);
		
		//Creates a circular hole at the centre of window
		int radius = getWidth()/4, leftX = getWidth()/2-radius, 
		topY = getHeight()/2-radius;
		p.append(new Ellipse2D.Double(leftX, topY, 2*radius, 2*radius), false);
		setShape(p);
		super.paint(g);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String com = ae.getActionCommand();
		if(com.equals("Exit"))
		System.exit(0);
	}
	
	public static void main(String arg[]) {
		GraphicsDevice gd = GraphicsEnvironment.
		getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if(!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT)) {
		JOptionPane.showMessageDialog(null, "No support for shaped window!");
		System.exit(0);
		}
		new ShapedWindowWithInternalOpening();
	}
}