import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;

class login extends JFrame implements ActionListener {

    JLabel background, form_title, name, l1, l2, pname, Rname, RnameUpper, heading;
    JButton b1;
    JTextField t1;
    JPasswordField t2;
    Connection cn;
    Statement stm;
    ResultSet rs;
    PreparedStatement prstm;
    String sql;

    login()
	{
        setSize(1700, 1800);
        setLocation(0,0);
        setTitle("Login");
        setLayout(null);
        setFont(new Font("Arial", Font.PLAIN, 60));

        l1 = new JLabel("Username :");
        l2 = new JLabel("Password :");
        pname = new JLabel("<html><b><i>Welcome To Rutuja And Pratiksha</i></b><br><br>");
        Rname = new JLabel("<html><b><i>Car Renting System </i></b></html>");
        pname.setBounds(180,290,1000,200);
        Rname.setBounds(280,330,1000,200);
        pname.setForeground(new Color(128, 0, 128));
        Rname.setForeground(Color.RED);

        Font pnameFont = new Font("Arial",Font.BOLD,40);
        pname.setFont(pnameFont);
        Rname.setFont(pnameFont);

        t1 = new JTextField(20);
        t2 = new JPasswordField(20);

        Font labelFont = new Font("Arial",Font.BOLD,18);

        l1.setFont(labelFont);
        l2.setFont(labelFont);

        add(l1);
        add(l2);

        l1.setBounds(100, 120, 140, 30);
        t1.setBounds(200, 120, 150, 30);
        l2.setBounds(100, 170, 140, 30);
        t2.setBounds(200, 170, 150, 30);

        ImageIcon img = new ImageIcon("mainbackground.png");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1540, 800);
        add(background);

        background.add(pname);
        background.add(Rname);

        b1 = new JButton("LOGIN");
        b1.addActionListener(this);
        b1.setBounds(150,260, 130,40);
        b1.setBackground(new Color(0, 128, 0)); // Blue background
        b1.setForeground(Color.WHITE); // White text color
        b1.setFocusPainted(false); 

        Font f1 = new Font("serif", Font.BOLD, 30);
        JPanel form = new JPanel();
        form.setLayout(null);

        form.setBackground(new Color(220, 220, 220)); // Light gray background
        form.setBounds(1000,250,450, 350);
        background.add(form);
        form.add(l1);
        form.add(t1);
        form.add(l2);
        form.add(t2);
        form.add(b1);
        form_title = new JLabel("LOGIN HERE");
        form_title.setBounds(140, 5, 400, 100);
        form.add(form_title);
        form_title.setFont(f1);
        form_title.setForeground(Color.BLACK);

        // Adding the new heading "Car Renting System" in the upper part and center
        heading = new JLabel("<html><b>Car Renting System</b></html>");
        heading.setBounds(450, 0, 850, 200);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Serif", Font.BOLD, 75)); // Larger font size
        background.add(heading);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
        String username = t1.getText();
        String password = t2.getText();

        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:12407/project", "root", "root");

            String query = "SELECT * FROM login WHERE username=? AND password=?";
            PreparedStatement statement = cn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new AllOperation();
                this.dispose();  // Close the current login frame
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter Correct username or password!");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    public static void main(String args[])
	{
        new login();
    }
}