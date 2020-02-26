package app;

import java.util.ArrayList;

import app.classes.Post;
import app.classes.User;

public class Functions {
    static String sep = "----------------------------------------------------------------------------------";

    public static void first() {
        System.out.println("|-------------------------------------------------|");
        System.out.println("|         Benvingut a CirvSocialNetwork           |");
        System.out.println("|-------------------------------------------------|");
    }

    public static void noUserMenu() {
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                Menú sense Usuari                |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|       1 - LogIn                                 |");
        System.out.println("|       2 - Registrar un Lector                   |");
        System.out.println("|                                                 |");
        System.out.println("|       0 - Sortir                                |");
        System.out.println("|-------------------------------------------------|");
    }

    public static void getUser(String[] user,ArrayList<User> usuaris){
        for (User thisUser : usuaris) {
            if (user[0].equals(thisUser.getUsername().toString())) {
                thisUser.menu();
            }
        }
    }

    public static boolean comprovaLogIn(String[] user, ArrayList<User> usuaris) {
        for (User thisUser : usuaris) {
            if (user[0].equals(thisUser.getUsername().toString()) && user[1].equals(thisUser.getPassword().toString())) {
                System.out.println(sep);
                return true;
            }
        }
        System.out.println("   Usuari no existent!!!");
        return false;
    }


    public static String comprovaRol(String username, ArrayList<User> usuaris){
        String rol = "";
        for (User thisUser : usuaris) {
            if (thisUser.getUsername().equals(username)) {
                rol = thisUser.getRol();
            }
        }
        return rol;
    }


    public static void mostraLectors(ArrayList<User> usuaris){
        System.out.println(sep);
        System.out.println("   Registre d'usuaris LECTORS:");
        System.out.println();
        for (User thisUser:usuaris){
            if (thisUser.getRol().equals("reader")){
                System.out.println("   - "+thisUser.getUsername());
            }
        }
        System.out.println(sep);
    }

    public static void mostraEditors(ArrayList<User> usuaris){
        System.out.println(sep);
        System.out.println("   Registre d'usuaris EDITORS:");
        System.out.println();
        for (User thisUser:usuaris){
            if (thisUser.getRol().equals("editor")){
                System.out.println("   - "+thisUser.getUsername());
            }        
        }
        System.out.println(sep);
    }
    
    public static boolean realitzarUpgrade(String userUpgrade, ArrayList<User> usuaris){
        for (User thisUser:usuaris){
            if (userUpgrade.equals(thisUser.getUsername())){
                if (thisUser.getRol().equals("reader")){
                    thisUser.setRol("editor");
                    System.out.println();
                    System.out.println("   Rol canviat a EDITOR.");
                    System.out.println(sep);
                    return true;
                }
            }
        }
        System.out.println();
        System.out.println("   Rol no canviat.");
        System.out.println(sep);
        return false;
    }

    public static void mostraPosts(ArrayList<Post> posts) {

    }


}