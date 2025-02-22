import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddProductFrame extends JFrame{
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
     
    AddProductFrame(){
        setTitle("Add product Frame");
        setLayout(new GridLayout(5,2));
        setSize(400,400);
        setVisible(true);
        
        l1= new JLabel("Name");
        l2= new JLabel("ID");
        l3= new JLabel("Category");
        l4= new JLabel("Price");

        t1 = new JTextField();
        t2= new JTextField();
        t3= new JTextField();
        t4 = new JTextField();

        b1 = new JButton("Submit");
        b2= new JButton("Admin Home Page");

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

                Product p = new Product();
                p.setName(t1.getText());
                p.setId(Integer.parseInt(t2.getText()));
                p.setCategory(t3.getText());
                p.setPrice(Integer.parseInt(t4.getText()));
            
                Product.writeProductsToFile(p);
                JOptionPane.showMessageDialog(new Frame(),"New Product has been added to shop!");

                
            }
            else if(ae.getActionCommand().equals("Admin Home Page"));
            dispose();
            new AdminFrame();
        }
    
}
}