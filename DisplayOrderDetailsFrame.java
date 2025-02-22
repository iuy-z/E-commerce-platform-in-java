import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DisplayOrderDetailsFrame extends JFrame {
    JButton b1, b2;

    DisplayOrderDetailsFrame() {
        setTitle("Display Products Frame");
        setLayout(new GridLayout(1, 2));
        setSize(400, 400);
        setVisible(true);

        b1 = new JButton("Display Orders");
        b2 = new JButton("Admin Home Page");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        add(buttonPanel);

        MyActionListener listener = new MyActionListener();
        b1.addActionListener(listener);
        b2.addActionListener(listener);
    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            ArrayList<persondata> list = persondata.ReadOrdersFromFile();
            
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int rand = random.nextInt(1, 1000);

            if (ae.getSource() == b1) {
                JOptionPane.showMessageDialog(null, "DATA");
                for (int i = 0; i < list.size(); i++) {
                    JOptionPane.showMessageDialog(null, "Order No:" + rand +
                            "\n Name: " + list.get(i).getName() +
                            "\nEmail :" + list.get(i).getEmail() + "\nPhone no: " + list.get(i).getPhoneno() +
                            "\nAdress: " + list.get(i).getAdress());
                }
            } else if (ae.getSource() == b2) {
                new AdminFrame();
            }
        }
    }
}
