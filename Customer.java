import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;

public class Customer extends Person implements Serializable {
    private boolean membership; // memberisp
    private String password;
    private String username;
    private ArrayList<Product> cart = new ArrayList<Product>();

    public Customer() {
        super();
    }

    public Customer(String x, String y, String username, String password) {
        super(x, y);
        this.password = password;
        this.username = username;
    }

    /*
     * public Customer(String x,String y,boolean membership,String username,String
     * password) {
     * super(x,y);
     * this.membership = membership;
     * this.password = password;
     * this.username = username;
     * }
     */

    public Customer(Customer c) {
        super(c);
        this.membership = c.membership;
        this.username = c.username;
        this.password = c.password;

    }

    // password checkkkk
    public boolean isStrongPassword(String password) {
        boolean flag = false;
        if (password.length() >= 5) {
            flag = true;
        }
        return flag;
    }

    // email checkkk
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    // setters n getters
    public boolean getmembership() {
        return membership;
    }

    public void setmembership(boolean membership) {
        this.membership = membership;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMembership() {
        return membership;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    // display
    public void display() {
        System.out.println("********");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: *****");
        System.out.println("Membership:" + getmembership());
        for (int i = 0; i < cart.size(); i++) {
            System.out.println("name :" + cart.get(i).getName() + "\nid :" + cart.get(i).getId() + "\nprice"
                    + cart.get(i).getPrice());
        }

    }

    // write data to file
    public static void writeCustomersToFile(Customer p) {

        try {
            File f = new File("Customer data.txt");
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

    // Read data from file

    public static ArrayList<Customer> ReadCustomersFromFile() {
        ArrayList<Customer> list = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customer data.txt"))) {
            while (true) {
                try {
                    Object obj = ois.readObject();

                    if (obj instanceof Customer) {
                        Customer customer = (Customer) obj;

                        // Manually deserialize the Product objects within the cart
                        for (int i = 0; i < customer.getCart().size(); i++) {
                            Object cartItem = ois.readObject();

                            if (cartItem instanceof Product) {
                                customer.getCart().set(i, (Product) cartItem);
                            } else {
                                System.out.println("Unexpected object type found in the cart.");
                            }
                        }

                        list.add(customer);
                        customer.display();
                    } else {
                        System.out.println("Unexpected object type found in the file.");
                    }
                } catch (EOFException e) {
                    break; // Break the loop when the end of the file is reached
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // when user wants to delete his account
    public static void deleteCustomerFromFile(String name) {

        ArrayList<Customer> list = ReadCustomersFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(name)) {
                list.remove(i);
                System.out.println("deleted");
                break;
            }
        }
        try {

            File f = new File("Customer data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer data.txt"));
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }
        }

        catch (IOException e) {
            System.out.println("error in writting after deleteingg");
        }
    }

    // used in login as i need this customer while addin n removing products from
    // cart
    public static Customer login(String username) {
        ArrayList<Customer> list = ReadCustomersFromFile();

        for (int i = 0; i < list.size(); i++) {
            if (username.equals(list.get(i).getUsername())) {
                Customer loginCustomer = new Customer();
                loginCustomer.setName(list.get(i).getName());
                loginCustomer.setEmail(list.get(i).getEmail());
                loginCustomer.setUsername(username);
                loginCustomer.setPassword(list.get(i).getPassword());
                return loginCustomer;
            }
        }
        return null;
    }

    // write data to file for login customer to keep the track of login cutomers
    public static void writeLoginCustomersToFile(Customer p) {
        try {
            File f2 = new File("Customer Login data.txt");
            ObjectOutputStream oos;
            if (f2.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f2, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f2));
            }

            oos.writeObject(p);
            oos.close();
        }

        catch (IOException e) {
            System.out.println("error in file writting");
        }
    }

    // Read data from file
    public static ArrayList<Customer> ReadLoginCustomersFromFile() {
        ArrayList<Customer> list = new ArrayList<Customer>();
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customer Login data.txt"));
            while (true) {
                Customer p = (Customer) ois.readObject();
                list.add(new Customer(p));
                p.display();

            }

        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND");
            return list;
        } catch (EOFException e) {
            System.out.println("EOF EXCEPTION");
            return list;
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
            return list;

        }
    }

