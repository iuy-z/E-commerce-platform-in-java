import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    JButton adminButton, customerButton, exitButton;

    public Home() {
        setTitle("Home Page");
        setLayout(new GridLayout(3, 1)); // argument no of rows n columns
        setSize(500, 500);
        setExtendedState(JFrame.NORMAL); // Set the initial state directly
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle closing behavior
        setVisible(true);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        adminButton = new JButton("Admin");
        customerButton = new JButton("Customer");
        exitButton = new JButton("Exit");

        mainPanel.add(adminButton);
        mainPanel.add(customerButton);
        mainPanel.add(exitButton);

        add(mainPanel);

        MyActionListener listener = new MyActionListener();
        adminButton.addActionListener(listener);
        customerButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == adminButton) {
                dispose();
                new AdminLoginFrame();
            } else if (ae.getSource() == customerButton) {
                dispose();
                new CustomerFrame();
            } else if (ae.getSource() == exitButton) {
                System.exit(0);
            }
        }
    }
}
