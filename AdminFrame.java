import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminFrame extends JFrame {
    JButton b1, b2, b3, b4, b5, b6, b7,b8;
    JPanel j1, j2;

    public AdminFrame() {
        setTitle("Admin Frame");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        j1 = new JPanel(new GridLayout(5, 1, 5, 5));
        j2 = new JPanel(new FlowLayout());

        b1 = new JButton("Display Product Information");
        b2 = new JButton("Display Users Information");
        b3 = new JButton("Remove Products");
        b4 = new JButton("Add Products");
        b7 = new JButton("Display Orders Details");
        b8 = new JButton("View Product Order Details");
        b5 = new JButton("Cancel");
        b6 = new JButton("Home");

        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
        j1.add(b4);
        j1.add(b7);
        j1.add(b8);

        j2.add(b5);
        j2.add(b6);

        add(j1, BorderLayout.NORTH);
        add(j2, BorderLayout.SOUTH);

        MyActionListner a = new MyActionListner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        b7.addActionListener(a);
        b8.addActionListener(a);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class MyActionListner implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == b1) {
                dispose();
                new DisplayProductFrame();
            } else if (ae.getSource() == b2) {
                dispose();
                new DisplayCustomerFrame();
            } else if (ae.getSource() == b3) {
                dispose();
                new RemoveProductFrame();
            } else if (ae.getSource() == b4) {
                dispose();
                new AddProductFrame();
            } else if (ae.getSource() == b7) {
                dispose();
                new DisplayOrderDetailsFrame();
            } 
            else if (ae.getSource() == b8) {
                dispose();
                new ViewProductsDetails();
            } else if (ae.getSource() == b5) {
                System.exit(0);
            } else if (ae.getSource() == b6) {
                dispose();
                Home h1 = new Home();
            }
        }
    }
}
