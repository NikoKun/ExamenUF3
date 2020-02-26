package app.classes;

import java.util.ArrayList;

public abstract class User {
    String username, password, rol; // ROL = reader, editor
    ArrayList<User> following = new ArrayList<User>();

//----------------------------------------------------------------------

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

//----------------------------------------------------------------------

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }
    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

//----------------------------------------------------------------------


    public abstract void menu();
}