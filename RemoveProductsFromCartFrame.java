import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RemoveProductsFromCartFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l1,l2;
    JTextField j1,j2;
    JPanel p1,p2;


    RemoveProductsFromCartFrame(){
        setTitle("Remove Product Frame");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();

        l1 = new JLabel("Enter UserName");
        j1 = new JTextField();
        l2 = new JLabel("Enter Product Id");
        j2 = new JTextField();

        b1 = new JButton("Remove");
        b2 = new JButton("Cancel");
        b3 = new JButton("Customer Home");

        p1.add(l1);
        p1.add(j1);
        p1.add(l2);
        p1.add(j2);
       
        p2.add(b1);  
        p2.add(b2);   
        p2.add(b3);

        p1.setLayout(new GridLayout(1,2));
        p2.setLayout(new GridLayout(1,3));


        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.SOUTH);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);

    }

    public class MyActionListener implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            ArrayList<Product> list = Customer.readProductsFromCustomerCart(j1.getText());
            if(list.isEmpty()){
                JOptionPane.showMessageDialog(null,"No Products in Cart!");
            }

            if(ae.getActionCommand().equals("Remove")){
                Customer.removeProductFromCustomerCart(j1.getText(),Integer.parseInt(j2.getText()));
                JOptionPane.showMessageDialog(new Frame(),"Product Has Been Removed From Cart!");
            }
            else if(ae.getActionCommand().equals("Cancel")){
                System.exit(0);
            }
            else if(ae.getActionCommand().equals("Customer Home")){
                dispose();
                new ShopFrame();
            }
        }
    }
}
