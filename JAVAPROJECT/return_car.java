import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class return_car extends JFrame implements ActionListener {

   
	JButton b1,b2,b3,b5,b6,b7,b8,b9,b11,add,remove,update,return_car,search,GO;
	JLabel background,name,form_title,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	TextField t1,t2,t3,t4,t5,t6,t7,t10,t11,t12;
	DateButton calb,calb2;

    Connection cn;
    Statement stmt;
    ResultSet rs;
    PreparedStatement prstm;
    String sql;

    return_car()
	{
        setSize(1800, 800);
        setLocation(0, 0);
        setTitle("ALL OPERATION");
        setLayout(null);
        setFont(new Font("Arial", Font.PLAIN, 60));

         
		 
		  JPanel heading = new JPanel();
		  JPanel heading1=new JPanel();
		 // JPanel heading2=new JPanel();
		
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

		b2.setForeground(Color.RED);
		b2.setFocusPainted(false);
		b2.setBounds(50, 120, 250, 60);//Added on heading
		heading.add(b2);

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
		 
		b5.setFocusPainted(false);
		b5.setForeground(Color.ORANGE);
		b5.setEnabled(false);
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
		 
		b6.setFocusPainted(true);
		b6.setForeground(Color.ORANGE);
		 b6.setEnabled(false);
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
		 
		b7.setFocusPainted(false);
		b7.setForeground(Color.ORANGE);
		 b7.setEnabled(false);
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
		b8.setBackground(new Color(0,50,0,80));
		b8.setForeground(Color.ORANGE);
		b8.setFocusPainted(false);
		b8.setEnabled(false);
		add(b8);
		 
		  ImageIcon icon7 = new ImageIcon("carmaster.png"); 
		Image scaledImage7 = icon7.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(scaledImage7);
		b9 = new JButton(" TOTAL  CARS  ", scaledIcon7);
		b9.setVerticalTextPosition(SwingConstants.CENTER);
		b9.setHorizontalTextPosition(SwingConstants.LEFT);
		b9.setOpaque(false); // Make button transparent
		  // Make content area transparent
		b9.setBorderPainted(true); // Remove border
		b9.setFont(new Font("Arial", Font.BOLD, 20));
		 b9.setFocusPainted(false);
		 b9.setForeground(Color.ORANGE);
		 b9.setEnabled(false);
		add(b9);
		 
		 
		 
		ImageIcon icon8 = new ImageIcon("carmaster.png"); 
		Image scaledImage8 = icon8.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon8 = new ImageIcon(scaledImage8);
		add = new JButton(" ADD ", scaledIcon8);
		add.setVerticalTextPosition(SwingConstants.CENTER);
		add.setHorizontalTextPosition(SwingConstants.LEFT);
		add.setOpaque(false); // Make button transparent
		//add.setContentAreaFilled(true); // Make content area transparent
		add.setBorderPainted(true); // Remove border
		add.setFont(new Font("Arial", Font.BOLD, 20));
		add.setBackground(new Color(0,0,0,0));
		add.setForeground(Color.YELLOW);
		 
		 add(add);
		 
		 
		 
		  
		ImageIcon icon9 = new ImageIcon("removecar.png"); 
		Image scaledImage9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(scaledImage9);
		remove = new JButton("REMOVE", scaledIcon9);
		remove.setVerticalTextPosition(SwingConstants.CENTER);
		remove.setHorizontalTextPosition(SwingConstants.LEFT);
		remove.setOpaque(false); // Make button transparent
		//add.setContentAreaFilled(true); // Make content area transparent
		remove.setBorderPainted(true); // Remove border
		remove.setFont(new Font("Arial", Font.BOLD, 20));
		remove.setBackground(new Color(0,0,0,0));
		remove.setForeground(Color.YELLOW);
		add(remove);


		ImageIcon icon10 = new ImageIcon("updatecar.png"); 
		Image scaledImage10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(scaledImage10);
		update = new JButton("UPDATE", scaledIcon10);
		update.setVerticalTextPosition(SwingConstants.CENTER);
		update.setHorizontalTextPosition(SwingConstants.LEFT);
		update.setOpaque(false); // Make button transparent
		//add.setContentAreaFilled(true); // Make content area transparent
		update.setBorderPainted(true); // Remove border
		update.setFont(new Font("Arial", Font.BOLD, 20));
		update.setBackground(new Color(0,0,0,0));
		update.setForeground(Color.YELLOW);
		add(update);




		ImageIcon icon11 = new ImageIcon("returncar.png"); 
		Image scaledImage11 = icon11.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(scaledImage11);
		return_car = new JButton("RETURN", scaledIcon11);
		return_car.setVerticalTextPosition(SwingConstants.CENTER);
		return_car.setHorizontalTextPosition(SwingConstants.LEFT);
		return_car.setOpaque(false); // Make button transparent
		//add.setContentAreaFilled(true); // Make content area transparent
		return_car.setBorderPainted(true); // Remove border
		return_car.setFont(new Font("Arial", Font.BOLD, 20));
		//return_car.setBackground(new Color(0,0,0,0));
		return_car.setForeground(Color.YELLOW);
		add(return_car);


		ImageIcon icon12 = new ImageIcon("serchCar.png"); 
		Image scaledImage12 = icon12.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon12 = new ImageIcon(scaledImage12);
		search = new JButton("SEARCH", scaledIcon12);
		search.setVerticalTextPosition(SwingConstants.CENTER);
		search.setHorizontalTextPosition(SwingConstants.LEFT);
		search.setOpaque(false); // Make button transparent
		//add.setContentAreaFilled(true); // Make content area transparent
		search.setBorderPainted(true); // Remove border
		search.setFont(new Font("Arial", Font.BOLD, 20));
		search.setBackground(new Color(0,0,0,0));
		search.setForeground(Color.YELLOW);
		add(search);

		 
		 
				 
				
 
 
 
		l1=new JLabel("ENTER CAR_NO");
		l2=new JLabel("CUST_ID");
		l3=new JLabel("CUST_NAME");
		l4=new JLabel("CUST ADDRESS");
		l5=new JLabel("CUST PHONE");
		l6=new JLabel("CUST EMAIL");
		l7=new JLabel("RENT_ID");
		l8=new JLabel("RENT DATE");
		l9=new JLabel("RETURN DATE");
		l10=new JLabel("per DAY price");
		l11=new JLabel("Total price");
		l12=new JLabel("Advance");
		
		t1=new TextField(20);
		t2=new TextField(20);
		t3=new TextField(20);
		t4=new TextField(20);
		t5=new TextField(20);
		t6=new TextField(20);
		t7=new TextField(20);
		 
		 
		t10=new TextField(20);
		t11=new TextField(20);
		t12=new TextField(20);
		 
		 
		 
		b11=new JButton("RETURN");
		GO=new JButton("SEE DETAIL");
		
		 
		b11.setBackground(Color.GREEN);
		GO.setBackground(Color.GREEN);
		
		 
		b11.setForeground(Color.BLUE);
		GO.setForeground(Color.BLUE);
		
		
		
		 
		 b11.addActionListener(this);
		 GO.addActionListener(this); 
		 
		    
		 b11.setBounds(340,540,130,25);
		GO.setBounds(580,80,200,30);
		
		 calb = new DateButton();		   
        add(calb);
		
		calb2 = new DateButton();		   
        add(calb2);
		
		
		 l1.setBounds(220,80,140,30);
		t1.setBounds(360,80,200,30);
		l2.setBounds(220,120,140,30);
		t2.setBounds(360,120,200,30);
		l3.setBounds(220,160,140,30);
		t3.setBounds(360,160,200,30);
		l4.setBounds(220,200,140,30);
		t4.setBounds(360,200,200,30);
		l5.setBounds(220,240,140,30);
		t5.setBounds(360,240,200,30);
		l6.setBounds(220,280,140,30);
		t6.setBounds(360,280,200,30);
		l7.setBounds(220,320,140,30);
		t7.setBounds(360,320,200,30); 
		l8.setBounds(220,360,140,30);
		calb.setBounds(780,560,200,30); 
		l9.setBounds(220,400,140,30);
		calb2.setBounds(780,600,200,30); 
		l10.setBounds(220,440,140,30);
		t10.setBounds(360,440,200,30); 
		l12.setBounds(220,480,140,30);
		t12.setBounds(360,480,200,25); 
		l11.setBounds(220,510,140,30);
		t11.setBounds(360,510,200,25); 
		
		
		
		ImageIcon img = new ImageIcon("mainbackground.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1540, 800);
        add(background);

		 
		 
		
		
		Font f1=new Font("serif",Font.BOLD,30);
		JPanel form=new JPanel();
		form.setLayout(null);
		form.add(l1); form.add(t1);
		form.add(l2); form.add(t2);
		form.add(l3); form.add(t3);
		form.add(l4); form.add(t4);
		form.add(l5); form.add(t5);
		form.add(l6); form.add(t6);
		form.add(l7); form.add(t7);
		form.add(l8);  
		form.add(l9);  
		form.add(l10); form.add(t10);
		form.add(l11); form.add(t11);
		form.add(l12); form.add(t12);
 		 
		form.add(b11);
		form.add(GO);
		 
		
		
		
		form.setBackground(new Color(0,0,0,50));
		form.setBackground(Color.ORANGE);
		form.setBounds(420,200,800,600);
		background.add(form);
		form_title=new JLabel("RETURN CAR");
		form_title.setBounds(300,5,400,100);
		form.add(form_title);
		form_title.setFont(f1);
		form_title.setForeground(Color.BLUE);
		 
 
         
        b1.addActionListener(this);
        b2.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);


		//THIS BUTTON ARE NOT ADDED ON heading
        b1.setBounds(50, 110, 250, 60);
		b5.setBounds(50, 300, 250, 60);
        b6.setBounds(50, 400, 250, 60);
        b9.setBounds(50, 500, 250, 60);
        b8.setBounds(50, 600, 250, 60);
        b7.setBounds(50, 700, 250, 60);

         
         
        heading.setBackground(new Color(50,30,0,20));
        heading.setBounds(0,100, 330, 1000);
		heading.setLayout(null);
        background.add(heading);
		
		 Font f7=new Font("serif",Font.BOLD,60);
		 
		heading1.setBackground(new Color(50,30,0,30));
		heading1.setBounds(0,0,1600,100);
		background.add(heading1);
		name=new JLabel("Car Rental System");
		name.setBounds(180,100,500,100);
		name.setFont(f7);
		heading1.add(name);
		name.setForeground(Color.ORANGE);
		
		 
		 
		/*heading2.setLayout(null);
		heading2.setBackground(new Color(50,50,0,30));
		heading2.setBounds(350,110,1155,80);
		background.add(heading2);*/
		
		
		
		 
		 Font f11=new Font("serif",Font.BOLD,25);
		add.setFont(f11);
		add.setBounds(360,127,170,50);
		 
		 
		remove.setBounds(550,127,200,50);
		remove.setFont(f11);
		 
		
		 
		update.setBounds(770,127,200,50);
		update.setFont(f11);
		 
		 
		return_car.setBounds(990,127,200,50);
		return_car.setFont(f11);
		 
		
		 
		search.setBounds(1210,127,200,50);
		search.setFont(f11);
		 
		
		
		
		
		

        addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		 
		 
		 b1.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				new AllOperation();
			 }
		 });
		 
		 b2.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				 new carsection2();
				 
			 }
		 });
		 
		  
		 
		 remove.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				 new remove();
			 }
			 
		 });
		 
		  add.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				 new add2();
			 }
			 
		 });
		 
		 
		 update.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				 new update();
			 }
			 
		 });
		 
		  search.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				 new search();
			 }
			 
		 });
		 
		  return_car.addMouseListener(new MouseAdapter()
		 {
			 public void mouseClicked(MouseEvent m)
			 {
				 new return_car();
			 }
			 
		 });
		 
		 
		try {
				cn = DriverManager.getConnection("jdbc:mysql://localhost:12407/project", "root", "root");
				stmt = cn.createStatement();
			}
		catch (Exception e) {
        // Handle the exception  
			JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();  
			return; 
			}
	
	
	
				 
		
		
        setVisible(true);
    }

  	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b11)
		{
			if(t1.getText().length()>0 && t2.getText().length()>0 && t3.getText().length()>0 && t4.getText().length()>0 && t5.getText().length()>0 && t6.getText().length()>0 && t7.getText().length()>0&& calb.getText().length()>0 && calb2.getText().length()>0)
				{
					try{
						sql="delete from rent where CAR_NO='"+t1.getText()+"'"; 
						prstm=cn.prepareStatement(sql);
						prstm.execute();
						 
						}
					catch(Exception e1)
					{
							System.out.println(e1);
					}
				}
				else
				{
					 
						JOptionPane.showMessageDialog(this,"Enter all information of car");
					 
				}
				
				try{
					
					sql="insert into earning values('"+t1.getText()+"',"+t7.getText()+","+t2.getText()+","+t10.getText()+",'"+calb.getText()+"','"+calb2.getText()+"',"+t11.getText()+")";					 
								prstm=cn.prepareStatement(sql);
								prstm.execute();
								JOptionPane.showMessageDialog(null,"CAR RETURN SUCESSFULLY");
								
							
							 
							 
				}catch(Exception e2)
				{
					System.out.println(e2);
				}
			
		}
		
		if (e.getSource() == GO) {
        

			try {
				prstm = cn.prepareStatement("select rent.CUS_ID,rent.CUS_NAME, rent.ADDRESS,rent.CUS_PNUM,rent.CUS_EMAIL, rent.rent_id,rent.rent_date,rent.return_date,car.PD_PRICE,car.CAR_ADV from rent,car where rent.CAR_NO='" + t1.getText() + "'");

				rs = prstm.executeQuery();
            if (rs.next()) {
                t2.setText(rs.getString(1));
                t3.setText(rs.getString(2));
                t4.setText(rs.getString(3));
                t5.setText(rs.getString(4));
                t6.setText(rs.getString(5));
                t7.setText(rs.getString(6));
                calb.setText(rs.getString(7));
                calb2.setText(rs.getString(8));
                t10.setText(rs.getString(9));
				t12.setText(rs.getString(10));

                String rentDateStr = calb.getText();
                String returnDateStr = calb2.getText();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date rentDate = dateFormat.parse(rentDateStr);
                Date returnDate = dateFormat.parse(returnDateStr);

                // Calculate total days rented
                LocalDate rentDate1 = LocalDate.parse(rentDateStr);
                LocalDate returnDate2 = LocalDate.parse(returnDateStr);
                long totalDays = ChronoUnit.DAYS.between(rentDate1, returnDate2);

                int totalPrice = (int) totalDays * Integer.parseInt(t10.getText());
				int totalpriceafteradvance=totalPrice-Integer.parseInt(t12.getText());
                t11.setText(String.valueOf(totalpriceafteradvance)); // Display total price
            } else {
                JOptionPane.showMessageDialog(this, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e4) {
            JOptionPane.showMessageDialog(this, "Error retrieving record: " + e4.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e4.printStackTrace();
			}
		}
	}
		  
 
    public static void main(String args[]) {
        new return_car();
    }
}
