import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SearchProductFrame extends JFrame{

    JButton b1,b2,b3;
    JLabel l1;
    JTextField j1;
    JPanel p1,p2;


    SearchProductFrame(){
        setTitle("Search Product Form");
        setLayout(new BorderLayout());
        setSize(400,400);
        setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();

        l1 = new JLabel("Enter Id");
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

            ArrayList<Product> list = Product.ReadProductsFromFile();

            boolean flag = false;
            if(ae.getActionCommand().equals("Search")){
                flag =Product.SearchProductFromFile(Integer.parseInt(j1.getText()));
                if ( flag == true ){
                    JOptionPane.showMessageDialog(new Frame(),"Product Found!");
                    for ( int i=0; i < list.size();i++){
                        if(list.get(i).getId() == Integer.parseInt(j1.getText())){
                        JOptionPane.showMessageDialog(null,"Id: "+list.get(i).getId()+ "\n Name: "+list.get(i).getName()+"\nPrice :"+list.get(i).getPrice()+"\nCategory: "+list.get(i).getCategory());
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(new Frame(),"Product NOT Found!");
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
