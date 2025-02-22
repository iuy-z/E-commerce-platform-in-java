import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;

public class Order implements Serializable{

    ArrayList<persondata> orderlist = new ArrayList<persondata>();

    public Order(ArrayList<persondata> orderlist) {
        this.orderlist = orderlist;
    }

    public ArrayList<persondata> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(ArrayList<persondata> orderlist) {
        this.orderlist = orderlist;
    }

    
    public static void writeOrderDataToFile(){
        
    }

    

}