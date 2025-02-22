import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DeleteCustomerFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l1;
    JTextField j1;
    JPanel p1,p2;


    DeleteCustomerFrame(){
        setTitle("Delete Customer Frame");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();

        l1 = new JLabel("UserName");
        j1 = new JTextField();
        b1 = new JButton("Delete");
        b2 = new JButton("Cancel");
        b3 = new JButton("Home");

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

            if(ae.getActionCommand().equals("Delete")){
                Customer.deleteCustomerFromFile(j1.getText());
                JOptionPane.showMessageDialog(new Frame(),"Deleted!");
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
