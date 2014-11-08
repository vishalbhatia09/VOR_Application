import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.EventQueue;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VOR_GUI extends JFrame
{
	public VOR_GUI()
	{
		setTitle("VOR_GUI");
		setSize(480,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		//btnNewButton.setSize(20,20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(btnNewButton);
		btnNewButton.setBounds(310,195, 30,30);
		
	}
	public void paint(Graphics g)
	{
		g.drawLine(300, 0, 300, 480);
		g.setColor(Color.BLACK);
		g.drawLine(300, 270, 480, 270);
		g.setColor(Color.BLACK);
	    	
	    	g.drawRect(315,300,150,100);
	    	g.drawLine(420,300,420,400);
	    	g.drawLine(420,350,465,350);
	   	g.drawLine(150,140,150,340);
	   	g.drawLine(50,240,250,240);
	   	
	  
	}
	

	public static void main(String[] args)
	{
		VOR_GUI t = new VOR_GUI();
		
	}
}