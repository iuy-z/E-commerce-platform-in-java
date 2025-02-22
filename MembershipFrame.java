import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MembershipFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l1,l2;
    JTextField j1,j2;
    JPanel p1,p2;


    MembershipFrame(){
        setTitle("Membership Frame");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,2));
        p2 = new JPanel();

        l1 = new JLabel("Enter Name");
        l2 = new JLabel("If u want to get Membership type 'yes' ");
        j1 = new JTextField();
        j2 = new JTextField();
        b1 = new JButton("Get");
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

            if(ae.getActionCommand().equals("Get")){
                for ( int i=0; i < list.size();i++){
                    if(list.get(i).getName().equals(j1.getText())){
                       Customer.UpdateMemberShip(j1.getText(),j2.getText());
                        JOptionPane.showMessageDialog(new Frame(),"Membership Updated!");
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
