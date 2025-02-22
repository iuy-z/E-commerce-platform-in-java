import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ViewProductsDetails extends JFrame{

    JButton b1,b2,b3;
    JLabel l1;
    JTextField j1;
    JPanel p1,p2;


    ViewProductsDetails(){
        setTitle("View Product from Orders Form");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();

        l1 = new JLabel("Enter Id of Product u want checck");
        j1 = new JTextField();
        b1 = new JButton("Search");
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

           ArrayList<Customer> list = Customer.ReadCustomersFromFile();
           
            boolean flag = false;
            if(ae.getActionCommand().equals("Search")){
                flag =Product.SearchProductFromFile(Integer.parseInt(j1.getText()));
                if ( flag == true ){
                    JOptionPane.showMessageDialog(new Frame(),"Product Found in Shop!");
                   
                    for(int i =0;i<list.size();i++){
                        ArrayList<Product> list2 = Customer.readProductsFromCustomerCart(list.get(i).getUsername());
                        
                        for(int j=0;j<list2.size();j++){
                            if(list2.get(j).getId()== Integer.parseInt(j1.getText())){
                                JOptionPane.showMessageDialog(null,"User that have added this product are: :"+
                                "\n"+list.get(i).getUsername());
                            }
                        }
                    }
                    
                }
                else {
                    JOptionPane.showMessageDialog(new Frame(),"Product NOT Found Plz Enter a Valid id!");
                }
                
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
