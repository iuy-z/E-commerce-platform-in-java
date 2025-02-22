import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyAccount extends JFrame{
    JButton b1,b2,b3,b4,b5,b6;
    JPanel j1,j2;

    public MyAccount(){

        setLayout(new BorderLayout()); 
        setSize(400,400);
        setVisible(true);

        j1= new JPanel();
        j2= new JPanel();

        j1.setLayout(new GridLayout(4,1));
        j2.setLayout(new FlowLayout());

        b1= new JButton("Display Information");
        b2= new JButton("Change Username");
        b3= new JButton("Change Password");
        b4 = new JButton("Membership");
        b5 = new JButton("Cancel");
        b6= new JButton("Customer Home Page");

        j1.add(b1);
        j1.add(b2);
        j1.add(b3);
        j1.add(b4);

        j2.add(b5);
        j2.add(b6);

        add(j1,BorderLayout.NORTH);
        add(j2,BorderLayout.SOUTH);

        MyActionListner a = new MyActionListner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);

    }

    public class MyActionListner implements ActionListener{
    
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("Display Information")){
                dispose();
               new displayMyAccountinfoFrame();
                

            }
            else if(ae.getActionCommand().equals("Change Username")){
                dispose();
                new ChangeUsernameFrame();
                
                
            }
            else if(ae.getActionCommand().equals("Change Password")){
                dispose();
                new ChangePasswordFrame();
                
                
            }
            else if(ae.getActionCommand().equals("Membership")){
                dispose();
                new MembershipFrame();
            }
            else if(ae.getActionCommand().equals("Cancel")){
                System.exit(0);
                
            }
            else if(ae.getActionCommand().equals("Customer Home Page")){
                dispose();
                new ShopFrame();
            }

        }

    }
}