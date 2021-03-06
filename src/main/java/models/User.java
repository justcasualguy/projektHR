package models;

import interfaces.DatabaseObject;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import services.security.PasswordHasher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity(value = "Users",noClassnameStored = true)
public class User implements DatabaseObject {

    @Id
    public ObjectId id;
    private String username;
    private String password;
    private String role;
    private String registerDate;
    private boolean passwordChangeRequired;
    private String addedBy;
    private String email;
    private String name;
    private String surname;
    private String pesel;





    public User(){}


    public User( String username, String password, String email,  String role, String addedBy) {
        this.username = username;
        this.password = PasswordHasher.hashPassword(password);
        this.role = role;
        this.email=email;
        registerDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
        this.addedBy=addedBy;

    }

    public User(String username, String password,   String email, String name, String surname, String pesel,String role, String addedBy) {
        this.username = username;
        this.password = PasswordHasher.hashPassword(password);
        this.role = role;
        registerDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
        this.addedBy = addedBy;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }



    //<editor-fold desc="Getters and setters">
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
    //</editor-fold>

    @Override
    public Document toDocument() {
        return new Document("username",username)
                .append("password",password)
                .append("email",email)
                .append("role",role);
    }



    @Override
    public String toString() {
        return String.format("Nazwa: %s Email: %s Role: %s Register: %s",username,email,role,registerDate);
    }
}
