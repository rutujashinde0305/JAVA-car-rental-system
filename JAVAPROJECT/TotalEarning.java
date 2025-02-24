import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.text.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class TotalEarning extends JFrame implements ActionListener {

    Connection cn;
    Statement stm;
    ResultSet rs;

    JTable table;
    JLabel totalEarningsLabel;
    JButton print;
    DateButton calb, calb2;
    int totalPrice, totalPriceAfterAdvance;

    String colHeads[] = {"Rent ID", "Customer ID", "PD_PRICE", "Rent Date", "Return Date", "CAR Advance", "Total Price"};
    Object Data[][];
    int cnt = 0, i;
    int totalEarnings = 0;
    JButton b1;

    TotalEarning() {
        setTitle("Total Earnings");

        setSize(820, 500);
        setLocation(560, 220);

        JLabel label1 = new JLabel("Payement RECIEPT FROM:");
        label1.setBounds(20, 10, 160, 30);
        add(label1);

        JLabel label2 = new JLabel("TO:");
        label2.setBounds(320, 10, 100, 30);
        add(label2);

        print = new JButton("PRINT");
        add(print);
        print.setBounds(630, 10, 100, 30);
        print.addActionListener(this);

        b1 = new JButton("SEARCH");
        add(b1);
        b1.setBounds(500, 10, 100, 30);
        b1.addActionListener(this);

        // Text Fields
        calb = new DateButton();
        add(calb);
        calb.setBounds(200, 10, 100, 30);

        calb2 = new DateButton();
        add(calb2);
        calb2.setBounds(370, 10, 100, 30);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        totalEarningsLabel = new JLabel("Total Earnings: " + totalEarnings);
        totalEarningsLabel.setBounds(100, 360, 300, 100);
        add(totalEarningsLabel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                cn = DriverManager.getConnection("jdbc:mysql://Localhost:12407/project", "root", "root");
                stm = cn.createStatement();

                String startDateStr = calb.getText();
                String endDateStr = calb2.getText();

                String query = "SELECT earning.rent_ID, earning.CUS_ID, car.PD_PRICE, earning.rent_date, earning.return_date, car.CAR_ADV " +
                               "FROM earning INNER JOIN car ON earning.CAR_NO = car.CAR_NO " +
                               "WHERE earning.rent_date >= ? AND earning.return_date <= ?";

                PreparedStatement stmt = cn.prepareStatement(query);
                stmt.setString(1, startDateStr);
                stmt.setString(2, endDateStr);
                rs = stmt.executeQuery();
                rs.last();
                cnt = rs.getRow();
                rs.beforeFirst();

                Data = new Object[cnt][7];

                i = 0;
                while (rs.next()) {
                    int rentID = rs.getInt("rent_ID");
                    int cusID = rs.getInt("CUS_ID");
                    int PD_PRICE = rs.getInt("PD_PRICE");
                    String rentDateStr = rs.getString("rent_date");
                    String returnDateStr = rs.getString("return_date");
                    int CAR_ADV = rs.getInt("CAR_ADV");

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date rentDate = dateFormat.parse(rentDateStr);
                    Date returnDate = dateFormat.parse(returnDateStr);

                    LocalDate rentDate1 = LocalDate.parse(rentDateStr);
                    LocalDate returnDate2 = LocalDate.parse(returnDateStr);

                    long totalDays = ChronoUnit.DAYS.between(rentDate1, returnDate2);

                    PreparedStatement ps = cn.prepareStatement("SELECT PD_PRICE FROM car WHERE CAR_NO = ?");
                    ps.setString(1, getCarNo(rentID));
                    ResultSet carRs = ps.executeQuery();
                    carRs.next();
                    int pricePerDay = carRs.getInt("PD_PRICE");

                    totalPrice = (int) totalDays * pricePerDay;
                    totalPriceAfterAdvance = totalPrice - CAR_ADV;

                    Data[i][0] = rentID;
                    Data[i][1] = cusID;
                    Data[i][2] = PD_PRICE;
                    Data[i][3] = rentDateStr;
                    Data[i][4] = returnDateStr;
                    Data[i][5] = CAR_ADV;
                    Data[i][6] = totalPriceAfterAdvance;

                    i++;

                    ps.close();
                    carRs.close();

                    totalEarnings += totalPriceAfterAdvance;
                }

                table = new JTable(Data, colHeads);
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(20, 50, 760, 350);

                totalEarningsLabel.setText("Total Earnings: " + totalEarnings);
                totalEarnings = 0;
                add(jsp);
                setLayout(null);

            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

        if (e.getSource() == print) {
            try {
                MessageFormat header = new MessageFormat("JTable Report Print");
                MessageFormat footer = new MessageFormat("Page {0,number,integer}");
                table.print(JTable.PrintMode.NORMAL, header, footer);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }

    private String getCarNo(int rentID) throws SQLException {
        String carNo = null;
        PreparedStatement ps = cn.prepareStatement("SELECT CAR_NO FROM earning WHERE rent_ID = ?");
        ps.setInt(1, rentID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            carNo = rs.getString("CAR_NO");
        }
        rs.close();
        ps.close();
        return carNo;
    }

    public static void main(String args[]) {
        new TotalEarning();
    }
}
