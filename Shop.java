import java.io.Serializable;
import java.util.*;

public class Shop implements Serializable {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Customer> customer = new ArrayList<Customer>();
    private ArrayList<Customer> loginCustomers = new ArrayList<Customer>();
    private ArrayList<persondata> orders = new ArrayList<persondata>();
    private Admin admin;

    

    public Shop(ArrayList<Product> products, ArrayList<Customer> customer, Admin admin) {
        this.products = products;
        this.customer = customer;
        this.admin = admin;
    }

    //setters n getters 
    public ArrayList<Customer> getLoginCustomers() {
        return loginCustomers;
    }

    public void setLoginCustomers(ArrayList<Customer> loginCustomers) {
        this.loginCustomers = loginCustomers;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<persondata> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<persondata> orders) {
        this.orders = orders;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    
    
    
   
}