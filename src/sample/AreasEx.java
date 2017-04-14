package sample;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AreasEx extends JFrame {

	JPanel panel;
	
	Canvas can;
	BufferedImage image=null;
	URL url=this.getClass().getResource("/p1.jpg");
	
    public AreasEx() {

        initUI();
    }

    private void initUI() {
    	
        panel = new JPanel();
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
		can.setPreferredSize(new Dimension(360, 590));
		panel.setPreferredSize(new Dimension(360, 590));
		panel.setBackground(new Color(255, 235, 051));
		panel.add(can);
		add(panel);
		add(new Surface());
        
		setTitle("Areas");
        setSize(450, 200);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                AreasEx ex = new AreasEx();
                ex.setVisible(true);
            }
        });
    }
}