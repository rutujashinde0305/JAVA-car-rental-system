import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSelectorExample extends JFrame {
    private JTextField dateTextField;

    public DateSelectorExample() {
        setTitle("Date Selector Example");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Selected Date:");
        dateTextField = new JTextField(15);
        dateTextField.setEditable(false);

        JButton selectDateButton = new JButton("Select Date");
        selectDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display date picker dialog
                JDatePicker datePicker = new JDatePicker();
                int option = JOptionPane.showConfirmDialog(null, datePicker, "Select Date", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    // Get selected date from date picker
                    Date selectedDate = datePicker.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    dateTextField.setText(sdf.format(selectedDate));
                }
            }
        });

        panel.add(label, BorderLayout.WEST);
        panel.add(dateTextField, BorderLayout.CENTER);
        panel.add(selectDateButton, BorderLayout.EAST);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DateSelectorExample();
            }
        });
    }
}