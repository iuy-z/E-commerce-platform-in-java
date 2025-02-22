import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class LoginCustomerFrame extends JFrame{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
     
    LoginCustomerFrame(){
        Customer c = new Customer();
        setTitle("Customer Login Page");
        setLayout(new GridLayout(5,2));
        setSize(400,400);
        setVisible(true);
        
        l1= new JLabel("Username ");
        l2= new JLabel("Password ");
      

        t1 = new JTextField();
        t2 = new JTextField();
       

        b1 = new JButton("Submit");
        b2= new JButton("Exit");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        
        add(b1);
        add(b2);

        MyActionListner a = new MyActionListner();
        b1.addActionListener(a);
        b2.addActionListener(a);


        
    }


    public class MyActionListner implements ActionListener{

       

        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("Submit")){
                if(loginCheck()== true){
                    JOptionPane.showMessageDialog(new Frame(),"Succesfully Logined!");
                    dispose();
                    Customer c= new Customer(Customer.login(t1.getText()));   //method check data 
                    Customer.writeLoginCustomersToFile(c);  //ADDING NEW LOGIN CUSTOMER TO FILE 
                    new ShopFrame();
                }
                else{
                    JOptionPane.showMessageDialog(new Frame(),"Wrong Username or Password");
                }
                
            }
            else if(ae.getActionCommand().equals("Exit"))
            System.exit(0);
        }


    }
        //function to check logiic credidentials from file 
    public boolean loginCheck(){
        ArrayList<Customer> list = Customer.ReadCustomersFromFile();
        boolean flag = false;
        String us = t1.getText();
        String ps = t2.getText();

        for(int i=0;i<list.size();i++){
            if(us.equals(list.get(i).getUsername()) && ps.equals(list.get(i).getPassword())){
                Customer loginCustomer = new Customer();
                loginCustomer.setName(list.get(i).getName());
                loginCustomer.setEmail(list.get(i).getEmail());
                loginCustomer.setUsername(us);
                loginCustomer.setPassword(ps);
            flag = true;
            break;
            }
        }
        return flag;
    }
    
    

}