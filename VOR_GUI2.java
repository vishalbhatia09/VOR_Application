import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;


//public paint(Graphics g);
public class VOR_GUI extends JFrame implements ActionListener
{
	private ImageIcon image;
	private int mouseX = 30;
	private int mouseY = 30;
	JLabel plane;
	Graphics g;
	//public void paint(Graphics g);
	//private JPanel panel = new JPanel(null);
	
	public VOR_GUI()
	{
		setTitle("VOR_GUI");
		setSize(480,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		//getContentPane().add(panel);
		//getContentPane().addMouseListener((MouseListener) this);
		
		
		JButton btnNewButton = new JButton(new ImageIcon("Images/obs1.gif"));
		JButton btn1NewButton = new JButton(new ImageIcon("Images/up.gif"));
		JButton btn2NewButton = new JButton(new ImageIcon("Images/down.gif"));
		//btnNewButton.setSize(20,20);
		//btnNewButton.addActionListener(new ActionListener() 
		//{
			//public void actionPerformed(ActionEvent arg0) {
			//}
		//});
		
		getContentPane().add(btnNewButton);
		btnNewButton.setBounds(310,200, 30,30);
		getContentPane().add(btn1NewButton);
		btn1NewButton.setBounds(418,275,43,50);
		getContentPane().add(btn2NewButton);
		btn2NewButton.setBounds(418,325,43,50);
		
		

		JLabel lblNewLabel = new JLabel();
		getContentPane().add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(410,150,10,10);
		
		JLabel lblNewLabel1 = new JLabel();
		getContentPane().add(lblNewLabel1);
		lblNewLabel1.setOpaque(true);
		lblNewLabel1.setBackground(Color.BLACK);
		lblNewLabel1.setBounds(410,130,10,10);
		
		//JLabel plane = new JLabel(new ImageIcon("Images/plane2.png"));
		plane = new JLabel(new ImageIcon("Images/plane2.png"));
		getContentPane().add(plane);
		//panel.add(plane);
		plane.setOpaque(true);
		plane.setBackground(Color.BLACK);
		plane.setBounds(250,340,30,30);
		//plane.addMouseMotionListener(this);
		plane.addMouseMotionListener(new moveIconHandler());
		//plane.addMouseMotionListener(this);
		//plane.setBounds(mouseX,mouseY, 30, 30);
	
		
		setVisible(true);
	}
		

		
		
	
	
	
	/*public void mouseDragged(MouseEvent e)
	{
		 mouseX = e.getX();
		 mouseY = e.getY();
		 plane.setBounds(mouseX,mouseY,30,30);
		 
		
	}
	
	public void mouseMoved(MouseEvent e){}*/	
	
	public void paint(Graphics g)
	{
		
		super.paint(g);
		g.drawLine(300, 0, 300, 480);
		g.setColor(Color.BLACK);
		g.drawLine(300, 270, 480, 270);
		g.setColor(Color.BLACK);
	    g.drawOval(315,100,140,140);
	    g.drawOval(332,117,108,108);
	    g.drawLine( 332,170,440,170);
	    g.drawRect(315,300,150,100);
	    g.drawLine(420,300,420,400);
	    g.drawLine(420,350,465,350);
	    g.drawLine(150,140,150,340);
	    g.drawLine(50,240,250,240);
	    g.drawRect(345,155,10,10);
	    g.drawRect(345,175,10,10);
	    g.drawLine(350,168,350,172);
	    g.drawLine(360,168,360,172);
	    g.drawLine(370,168,370,172); 
	    g.drawLine(380,168,380,172);
	    g.drawLine(390,168,390,172);
	    g.drawLine(400,168,400,172);
	    g.drawLine(410,168,410,172);
	    g.drawLine(420,168,420,172);
	  
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
	


	/*@Override
	public void mouseDragged(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		 
		 mouseX = e.getX();
		 mouseY = e.getY();
		// plane.setOpaque(true);
		 //plane.setBackground(Color.BLACK);
		 plane.setBounds(mouseX,mouseY,30,30);
		repaint();
		// super.paint(g);
	}


	@Override
	public void mouseMoved(MouseEvent e) 
	{
		repaint();
		// TODO Auto-generated method stub
		
	}*/
	
	
	
	private class moveIconHandler extends MouseMotionAdapter 
	{
		
		public void mouseDragged(MouseEvent e) 
		{
			//System.out.println("x = " + e.getX() + ", y = " + e.getY()+ "\n");
			Component c = e.getComponent();
			System.out.println("x = " + c.getX() + ", y = " + c.getY()+ "\n");
			c.setLocation( c.getX()+e.getX(), c.getY()+e.getY() );
			repaint();
		}
		
		
		public void mouseMoved(MouseEvent e) 
		{
			//System.out.println("x = " + e.getX() + ", y = " + e.getY()+ "\n");
			repaint();
			// TODO Auto-generated method stub
			
		}
		
	}

	
	
	public static void main(String[] args)
	{
		VOR_GUI t = new VOR_GUI();
		
	}
	
}