import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ShowProducts extends JFrame{

    JButton b1,b2;

    ShowProducts(){
        setTitle("VIEW ALL PRODUCTS");
        setLayout(new GridLayout(1,2));
        setSize(400,400);
        setVisible(true);

        b1 = new JButton("view Products");
        b2 = new JButton("exit");
        add(b1);
        add(b2);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);




    }

    public class MyActionListener implements ActionListener{

        public void actionPerformed(ActionEvent ae){

            ArrayList<Product> list = Product.ReadProductsFromFile();

            if(ae.getActionCommand().equals("View Products")){
                
                JOptionPane.showMessageDialog(null,"DATA");
                for ( int i=0; i < list.size();i++){
                JOptionPane.showMessageDialog(null,"Id: "+list.get(i).getId()+ "\n Name: "+list.get(i).getName()+"\nPrice :"+list.get(i).getPrice()+"\nCategory: "+list.get(i).getCategory());

                }
            }

            else if (ae.getActionCommand().equals("exit")){
                System.exit(0);
            }
        }
    }
}