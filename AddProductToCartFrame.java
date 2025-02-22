import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AddProductToCartFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l1,l2;
    JTextField j1,j2;
    JPanel p1,p2;


    AddProductToCartFrame(){
        setTitle("ADD Product to Cart");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();

        l1 = new JLabel("Enter Id");
        j1 = new JTextField();
        l2 = new JLabel("Enter Username");
        j2 = new JTextField();
        b1 = new JButton("ADD");
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

            ArrayList<Customer> list = Customer.ReadCustomersFromFile();

            boolean flag = false;
            if(ae.getActionCommand().equals("ADD")){

                flag =Product.SearchProductFromFile(Integer.parseInt(j1.getText()));
                Product p = Product.ReturnProductFromFile(Integer.parseInt(j1.getText()));
                
                if(flag == true ){
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getUsername().equals(j2.getText())){
                            Customer.addProductToCustomerCart(p,j2.getText());
                            //JOptionPane.showMessageDialog(new Frame(),"Product loop "+(i+1));
                        }
                    }
                    JOptionPane.showMessageDialog(new Frame(),"Product Found!");
                    JOptionPane.showMessageDialog(new Frame(),"Product Has Been Added to Cart!");
                }
                else {
                       JOptionPane.showMessageDialog(new Frame(),"Product NOT Found!");
                }
                
               
                
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
