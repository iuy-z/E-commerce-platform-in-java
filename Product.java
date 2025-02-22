import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.*;
import java.io.EOFException;

public  class Product implements Serializable{
    protected String name;
    protected String category;
    protected int id;
    protected double price;

    public Product(){

    }

    //argument 
    public Product(String name, String category, int id, double price) {
        this.name = name;
        this.category = category;
        this.id = id;
        this.price = price;
    }

    //copy
    public Product(Product e){
        this.name = e.name;
        this.category = e.category;
        this.id = e.id;
        this.price = e.price;
    }
    //setters n getters 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //display
    public void display(){
        System.out.println("********");
        System.out.println("Name: "+name);
        System.out.println("Category: "+category);
        System.out.println("Id: "+id);
        System.out.println("Price: "+price);

    }

    // write data to file 
    public static void writeProductsToFile(Product p){
        try{
            File f = new File("product data.txt");
            ObjectOutputStream oos;
            if(f.exists()){
                oos=new MyObjectOutputStream(new FileOutputStream(f,true));
            }
            else{
                oos= new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(p);
            oos.close();
        }

        catch(IOException e){
            System.out.println("eror in file writting");
        }
    }

    //Read data from file 
    public static ArrayList<Product> ReadProductsFromFile(){
        ArrayList<Product> list = new ArrayList<Product>();
        try{
            
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream("product data.txt"));
            while(true){
                Product p =(Product)ois.readObject();
                list.add(new Product(p));
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

    // search product boolean 
    public static boolean SearchProductFromFile(int idd){
        ArrayList<Product> list = ReadProductsFromFile();
        boolean flag = false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).getId() == idd){
                    list.get(i).display();
                    flag = true;
                    break;
                }
            }
            return flag;
    }

    //will find n return the product 
    public static Product ReturnProductFromFile(int idd) {
        ArrayList<Product> list = ReadProductsFromFile();
        Product p = new Product();
    
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == idd) {
                p.setId(list.get(i).getId());
                p.setName(list.get(i).getName());
                p.setPrice(list.get(i).getPrice());
                p.setCategory(list.get(i).getCategory());
                break;
            }
        }
        return p;
    }
    

    // catalog page or whatever 
    public static void displayAllProducts(){
        ArrayList<Product> list = ReadProductsFromFile();
        for(int i=0;i<list.size();i++){
               list.get(i).display();
                
        }
    }

    public static void deleteProductFromFile(int idd){

        ArrayList<Product> list = ReadProductsFromFile();
            for(int i=0;i<list.size();i++){
                if(list.get(i).getId() == idd){
                    list.remove(i);
                    System.out.println("deleted");
                    break;
                }
            }
        try{
        
        File f = new File("product data.txt");
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product data.txt"));
            for(int i=0;i<list.size();i++){
                oos.writeObject(list.get(i));
            }
        }

        catch(IOException e){
            System.out.println("error in writting after deleteingg");
        }
    }


}