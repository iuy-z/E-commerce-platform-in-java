import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class displayMyAccountinfoFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l1;
    JTextField j1;
    JPanel p1,p2;


    displayMyAccountinfoFrame(){
        setTitle("Display User Info");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();

        l1 = new JLabel("Enter Username");
        j1 = new JTextField();
        b1 = new JButton("Display");
        b2 = new JButton("Cancel");
        b3 = new JButton("Customer Home Page");

        p1.add(l1);
        p1.add(j1);
       
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

            ArrayList<Customer> loginlist = Customer.ReadCustomersFromFile();
           
            if(ae.getActionCommand().equals("Display")){

                    for ( int i=0; i < loginlist.size();i++){
                        if(loginlist.get(i).getUsername().equals(j1.getText())){
                        JOptionPane.showMessageDialog(null,"Name: "+loginlist.get(i).getName()+ "\n Email: "+loginlist.get(i).getEmail()+"\nUsername :"
                        +loginlist.get(i).getUsername()+"\nPassword: "
                        +loginlist.get(i).getPassword()
                        +"\nMembership :"+loginlist.get(i).getmembership());
                        break;
                        }
                    }
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
