import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ChangePasswordFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l1,l2;
    JTextField j1,j2;
    JPanel p1,p2;


    ChangePasswordFrame(){
        setTitle("Change Password Frame");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();

        l1 = new JLabel("Enter UserName");
        l2 = new JLabel("Enter Password");
        j1 = new JTextField();
        j2 = new JTextField();
        b1 = new JButton("Change");
        b2 = new JButton("Cancel");
        b3 = new JButton("My Account");

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

            if(ae.getActionCommand().equals("Change")){
                for ( int i=0; i < list.size();i++){
                    if(list.get(i).getUsername().equals(j1.getText())){
                        Customer.changePassword(j1.getText(), j2.getText());
                        JOptionPane.showMessageDialog(new Frame(),"Password Updated!");
                    }
                }
                
            }
            else if(ae.getActionCommand().equals("Cancel")){
                System.exit(0);
            }
            else if(ae.getActionCommand().equals("My Account")){
                dispose();
                new MyAccount();
            }
        }
    }
}
