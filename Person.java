import java.util.*;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.EOFException;

public abstract class Person implements Serializable{
    protected String name;
    protected String email;

    public Person(){
      
    }
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(Person p){
        this.name = p.name;
        this.email = p.email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", email=" + email + "]";
    }

    
    

}