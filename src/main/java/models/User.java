package models;

import interfaces.DatabaseObject;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import services.security.PasswordHasher;

@Entity(value = "Users")
public class User implements DatabaseObject {

    @Id
    public ObjectId personId;
    private String username;
    private String password;
    private String role;



    private String email;


    public User(){}


    public User( String username, String password, String email,  String role) {
        this.username = username;
        this.password = PasswordHasher.hashPassword(password);
        this.role = role;
        this.email=email;
    }

    public ObjectId getPersonId() {
        return personId;
    }

    public void setPersonId(ObjectId personId) {
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return String.format("Nazwa: %s Email: %s Role: %s",username,email,role);
    }
}
