import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;

class search extends JFrame implements ActionListener,ItemListener{

    
	JButton b1,b2,b5, b6, b7, b8, b9, searchButton,availableButton,notAvailableButton ,remove,add,update,return_car,search,search2;
	 JLabel background,name,modelLabel,searchbrand;
	 JTextField searchField;
	 JComboBox<String> bf;
	 

    Connection cn;
    Statement stm;
    ResultSet rs;
    PreparedStatement prstm;
    String sql;

    search() {
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
return_car.setBackground(new Color(0,0,0,0));
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
//search.setBackground(new Color(0,0,0,0));
search.setForeground(Color.YELLOW);
add(search);

 
 
         
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

        ImageIcon img = new ImageIcon("mainbackground.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1540, 800);
        add(background);

        Font f = new Font("serif", Font.BOLD, 60);
        
        heading.setBackground(new Color(50,30,0,20));
        heading.setBounds(0,100, 330, 1000);
		heading.setLayout(null);
        background.add(heading);
		
		 Font f1=new Font("serif",Font.BOLD,60);
		 
		heading1.setBackground(new Color(50,30,0,30));
		heading1.setBounds(0,0,1600,100);
		background.add(heading1);
		name=new JLabel("Car Rental System");
		name.setBounds(180,100,500,100);
		name.setFont(f1);
		heading1.add(name);
		name.setForeground(Color.ORANGE);
		
		 
		 
		/*heading2.setLayout(null);
		heading2.setBackground(new Color(50,50,0,30));
		heading2.setBounds(350,110,1155,80);
		background.add(heading2);*/
		
		
		
		 
		 Font f11=new Font("serif",Font.BOLD,25);
		add.setFont(f11);
		add.setBounds(360,127,170,50);
		 
		remove.setFont(f11);
		remove.setBounds(550,127,200,50);
		 
		
		 
		update.setBounds(770,127,200,50);
		update.setFont(f11);
		 
		 
		return_car.setBounds(990,127,200,50);
		return_car.setFont(f11);
		 
		
		 
		search.setBounds(1210,127,200,50);
		search.setFont(f11);
		 
		 search2=new JButton("SEARCH");
			background.add(search2);
			 search2.addActionListener(this);
			 search2.setBounds(770,290,102,30);
			 search2.setBackground(Color.PINK);
			 search2.setForeground(Color.BLACK);
			 
			 
	 	searchbrand=new JLabel("Enter Car Brand");
		searchbrand.setBounds(550,250,400,100);
		background.add(searchbrand);
		
		bf = new JComboBox<>(new String[]{"BMW","HYUNDAI","AUDI","FERRARI"});
		 bf.setBounds(650,290,100,30);
		 background.add(bf);
		 
		  availableButton = new JButton("Available");
		availableButton.setBounds(890,290,100,30);
		availableButton.setBackground(new Color(124,252,0));
		availableButton.setEnabled(false);
		 
		availableButton.setForeground(Color.BLACK);
		background.add(availableButton);
		
		
        notAvailableButton = new JButton("Not Available");
		notAvailableButton.setBounds(1010,290,120,30);
		 
		notAvailableButton.setEnabled(false);
		notAvailableButton.setBackground(Color.RED);
 		background.add(notAvailableButton);
		notAvailableButton.setForeground(Color.BLACK);
		
		
		
		
		 
		 
		 modelLabel=new JLabel("Enter the car number you want to give on rent : ");
		modelLabel.setBounds(360,300,400,100);
		background.add(modelLabel);
		
		searchField = new JTextField();
		 searchField.setBounds(650,335,100,30);
		 background.add(searchField);
		 
		 
		searchButton = new JButton("NEXT");
		searchButton.setBounds(770,335,100,30);
		background.add(searchButton);
		searchButton.setBackground(Color.PINK);
			 searchButton.setForeground(Color.BLACK);
			 
        
		

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
		 
		 
		
			try
		{
 		cn=DriverManager.getConnection("jdbc:mysql://localhost:12407/project","root","root");

		 
		}
		catch(Exception eee)
		{
			System.out.println(eee);
			
		}
		setVisible(true);
		 
	 search2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carNo = searchField.getText();
                boolean found = searchCar(carNo);
				if(found==true)
				{
                availableButton.setEnabled(true);
				notAvailableButton.setEnabled(false);
				searchButton.setEnabled(true);
				}
				else
				{
				notAvailableButton.setEnabled(true);
				searchButton.setEnabled(false);
				availableButton.setEnabled(false);
				}
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				
				new rentmain(searchField.getText());
               // String carNo = searchField.getText();
               // displayCarDetails(carNo);
            }
        });
	
	 
		
		
		
        setVisible(true);
    }

  private boolean searchCar(String carNo)
	 {
		 
         
         try {
				  cn = DriverManager.getConnection("jdbc:mysql://localhost:12407/project", "root", "root");
				//String query = "SELECT * FROM CAR WHERE CAR_NO = ?";
				
				
				//String query="SELECT * FROM CAR LEFT JOIN rent ON CAR.CAR_NO = rent.CAR_NO WHERE rent.CAR_NO IS NULL";
				//String query="SELECT * FROM CAR LEFT JOIN rent ON CAR.CAR_NO = rent.CAR_NO WHERE rent.rent_ID IS NULL";
				String query = "SELECT * FROM CAR LEFT JOIN rent ON CAR.CAR_NO = rent.CAR_NO WHERE rent.rent_ID IS NULL AND CAR_BRAND = ?";
				PreparedStatement pstmt = cn.prepareStatement(query);
				pstmt.setString(1, (String) bf.getSelectedItem()); // Set the parameter value
				ResultSet rs = pstmt.executeQuery();
				
				 
				/**PreparedStatement pstmt = cn.prepareStatement(query);
				pstmt.setString(1, carNo);
				ResultSet rs = pstmt.executeQuery();**/
				if (rs.next())
					{
						return true; // Car found
					}
				else {
					return false; // Car not found
					}
			} catch (SQLException e) {
            e.printStackTrace();
            return false; // Error occurred
        }
    }
	
	
	public void display()
	{
		
	JTable table;
     String Data[][];
    int cnt = 0, i=0;

     
        try {
            cn = DriverManager.getConnection("jdbc:mysql://Localhost:12407/project", "root", "root");
            stm = cn.createStatement();

            rs = stm.executeQuery("SELECT COUNT(*) FROM CAR");
            rs.next();
            int totalCars = rs.getInt(1);

            // Count rented cars
            rs = stm.executeQuery("SELECT COUNT(*) FROM rent");
            rs.next();
            int rentedCars = rs.getInt(1);

            cnt = totalCars - rentedCars;

            Data = new String[cnt][7];
			rs.beforeFirst();
            rs = stm.executeQuery("SELECT * FROM CAR LEFT JOIN rent ON CAR.CAR_NO = rent.CAR_NO WHERE rent.rent_ID IS NULL AND CAR_BRAND='"+bf.getSelectedItem()+"'");
			 
			if(rs.next())
			{
					rs.beforeFirst();
					String colHeads[] = {"CAR_NO", "CAR_PRICE", "FUEL_TYPE", "PD_PRICE", "SEATS", "CAR_BRAND", "CAR_COLOR"};

 			while (rs.next()) {
                Data[i][0] = rs.getString("CAR_NO");
                Data[i][1] = rs.getString("CAR_PRICE");
                Data[i][2] = rs.getString("FUEL_TYPE");
                Data[i][3] = rs.getString("PD_PRICE");
                Data[i][4] = rs.getString("SEATS");
                Data[i][5] = rs.getString("CAR_BRAND");
                Data[i][6] = rs.getString("CAR_COLOR");
                i++;
            }
			table = new JTable(Data, colHeads);
			}
			
			else
			{
				
				String colHeads[] = {"CAR_NO", "CUS_ID", "CUS_NAME", "CUS_PNUM", "CUS_EMAIL","rent_date", "return_date"};
				//rs=stm.executeQuery("select CAR_NO,CUS_ID,CUS_NAME,CUS_PNUM,CUS_EMAIL,rent_date,return_date from RENT where car.CAR_BRAND='"+bf.getText()+"'");
				rs=stm.executeQuery("SELECT car.CAR_NO, rent.CUS_ID, rent.CUS_NAME, rent.CUS_PNUM, rent.CUS_EMAIL, rent.rent_date, rent.return_date FROM car JOIN rent ON car.CAR_NO = rent.CAR_NO WHERE car.CAR_BRAND = '"+bf.getSelectedItem()+"'");
				for(int x=0;x<1;x++)
				{
					rs.beforeFirst();
					while(rs.next())
					{
					Data[i][0]=rs.getString(1);
					Data[i][1]=rs.getString(2);
					Data[i][2]=rs.getString(3);
					Data[i][3]=rs.getString(4);
					Data[i][4]=rs.getString(5);
					Data[i][5]=rs.getString(6);
					Data[i][6]=rs.getString(7);
					i++;
					}
				}
				
				table = new JTable(Data, colHeads);
			}
			
		 
			
             
            table.setEnabled(false);
            JScrollPane jsp = new JScrollPane(table);
            add(jsp);
			jsp.setBounds(500,400,570,200);
	}
        catch (Exception ee)
		{
            ee.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	 
	 
	public void itemStateChanged(ItemEvent ee)
	{
		System.out.println(ee);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==search2)
		{
			String carBrand=(String) bf.getSelectedItem();
			display();
		}
		 
		 
		
	}

    public static void main(String args[]) {
        new search();
    }
}
