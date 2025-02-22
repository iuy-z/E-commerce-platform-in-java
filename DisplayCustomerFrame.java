import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DisplayCustomerFrame extends JFrame{

    JButton b1,b2;

    DisplayCustomerFrame(){
        setTitle("Display Customer Informfation Frame");
        setLayout(new GridLayout(1,2));
        setSize(400,400);
        setVisible(true);

        b1 = new JButton("Display customers Information");
        b2 = new JButton("Admin Home Page");
        add(b1);
        add(b2);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);




    }

    public class MyActionListener implements ActionListener{

        public void actionPerformed(ActionEvent ae){

            ArrayList<Customer> list = Customer.ReadCustomersFromFile();

            if(ae.getActionCommand().equals("Display customers Information")){
                
                JOptionPane.showMessageDialog(null,"DATA");
                for ( int i=0; i < list.size();i++){
                JOptionPane.showMessageDialog(null,"Name: "+list.get(i).getName()+ "\nEmail: "+list.get(i).getEmail()+"\nUsername:"+list.get(i).getUsername()+"\nPassword: "+list.get(i).getPassword()+"\n Membership :"+list.get(i).getmembership());

                }
            }

            else if (ae.getActionCommand().equals("Admin Home Page")){
                dispose();
                new AdminFrame();
            }
        }
    }
}