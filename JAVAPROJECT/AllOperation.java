import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;

class AllOperation extends JFrame implements ActionListener {

    JButton b1, b2, b5, b6, b7, b8, b9;
    JLabel background, l1,name;

    Connection cn;
    Statement stm;
    ResultSet rs;
    PreparedStatement prstm;
    String sql;

    AllOperation()
	{
        setSize(1800, 800);
        setLocation(0, 0);
        setTitle("ALL OPERATION");
        setLayout(null);
        setFont(new Font("Arial", Font.PLAIN, 60));

         
		 
		 
		
		ImageIcon icon = new ImageIcon("house.png"); 
		Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		b1 = new JButton("HOME", scaledIcon);
		b1.setVerticalTextPosition(SwingConstants.CENTER);
		b1.setHorizontalTextPosition(SwingConstants.LEFT);
		b1.setOpaque(false); // Make button transparent
		b1.setContentAreaFilled(true); // Make content area transparent
		b1.setBorderPainted(true); // Remove border
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		b1.setBackground(new Color(0,0,0,0));
		b1.setFocusPainted(false);
		add(b1);


		ImageIcon icon2 = new ImageIcon("carmaster.png"); 
		Image scaledImage2 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		b2 = new JButton("  CAR MASTER  ", scaledIcon2);
		b2.setVerticalTextPosition(SwingConstants.CENTER);
		b2.setHorizontalTextPosition(SwingConstants.LEFT);
		b2.setOpaque(false); // Make button transparent
		b2.setContentAreaFilled(true); // Make content area transparent
		b2.setBorderPainted(true); // Remove border
		b2.setFont(new Font("Arial", Font.BOLD, 20));
		b2.setBackground(new Color(0,0,0,0));
		b2.setFocusPainted(false);
		add(b2);

		ImageIcon icon3 = new ImageIcon("carmaster.png"); 
		Image scaledImage3 = icon3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);
		b5 = new JButton(" RENTING CAR ", scaledIcon3);
		b5.setVerticalTextPosition(SwingConstants.CENTER);
		b5.setHorizontalTextPosition(SwingConstants.LEFT);
		b5.setOpaque(false); // Make button transparent
		b5.setContentAreaFilled(true); // Make content area transparent
		b5.setBorderPainted(true); // Remove border
		b5.setFont(new Font("Arial", Font.BOLD, 20));
		b5.setBackground(new Color(0,0,0,0));
		b5.setFocusPainted(false);
		add(b5);
		 
		 
		 ImageIcon icon4 = new ImageIcon("carmaster.png"); 
		Image scaledImage4 = icon4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);
		b6 = new JButton("AVAILABLE CAR", scaledIcon4);
		b6.setVerticalTextPosition(SwingConstants.CENTER);
		b6.setHorizontalTextPosition(SwingConstants.LEFT);
		b6.setOpaque(false); // Make button transparent
		b6.setContentAreaFilled(true); // Make content area transparent
		b6.setBorderPainted(true); // Remove border
		b6.setFont(new Font("Arial", Font.BOLD, 20));
		b6.setBackground(new Color(0,0,0,0));
		b6.setFocusPainted(false);
		add(b6);

		 ImageIcon icon5 = new ImageIcon("money.png"); 
		Image scaledImage5 = icon5.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(scaledImage5);
		b7 = new JButton("TOTAL EARNING", scaledIcon5);
		b7.setVerticalTextPosition(SwingConstants.CENTER);
		b7.setHorizontalTextPosition(SwingConstants.LEFT);
		b7.setOpaque(false); // Make button transparent
		b7.setContentAreaFilled(true); // Make content area transparent
		b7.setBorderPainted(true); // Remove border
		b7.setFont(new Font("Arial", Font.BOLD, 20));
		b7.setBackground(new Color(0,0,0,0));
		b7.setFocusPainted(false);
		add(b7);
		 
		 
		  ImageIcon icon6 = new ImageIcon("customer.png"); 
		Image scaledImage6 = icon6.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(scaledImage6);
		b8 = new JButton("  CUSTOMERS ", scaledIcon6);
		b8.setVerticalTextPosition(SwingConstants.CENTER);
		b8.setHorizontalTextPosition(SwingConstants.LEFT);
		b8.setOpaque(false); // Make button transparent
		b8.setContentAreaFilled(true); // Make content area transparent
		b8.setBorderPainted(true); // Remove border
		b8.setFont(new Font("Arial", Font.BOLD, 20));
		b8.setBackground(new Color(0,0,0,0));
		b8.setFocusPainted(false);
		add(b8);
		 
		  ImageIcon icon7 = new ImageIcon("carmaster.png"); 
		Image scaledImage7 = icon7.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(scaledImage7);
		b9 = new JButton(" TOTAL  CARS  ", scaledIcon7);
		b9.setVerticalTextPosition(SwingConstants.CENTER);
		b9.setHorizontalTextPosition(SwingConstants.LEFT);
		b9.setOpaque(false); // Make button transparent
		b9.setContentAreaFilled(true); // Make content area transparent
		b9.setBorderPainted(true); // Remove border
		b9.setFont(new Font("Arial", Font.BOLD, 20));
		b9.setBackground(new Color(0,0,0,0));
		b9.setFocusPainted(false);
		add(b9);
		 
		
		

      

         
        b1.addActionListener(this);
        b2.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        b1.setBounds(50, 110, 250, 60);
        b2.setBounds(50, 200, 250, 60);
        b5.setBounds(50, 300, 250, 60);
        b6.setBounds(50, 400, 250, 60);
        b9.setBounds(50, 500, 250, 60);
        b8.setBounds(50, 600, 250, 60);
        b7.setBounds(50, 700, 250, 60);

        ImageIcon img = new ImageIcon("mainbackground.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1540, 800);
        add(background);

        Font f = new Font("serif", Font.BOLD, 60);
        JPanel heading = new JPanel();
        heading.setBackground(new Color(50,30,0,20));
        heading.setBounds(0,100, 330, 1000);
        background.add(heading);
		
		 Font f1=new Font("serif",Font.BOLD,60);
		JPanel heading1=new JPanel();
		heading1.setBackground(new Color(50,30,0,30));
		heading1.setBounds(0,0,1600,100);
		background.add(heading1);
		name=new JLabel("Car Rental System");
		name.setBounds(180,100,500,100);
		name.setFont(f1);
		heading1.add(name);
		name.setForeground(Color.ORANGE);
		

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:12407/project", "root", "root");

        } catch (Exception eee) {
            System.out.println(eee);

        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new carsection2();

        } else if (e.getSource() == b2) {
            new carsection2();
        } else if (e.getSource() == b5) {
            new RentingCarFrame();
        } else if (e.getSource() == b6) {
            new AvailableCar();
        } else if (e.getSource() == b7) {
            new TotalEarning();
        } else if (e.getSource() == b8) {
            new customers();
        } else if (e.getSource() == b9) {
            new TotalCars();
        }
    }

    public static void main(String args[]) {
        new AllOperation();
    }
}
