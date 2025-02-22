import java.io.Serializable;

public class Admin extends Person implements Serializable{
    private String password;
    private String username;

    public Admin(String name, String email, String password, String username) {
        super(name, email);
        this.password = password;
        this.username = username;
    }
    public Admin(Admin p) {
        super(p);
        this.password = p.password;
        this.username = p.username;
    }

    

}