import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BuyFrame extends JFrame {

    JButton b1, b2, b3;
    JLabel l2;
    JTextField j2;
    JPanel p1, p2;

    BuyFrame() {
        setTitle("Buy Cart");
        setLayout(new BorderLayout());
        setSize(400, 400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();
        l2 = new JLabel("Enter Username");
        j2 = new JTextField();
        b1 = new JButton("Buy");
        b2 = new JButton("Cancel");
        b3 = new JButton("Customer Home");

        p1.add(l2);
        p1.add(j2);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);

        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 3));

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);

    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            ArrayList<Product> list = Customer.readProductsFromCustomerCart(j2.getText());
            double total = 0;
            int count = 0;

            if (ae.getActionCommand().equals("Buy")) {

                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No products have been added to the cart.");
                    return;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        JOptionPane.showMessageDialog(null, "Product id = " + list.get(i).getId() +
                                "\nProduct Name = " + list.get(i).getName());
                        count++;
                    }
                    total = Customer.buybill(j2.getText());
                    JOptionPane.showMessageDialog(null, "Number of Products =" + count +
                            "\nTotal = " + total);

                    /*for (int i = 0; i < list.size(); i++) {
                        Product.deleteProductFromFile(list.get(i).getId());
                    }*/
                    new CheckoutFrame();
                }
            }

            else if (ae.getActionCommand().equals("Cancel")) {
                System.exit(0);
            } else if (ae.getActionCommand().equals("Customer Home")) {
                dispose();
                ShopFrame h1 = new ShopFrame();
            }
        }
    }
}
