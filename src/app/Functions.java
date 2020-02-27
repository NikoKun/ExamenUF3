package app;

import java.time.LocalDate;
import java.util.ArrayList;

import app.classes.EditorUser;
import app.classes.Post;
import app.classes.ReaderUser;
import app.classes.User;

public class Functions {
    static String sep = "--------------------------------------------------";

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
        System.out.println();
        System.out.println("   Registre d'usuaris LECTORS:");
        System.out.println();
        for (User thisUser:usuaris){
            if (thisUser.getRol().equals("reader")){
                System.out.println("   - "+thisUser.getUsername());
            }
        }
    }

    public static void mostraEditors(ArrayList<User> usuaris){
        System.out.println();
        System.out.println("   Registre d'usuaris EDITORS:");
        System.out.println();
        for (User thisUser:usuaris){
            if (thisUser.getRol().equals("editor") || thisUser.getRol().equals("")){
                System.out.print("   - "+thisUser.getUsername());
                if (thisUser.getRol().equals("")){
                    System.out.print(" (admin)");
                }
                System.out.println();
            }        
        }
    }
    
    public static boolean realitzarUpgrade(String userUpgrade, ArrayList<User> usuaris){
        for (User thisUser:usuaris){
            if (userUpgrade.equals(thisUser.getUsername())){
                EditorUser canvi = new EditorUser(thisUser.getUsername(), thisUser.getPassword());
                canvi.setRol("editor");
                canvi.setFollowing(thisUser.getFollowing());
                usuaris.add(canvi);

                usuaris.remove(thisUser);
            
                System.out.println();
                System.out.println("   Rol canviat a EDITOR.");
                System.out.println(sep);
                return true;
                
            }
        }
        if (!userUpgrade.equals("")){
            System.out.println();
            System.out.println("   Rol no canviat.");
            System.out.println(sep);
        }
        return false;
    }

    public static boolean restringitono(String post) {
        if (post.equalsIgnoreCase("si")){
            return true;
        }
        else if (post.equalsIgnoreCase("no")){
            return true;
        }
        System.out.println();
        System.out.println("   Resposta incorrecte...");
        System.out.println(sep);
        return false;
    }

    public static User returnUser(String[] user,ArrayList<User> usuaris){
        User usuariInexistent = new ReaderUser("username", "password", LocalDate.now());
        for (User thisUser : usuaris) {
            if (user[0].equals(thisUser.getUsername().toString())) {
                return thisUser;
            }
        }
        System.out.println("SI ESTO ESTA SALIENDO ES QUE EL PROGRAMA FUNCIONA MAL...");
        return usuariInexistent;
    }

    public static void eliminaPosts(ArrayList<Post> posts, String index) {
        posts.remove(Integer.parseInt(index)-1);
    }








   

}