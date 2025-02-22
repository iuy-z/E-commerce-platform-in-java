import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame {
    JLabel usernameLabel, passwordLabel;
    JTextField usernameField, passwordField;
    JButton submitButton, exitButton;

    public AdminLoginFrame() {
        setTitle("Admin Login Page");
        setLayout(new GridLayout(5, 2));
        setSize(400, 400);
        setVisible(true);

        usernameLabel = new JLabel("Username ");
        passwordLabel = new JLabel("Password ");

        usernameField = new JTextField();
        passwordField = new JTextField();

        submitButton = new JButton("Submit");
        exitButton = new JButton("Exit");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);

        add(submitButton);
        add(exitButton);

        MyActionListener listener = new MyActionListener();
        submitButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == submitButton) {
                if (loginCheck()) {
                    JOptionPane.showMessageDialog(new Frame(), "Successfully Logged in!");
                    dispose();
                    new AdminFrame();
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "Wrong Username or Password");
                }
            } else if (ae.getSource() == exitButton) {
                System.exit(0);
            }
        }
    }

    public boolean loginCheck() {
        return usernameField.getText().equals("irem") && passwordField.getText().equals("password");
    }
}
