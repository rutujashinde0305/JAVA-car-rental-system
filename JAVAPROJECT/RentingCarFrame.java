import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;

class RentingCarFrame extends JFrame implements ActionListener {
    Connection cn;
    Statement stm;
    ResultSet rs;
    JTable table;
	JButton button;
    String colHeads[]={"CUS_ID","CUS_NAME","CAR_NO","rent_ID","rent_date","return_date"};
    String Data[][];
    int cnt=0,i;

    RentingCarFrame() {
        setTitle("Renting car details");
        setSize(700,500);
        setLocation(560,220);
        getContentPane().setLayout(null); // Set layout to null for absolute positioning

        try {
            cn=DriverManager.getConnection("jdbc:mysql://Localhost:12407/project","root","root");
            stm=cn.createStatement();

            rs=stm.executeQuery("select count(*) from rent");
            rs.next();
            cnt=rs.getInt(1);

            Data=new String[cnt][6];
            rs=stm.executeQuery("select CUS_ID,CUS_NAME,CAR_NO,rent_ID,rent_date,return_date FROM rent");
            for(int x=0;x<1;x++) {
                rs.beforeFirst();
                while(rs.next()) {
                    Data[i][0]=rs.getString(1);
                    Data[i][1]=rs.getString(2);
                    Data[i][2]=rs.getString(3);
                    Data[i][3]=rs.getString(4);
                    Data[i][4]=rs.getString(5);
                    Data[i][5]=rs.getString(6);
                    i++;
                }
            }

            table=new JTable(Data,colHeads);
            table.setEnabled(false);

            // Set background color for the entire frame
            //getContentPane().setBackground(Color.YELLOW);

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

        } catch(Exception ee) {
            ee.printStackTrace();    
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the visibility after setting the background color
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
        new RentingCarFrame();
    }
}
