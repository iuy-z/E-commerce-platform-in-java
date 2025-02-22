import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CustomerFrame extends JFrame{
    JButton b1,b2,b3,b5,b6;
    JPanel j1,j2;

    public CustomerFrame(){

        setLayout(new BorderLayout()); 
        setSize(400,400);
        setVisible(true);

        j1= new JPanel();
        j2= new JPanel();

        j1.setLayout(new GridLayout(4,1));
        j2.setLayout(new FlowLayout());

        b1= new JButton("Login");
        b2= new JButton("Register Account");
        b3= new JButton("Delete Account");
        b5 = new JButton("Cancel");
        b6= new JButton("Home");

        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
       

        j2.add(b5);
        j2.add(b6);

        add(j1,BorderLayout.NORTH);
        add(j2,BorderLayout.SOUTH);

        MyActionListner a = new MyActionListner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        
        b5.addActionListener(a);
        b6.addActionListener(a);

    }

    public class MyActionListner implements ActionListener{
    
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("Login")){
                dispose();
                new LoginCustomerFrame();
            }
            else if(ae.getActionCommand().equals("Register Account")){
                dispose();
                new RegisterCustomerFrame();
            }
            else if(ae.getActionCommand().equals("Delete Account")){
                dispose();
                new DeleteCustomerFrame();
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