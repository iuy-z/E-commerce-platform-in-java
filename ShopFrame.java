import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ShopFrame extends JFrame{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JPanel j1,j2;
    public Customer c;

    public ShopFrame(){
          
        setLayout(new BorderLayout()); 
        setSize(400,400);
        setVisible(true);

        j1= new JPanel();
        j2= new JPanel();

        j1.setLayout(new GridLayout(4,1));
        j2.setLayout(new FlowLayout());

        b1= new JButton("My Account");   ///
        b2= new JButton("View Product"); ///
        b3= new JButton("Add Product to Cart");  ///
        b4 = new JButton("Search Product"); ///
        b7 = new JButton("Buy");
        b8 = new JButton("Remove Product from Cart");
        b9 = new JButton("View Cart"); /// 
        b5 = new JButton("Cancel"); ///
        b6= new JButton("Home");   ///

        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
        j1.add(b4);
        j1.add(b7);
        j1.add(b8);
        j1.add(b9);

        j2.add(b5);
        j2.add(b6);

        add(j1,BorderLayout.CENTER);
        add(j2,BorderLayout.SOUTH);

        MyActionListner a = new MyActionListner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        b7.addActionListener(a);
        b8.addActionListener(a);
        b9.addActionListener(a);

    }

    public class MyActionListner implements ActionListener{

        ArrayList<Customer> list = new ArrayList<Customer>();

        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("My Account")){
                dispose();
                new MyAccount();

            }
            else if(ae.getActionCommand().equals("View Product")){
                dispose();
                new DisplayProductFrame();

                
            }
            else if(ae.getActionCommand().equals("Add Product to Cart")){
                dispose();
                new AddProductToCartFrame();

                
            }
            else if(ae.getActionCommand().equals("Search Product")){
                dispose();
                new SearchProductFrame();
               
            }
            else if(ae.getActionCommand().equals("Buy")){
                dispose();
                new BuyFrame();
                 
            }
            else if(ae.getActionCommand().equals("Remove Product from Cart")){
                dispose();
                new RemoveProductsFromCartFrame();
                 
            }
            else if(ae.getActionCommand().equals("View Cart")){
                dispose();
                new ViewCartFrame();
            }
            

            else if(ae.getActionCommand().equals("Cancel")){
                System.exit(0);
                
            }
            else if(ae.getActionCommand().equals("Home")){
                dispose();
                Home h1 = new Home();
            }

        }

    }
}