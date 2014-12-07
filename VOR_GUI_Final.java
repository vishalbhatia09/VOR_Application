import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VOR_GUI extends JFrame implements ActionListener
{
	private ImageIcon image;
	public static int mouseX = 30;
	public static int mouseY = 203;
	JLabel plane;
	JLabel vor;
	JLabel vor_label;
	public static JTextField tf;
	Graphics g;
	public String freq;
	public double freq_int;
	public JButton btn1NewButton,btn2NewButton, btnNewButton;
	public int width2;
	public int height2;
	AffineTransform at;
	BufferedImage vor_img;
	BufferedImageOp bio;
	Graphics2D g2d,g2;
	AffineTransform backup;
	public int d = 0;
	public int val=0;
	double angle = 0.0;
	public String a, RadioVal;
	public int radiovalue;
	public boolean vor_indicator;
	public int default_vor_indicator = 0;
	
	
	public VOR_GUI()
	{
		setTitle("VOR_GUI");
		setSize(480,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		
		
		
		btnNewButton = new JButton(new ImageIcon("Images/obs1.gif"));
		btn1NewButton = new JButton(new ImageIcon("Images/up.gif"));
		btn2NewButton = new JButton(new ImageIcon("Images/down.gif"));
		
	    
		tf = new JTextField(5);
	     getContentPane().add(tf);
	     tf.setText("100");
	     tf.setBounds(312,275,106,102);
	     		
		getContentPane().add(btnNewButton);
		btnNewButton.setBounds(310,200, 30,30);
		btnNewButton.addActionListener(this);
		getContentPane().add(btn1NewButton);
		btn1NewButton.setBounds(418,275,43,50);
		btn1NewButton.addActionListener(this); 
		getContentPane().add(btn2NewButton);
		btn2NewButton.setBounds(418,325,43,50);
		btn2NewButton.addActionListener(this); 	
		
		
		vor_label = new JLabel();
		getContentPane().add(vor_label);
		vor_label.setOpaque(true);
		vor_label.setBackground(Color.YELLOW);
		a=Integer.toString(val);
		vor_label.setText(a);
		vor_label.setBounds(378,20,25,25);
		repaint();			
		
		plane = new JLabel(new ImageIcon("Images/plane2.png"));
		getContentPane().add(plane);
		
		plane.setOpaque(true);
		plane.setBackground(Color.BLACK);
		plane.setBounds(250,340,30,30);
		
		plane.addMouseMotionListener(new moveIconHandler());		
		setVisible(true);
		
	}	
	
	
	
	public void paint(Graphics g)
	{
		
		super.paint(g);
		
		
		at = AffineTransform.getTranslateInstance(312,95);
	    
	    vor_img = LoadImage("Images/VOR.gif"); 
	    width2 = vor_img.getWidth();
		height2 = vor_img.getHeight();

	    
	    g2d = (Graphics2D) g;
	    backup = new AffineTransform();
	    at.rotate(Math.toRadians(d), width2/2, height2/2);
	    g2d.drawImage(vor_img, at,this);
	    
	    
		g.drawLine(300, 0, 300, 480);
		g.setColor(Color.BLACK);
		g.drawLine(300, 270, 480, 270);
		g.setColor(Color.BLACK);

	    g.drawOval(140,230,20,20);

	    g.drawLine( 332,170,445,170);
	    g.drawRect(315,300,150,100);
	    g.drawLine(420,300,420,400);
	    g.drawLine(420,350,465,350);
	    g.drawLine(150,140,150,340);
	    g.drawLine(50,240,250,240);
	    if(mouseY >= 203)					//Towards VOR Station 
	    {
	    	g.fillRect(345,175,10,10);
	    	g.drawRect(345,175,10,10);

	    }

	    else								//From VOR Station
	    {
	    		    	
	    	g.fillRect(345,155,10,10);
	    	g.drawRect(345,155,10,10);
	    	
	    }
	    
	    if(mouseX == 131 && mouseY == 203 || mouseX == 130 && mouseY == 203 || mouseX == 131 && mouseY == 202 || mouseX == 130 && mouseY == 202 ||mouseX == 129 && mouseY == 201)
	    {
	    	g.fillRect(425,155,10,10);        //good and Bad signal
	    	g.drawRect(425,155,10,10);
	    }
	    
	    else
	    {
	    	 g.fillRect(425,175,10,10);
	    	 g.drawRect(425,175,10,10);
	    }
	    
	   
	    g.drawLine(350,168,350,172);
	    g.drawLine(360,168,360,172);
	    g.drawLine(370,168,370,172); 
	    g.drawLine(380,168,380,172);
	    g.drawLine(390,168,390,172);
	    g.drawLine(400,168,400,172);
	    g.drawLine(410,168,410,172);
	    g.drawLine(420,168,420,172);
	    g.drawLine(430,168,430,172);
	    g.drawLine(440,168,440,172);
	    g.drawString("FM",357,163);
	    g.drawString("BD",405,163);
	    g.drawString("TO",357,185);
	    g.drawString("GD",405,185);
	    
	    if(default_vor_indicator == 0)
    	{
    		g.drawLine(392,124,392,239);
    		
    	}
	    
	    if(vor_indicator == true && default_vor_indicator == 1)
	    {
	    		g.drawLine(415,124,415,239);
	    	
	    }
	    
	    if(vor_indicator == false && default_vor_indicator == 1)
    	{
    		g.drawLine(365,124,365,239);
    		
    	}
	    
	    
	 }
	
	
	
	BufferedImage LoadImage(String Filename) 							//Load VOR Image
	{
		BufferedImage vor_img = null;
		
		try
		{
		vor_img = ImageIO.read(new File(Filename));
		}
		catch(IOException e)
		{
			
		}
		return vor_img;
				
		
	}


	
	public void actionPerformed(ActionEvent e) 							// Implementing action on buttons and needle
	{
		if(e.getSource() == btn1NewButton)
		{
			freq = tf.getText();
			freq_int = Double.parseDouble(freq);
			freq_int= freq_int + 0.5;
			freq = Double.toString(freq_int);
			tf.setText(freq);
			//radiovalue = Integer.parseInt(freq);
			tf.setText(freq);
		 }
		if(e.getSource() == btn2NewButton)
		{
			freq = tf.getText();
			freq_int = Double.parseDouble(freq);
			freq_int =freq_int - 0.5;
			freq = Double.toString(freq_int);
			tf.setText(freq);
			//radiovalue = Integer.parseInt(freq);
			
		 }
		
		if(e.getSource() == btnNewButton)
		{
			
			d =  d - 1;
			val = val + 1;
			repaint();
			a=Integer.toString(val);
			vor_label.setText(a);
			RadioVal = Radio.get_radio_angle();
			radiovalue = Integer.parseInt(RadioVal);
				
		}		
	}


	public class moveIconHandler extends MouseMotionAdapter 
	{		
		public void mouseDragged(MouseEvent e) 
		{					
			Component c = e.getComponent();
			System.out.println("x = " + c.getX() + ", y = " + c.getY()+ "\n");
			c.setLocation( c.getX()+e.getX(), c.getY()+e.getY() );
			mouseX = c.getX() + e.getX();
			mouseY = c.getY() + e.getY();
			repaint();			
			angle = Calculation.get_angle();
			System.out.println("The angle:" +angle);
						
			if (radiovalue == val)
			{
			
				if (angle < radiovalue )
				{
					vor_indicator = true;
					default_vor_indicator = 1;
				}
			
				if (angle > radiovalue )
				{
					vor_indicator = false;
					default_vor_indicator = 1;
				} 
			
				if (angle == radiovalue )
				{
					default_vor_indicator = 0;
					
				}
			
			}
			
			else
				default_vor_indicator = 0;			
		}
		
		
		public void mouseMoved(MouseEvent e)
		{
			
		}
		
	}	
	
	public static void main(String[] args)
	{
		VOR_GUI t = new VOR_GUI();
		
	}
}

