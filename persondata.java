import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;



public class persondata extends Person implements Serializable{

    private String phoneno;
    private String Adress;
    private String card;
   
    public persondata(String name, String email, String phoneno, String adress, String card) {
        super(name, email);
        this.phoneno = phoneno;
        this.Adress = adress;
        this.card = card;
        

    }
    public persondata(persondata p) {
        super(p);
        this.phoneno = p.phoneno;
        Adress = p.Adress;
        this.card = p.card;
     
    }
   

    
    public String getPhoneno() {
        return phoneno;
    }
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    public String getAdress() {
        return Adress;
    }
    public void setAdress(String adress) {
        Adress = adress;
    }
    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }
  
    
    public void display(){
        System.out.println("Name "+super.getName());
        System.out.println("Email "+super.getEmail());
        System.out.println("phone no "+phoneno);
        System.out.println("Adress "+Adress);
        System.out.println("Card no  "+card);

    }


    public static void writeOrdersToFile(persondata p) {

        try {
            File f = new File("Orders Data.txt");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(p);
            oos.close();
        }

        catch (IOException e) {
            System.out.println("error in file writting");
        }
    }

     //Read data from file 
    public static ArrayList<persondata> ReadOrdersFromFile(){
        ArrayList<persondata> list = new ArrayList<persondata>();
        try{
            
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream("Orders Data.txt"));
            while(true){
                persondata p =(persondata)ois.readObject();
                list.add(new persondata(p));
                p.display();   
               
            }

        }
        catch(ClassNotFoundException e){
            System.out.println("CLASS NOT FOUND");
            return list;
        }
        catch (EOFException e){
            System.out.println("EOF EXCEPTION");
            return list;
        }
        catch (IOException e){ 
            System.out.println("IO EXCEPTION");
            return list;

        }
    }
  

}