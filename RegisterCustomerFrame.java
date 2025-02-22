import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterCustomerFrame extends JFrame{
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
     
    RegisterCustomerFrame(){
        setTitle("Customer Account Register Page");
        setLayout(new GridLayout(5,2));
        setSize(400,400);
        setVisible(true);
        
        l1= new JLabel("Name");
        l2= new JLabel("Email ");
        l3= new JLabel("Username ");
        l4= new JLabel("Password ");

        t1 = new JTextField();
        t2= new JTextField();
        t3= new JTextField();
        t4 = new JTextField();

        b1 = new JButton("Submit");
        b2= new JButton("Exit");
      

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b1);
        add(b2);
       

        MyActionListner a = new MyActionListner();
        b1.addActionListener(a);
        b2.addActionListener(a);
      

        
    }


    public class MyActionListner implements ActionListener{

       

        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("Submit")){

                String pass =  t4.getText();
                String em = t2.getText();
                
                if(pass.length()>6 && isValidEmail(em)){
                    Customer p = new Customer(t1.getText(),t2.getText(),t3.getText(),t4.getText());
                    p.display();
                    Customer.writeCustomersToFile(p);
                    JOptionPane.showMessageDialog(new Frame(),"YOUR ACCOUNT HAVE BEEN MADE!");
                    dispose();
                    new LoginCustomerFrame();

                }
                else{
                    JOptionPane.showMessageDialog(new Frame(),"Kindly use Strong Password and Valid Email");

                }
            }
            else if(ae.getActionCommand().equals("Exit")){
            System.exit(0);
            }
            
        }
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}