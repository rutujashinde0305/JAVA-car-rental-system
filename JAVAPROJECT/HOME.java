import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays.*;

class MyFrame extends JFrame implements ActionListener
{

	JLabel l1,l2;
	 JLabel background,name ;
	 MyFrame()
	{
		setSize(1700,1800);
		setLocation(0,0);
		setTitle("Frame1");
		setLayout(null);
		setFont(new Font("Arial",Font.PLAIN,60));
		
		 
		//2)Memory Allocation
			 l1=new JLabel("Home");
	         l2=new JLabel("Login");
		
		 add(l1);
		 add(l2);
		
		 //5)SetBounds
		 Font labelFont=new Font("Arial",Font.BOLD,30);
		  l1.setBounds(1100,40,500,60);
		 l2.setBounds(1200,40,500,60);
		l1.setFont(labelFont);
		l2.setFont(labelFont);
		  
        //Add Background image
		ImageIcon img=new ImageIcon("mainbackground.png");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1540,800);
		add(background);
		 
		//Add header and name in header
		Font f=new Font("serif",Font.BOLD,60);
		JPanel heading=new JPanel();
		heading.setBackground(new Color(0,0,0,30));
		heading.setBounds(0,0,1600,100);
		background.add(heading);
		name=new JLabel("Admin Page");
		name.setBounds(220,100,400,100);
		heading.add(name);
		name.setFont(f);
		name.setForeground(Color.WHITE);
		
		
		 
		 addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		 
		 l2.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				  new login();
			 }
		 });
		  
		 
		 
		 
		setVisible(true);
		 
	}
	 
	
	public void actionPerformed(ActionEvent e)
	{
		 
		 
		
	}
	 
	 
}//End of class
class HOME
{
	public static void main(String args[])
	{
		new MyFrame();
	}
}