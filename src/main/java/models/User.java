package models;

import interfaces.DatabaseObject;
import org.bson.Document;

public class User implements DatabaseObject {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
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
    //</editor-fold>

    @Override
    public Document toDocument() {
        return new Document("username",username)
                .append("password",password)
                .append("role",role);
    }
}
