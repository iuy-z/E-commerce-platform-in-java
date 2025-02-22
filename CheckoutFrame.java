import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckoutFrame extends JFrame {
    JLabel nameLabel, emailLabel, phoneLabel, addressLabel, cardNumberLabel;
    JTextField nameTextField, emailTextField, phoneTextField, addressTextField, cardNumberTextField;
    JButton checkoutButton, exitButton;

    CheckoutFrame() {
        setTitle("Check out information Page");
        setLayout(new GridLayout(6, 2));
        setSize(400, 400);
        setVisible(true);

        nameLabel = new JLabel("UserName ");
        emailLabel = new JLabel("Email ");
        phoneLabel = new JLabel("Phone Number ");
        addressLabel = new JLabel("Address ");
        cardNumberLabel = new JLabel("Card Number ");

        nameTextField = new JTextField();
        emailTextField = new JTextField();
        phoneTextField = new JTextField();
        addressTextField = new JTextField();
        cardNumberTextField = new JTextField();

        checkoutButton = new JButton("Check Out");
        exitButton = new JButton("Exit");

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(phoneLabel);
        panel.add(phoneTextField);
        panel.add(addressLabel);
        panel.add(addressTextField);
        panel.add(cardNumberLabel);
        panel.add(cardNumberTextField);
        panel.add(checkoutButton);
        panel.add(exitButton);

        add(panel);

        MyActionListener listener = new MyActionListener();
        checkoutButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }

    public class MyActionListener implements ActionListener {
        ArrayList<Product> list = Customer.readProductsFromCustomerCart(nameTextField.getText());
         double total =0;

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == checkoutButton) {
                total = Customer.buybill(nameTextField.getText());

                persondata p = new persondata(nameTextField.getText(), emailTextField.getText(),
                        phoneTextField.getText(), addressTextField.getText(), cardNumberTextField.getText());
                persondata.writeOrdersToFile(p);
                JOptionPane.showMessageDialog(null, "Your Order Has Been Placed! \n Your Total Bill is " + total);
                JOptionPane.showMessageDialog(null, "Thank You for Shopping with us :)");
                Customer.removeProductFromCustomerCartAfterBuy(nameTextField.getText());
                for (int i = 0; i < list.size(); i++) {
                    Product.deleteProductFromFile(list.get(i).getId());
                }
               

            } else if (ae.getSource() == exitButton) {
                System.exit(0);
            }
        }
    }
}
