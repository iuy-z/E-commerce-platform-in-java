import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ViewCartFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l2;
    JTextField j2;
    JPanel p1,p2;


    ViewCartFrame(){
        setTitle("Display Cart");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();
        l2 = new JLabel("Enter Username");
        j2 = new JTextField();
        b1 = new JButton("Display");
        b2 = new JButton("Cancel");
        b3 = new JButton("Customer Home");

      
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

            ArrayList<Product> list = Customer.readProductsFromCustomerCart(j2.getText());
       
            if(ae.getActionCommand().equals("Display")){

                if(list.isEmpty()){
                    JOptionPane.showMessageDialog(null,"No Product has been added to Cart! ");
                    return;
                }
    
                for ( int i=0; i <list.size();i++){
                    JOptionPane.showMessageDialog(null,"Id: "+list.get(i).getId()+ 
                    "\n Name: "+list.get(i).getName()+
                    "\nPrice :"+list.get(i).getPrice()+
                    "\nCategory: "+list.get(i).getCategory());
                
                }
                       
                   
            }
            
              
            else if(ae.getActionCommand().equals("Cancel")){
                System.exit(0);
            }
            else if(ae.getActionCommand().equals("Customer Home")){
                dispose();
                ShopFrame h1 = new ShopFrame();
            }
        }
    }
}