    // used in changing username in my account frame will change username from both
    // login data n data
    public static void changeUsername(String name, String us) {

        ArrayList<Customer> list = ReadCustomersFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                list.get(i).setUsername(us);
                break;
            }
        }

        ArrayList<Customer> loginlist = ReadLoginCustomersFromFile();
        for (int i = 0; i < loginlist.size(); i++) {
            if (loginlist.get(i).getName().equals(name)) {
                loginlist.get(i).setUsername(us);
                break;
            }
        }

        try {

            File f = new File("Customer data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer data.txt"));
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }

            File f2 = new File("Customer Login data.txt");
            ObjectOutputStream ooss = new ObjectOutputStream(new FileOutputStream("Customer Login data.txt"));
            for (int i = 0; i < loginlist.size(); i++) {
                oos.writeObject(loginlist.get(i));
            }
        }

        catch (IOException e) {
            System.out.println("error in writting after deleteingg");
        }
    }

    // used in update membership in my account frame will memebership from both
    // login data n data
    public static void changePassword(String name, String ps) {

        ArrayList<Customer> list = ReadCustomersFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                list.get(i).setPassword(ps);
                break;
            }
        }

        ArrayList<Customer> loginlist = ReadLoginCustomersFromFile();
        for (int i = 0; i < loginlist.size(); i++) {
            if (loginlist.get(i).getName().equals(name)) {
                loginlist.get(i).setUsername(ps);
                break;
            }
        }

        try {

            File f = new File("Customer data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer data.txt"));
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }

            File f2 = new File("Customer Login data.txt");
            ObjectOutputStream ooss = new ObjectOutputStream(new FileOutputStream("Customer Login data.txt"));
            for (int i = 0; i < loginlist.size(); i++) {
                oos.writeObject(loginlist.get(i));
            }
        }

        catch (IOException e) {
            System.out.println("error in writting after deleteingg");
        }
    }

    // used in update membership in my account frame will change password from both
    // login data n data
    public static void UpdateMemberShip(String name, String ch) {

        ArrayList<Customer> list = ReadCustomersFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name) && ch.equals("yes")) {
                list.get(i).setmembership(true);
                break;
            }
        }

        ArrayList<Customer> loginlist = ReadLoginCustomersFromFile();
        for (int i = 0; i < loginlist.size(); i++) {
            if (loginlist.get(i).getName().equals(name) && ch.equals("yes")) {
                loginlist.get(i).setmembership(true);
                break;
            }
        }

        try {

            File f = new File("Customer data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer data.txt"));
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }

            File f2 = new File("Customer Login data.txt");
            ObjectOutputStream ooss = new ObjectOutputStream(new FileOutputStream("Customer Login data.txt"));
            for (int i = 0; i < loginlist.size(); i++) {
                oos.writeObject(loginlist.get(i));
            }
        }

        catch (IOException e) {
            System.out.println("error in writting after deleteingg");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Add product to customer's cart in the same file
    public static void addProductToCustomerCart(Product product, String customerUsername) {
        try {
            File file = new File("CustomerData.txt");

            ObjectOutputStream oos;
            if (file.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(file, true));

            } else {

                oos = new ObjectOutputStream(new FileOutputStream(file));
            }

            // Write a special marker indicating that the following object is a Product for
            // the specified customer
            oos.writeObject(new CartMarker(customerUsername));
            oos.writeObject(product);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read products from customer's cart in the same file
    public static ArrayList<Product> readProductsFromCustomerCart(String customerUsername) {
        ArrayList<Product> cartProducts = new ArrayList<>();
        boolean isCorrectCustomerCart = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CustomerData.txt"))) {
            while (true) {
                try {
                    Object obj = ois.readObject();

                    if (obj instanceof CartMarker) {
                        CartMarker marker = (CartMarker) obj;
                        if (marker.getCustomerUsername().equals(customerUsername)) {
                            // Start reading the products for the correct customer
                            isCorrectCustomerCart = true;
                        } else {
                            // Skip reading if it's not the correct customer's cart
                            isCorrectCustomerCart = false;
                        }
                    } else if (isCorrectCustomerCart && obj instanceof Product) {
                        // Read the products if it's the correct customer's cart
                        Product product = (Product) obj;
                        cartProducts.add(product);
                        product.display();
                    }
                } catch (EOFException e) {
                    // End of file
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return cartProducts;
    }

    // Remove product from customer's cart in the same file
    public static void removeProductFromCustomerCart(String customerUsername, int id) {
        ArrayList<Product> cartProducts = readProductsFromCustomerCart(customerUsername);
        

        if(cartProducts.isEmpty()){
            System.out.println("No Products have been added in Cart yet!");
            return;
        }

        for (int i = 0; i < cartProducts.size(); i++) {
            if (cartProducts.get(i).getId() == id) {
                cartProducts.remove(i);
                break;
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CustomerData.txt"))) {
            // Write back the marker and updated cart products
            oos.writeObject(new CartMarker(customerUsername));
            for (Product product : cartProducts) {
                oos.writeObject(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Remove product from customer's cart in the same file
    public static void removeProductFromCustomerCartAfterBuy(String customerUsername) {
        ArrayList<Product> cartProducts = readProductsFromCustomerCart(customerUsername);

        for (int i = 0; i < cartProducts.size(); i++) {
                cartProducts.remove(i);
         
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CustomerData.txt"))) {
            // Write back the marker and updated cart products
            oos.writeObject(new CartMarker(customerUsername));
            for (Product product : cartProducts) {
                oos.writeObject(product);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Marker class to indicate a Product for a specific customer in the file
    private static class CartMarker implements Serializable {
        private String customerUsername;

        public CartMarker(String customerUsername) {
            this.customerUsername = customerUsername;
        }

        public String getCustomerUsername() {
            return customerUsername;
        }
    }

    public static double buybill(String username){
        ArrayList<Product> list = readProductsFromCustomerCart(username);
        double total=0;

        for(int i=0;i<list.size();i++){
            total+=list.get(i).getPrice();
        }

        return total;

    }


    /////////////////////////////////////////////////////
    public static ArrayList<Product> SearchProductFromCustomerCart(String customerUsername) {
        ArrayList<Product> cartProducts = new ArrayList<>();
        boolean isCorrectCustomerCart = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CustomerData.txt"))) {
            while (true) {
                try {
                    Object obj = ois.readObject();

                    if (obj instanceof CartMarker) {
                        CartMarker marker = (CartMarker) obj;
                        if (marker.getCustomerUsername().equals(customerUsername)) {
                            // Start reading the products for the correct customer
                            isCorrectCustomerCart = true;
                        } else {
                            // Skip reading if it's not the correct customer's cart
                            isCorrectCustomerCart = false;
                        }
                    } else if (isCorrectCustomerCart && obj instanceof Product) {
                        // Read the products if it's the correct customer's cart
                        Product product = (Product) obj;
                        cartProducts.add(product);
                        product.display();
                    }
                } catch (EOFException e) {
                    // End of file
                    break;
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return cartProducts;
    }
}
