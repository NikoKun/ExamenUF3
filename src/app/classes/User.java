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

    public boolean comprovaLogIn(ArrayList<User> usuaris) {
        for (User thisUser : usuaris) {
            if (this.getUsername().equals(thisUser.getUsername().toString()) && this.getPassword().equals(thisUser.getPassword().toString())) {
                return true;
            }
        }
        System.out.println("   Usuari no existent!!!");
        return false;
    }

    public abstract void menu();
    public abstract void addEditor(User editor);
    public abstract void mostraEditorSeguint();
    public abstract void mostraMur(ArrayList<Post> posts);
    public abstract boolean seguirEditor(ArrayList<User> usuaris, String seguir);
    public abstract void mostraEditorsNoSeguits(ArrayList<User> usuaris);
    public abstract void usuariAfegit();
}