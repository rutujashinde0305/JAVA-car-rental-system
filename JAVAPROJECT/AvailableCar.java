import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;

class AvailableCar extends JFrame implements ActionListener {

    Connection cn;
    Statement stm;
    ResultSet rs;

    JTable table;

    String colHeads[] = {"CAR_NO", "CAR_PRICE", "FUEL_TYPE", "PD_PRICE", "SEATS", "CAR_BRAND", "CAR_COLOR"};
    String Data[][];
    int cnt = 0, i;
	JButton button;

    AvailableCar() {
        setTitle("Available Car");
         
		setSize(700,500);
        setLocation(560,220);
		 getContentPane().setLayout(null);

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
            rs = stm.executeQuery("SELECT * FROM CAR LEFT JOIN rent ON CAR.CAR_NO = rent.CAR_NO WHERE rent.rent_ID IS NULL");
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
            table.setEnabled(false);
            int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
            int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
            JScrollPane jsp = new JScrollPane(table, v, h);
            jsp.setBounds(10, 10, 680, 400); // Set bounds for JScrollPane

            // Add JScrollPane to the content pane
            getContentPane().add(jsp);
			
			 button = new JButton("PRINT");
            button.setPreferredSize(new Dimension(60, 30)); // Adjust size here
            button.setBounds(10, 420, 100, 30);			// Set bounds for button
			button.addActionListener(this);
            getContentPane().add(button);

        } catch (Exception ee) {
            ee.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button)
		{
			try
				  {   MessageFormat header = new MessageFormat("JTable Report Print");
					  MessageFormat footer = new MessageFormat("Page {0,number,integer}");
					  table.print(JTable.PrintMode.NORMAL, header, footer);
				  }
				  catch(Exception exp)
				  {   exp.printStackTrace();
				  }
		}
	}


    public static void main(String args[]) {
        new AvailableCar();
    }
}