package app;

import java.time.LocalDate;
import java.util.ArrayList;

import app.classes.AdminUser;
import app.classes.Post;
import app.classes.ReaderUser;
import app.classes.User;

public class App {
    static String sep = "----------------------------------------------------------------------------------";

    public static void main(String[] args) throws Exception {
        ArrayList<User> usuaris = new ArrayList<User>();
        ArrayList<Post> posts = new ArrayList<Post>();

        String[] admin = { "admin","admin","wala" };
        String[] user = { "admin","admin" };
        String[] userRegister = { "admin","admin" };
        boolean regAdmin = false;
        boolean endProgram = false;
        boolean logOut = false;

        Functions.first();

        do{
            System.out.println("   Registra el nom de l'usuari ADMINISTRADOR: ");
            admin[0] = System.console().readLine("   - ");
            System.out.println("   Registra la contrasenya de l'usuari ADMINISTRADOR: ");
            admin[1] = System.console().readLine("   - ");
            System.out.println("   Confirma la contrasenya de l'usuari ADMINISTRADOR: ");
            admin[2] = System.console().readLine("   - ");
            if (admin[1].equals(admin[2])) {
                regAdmin = true;
            } else {
                System.out.println();
                System.out.println("   La contrassenya no coincideix!!!");
            }
            System.out.println(sep);
        } while  (!regAdmin);

        AdminUser admUser = new AdminUser(admin[0], admin[1]);
        admUser.setRol("");
        usuaris.add(admUser);

        while (!endProgram){
            Functions.noUserMenu();
            String menu = System.console().readLine();
            System.out.println(sep);
            switch (menu) {
                case "1":
                    do {
                        System.out.println("   Introdueix el teu nom d'usuari: ");
                        user[0] = System.console().readLine("   - ");
                        System.out.println();
                        System.out.println("   Introdueix la teva contrasenya: ");
                        user[1] = System.console().readLine("   - ");
                        System.out.println();
                    } while (!Functions.comprovaLogIn(user, usuaris));

                    Functions.getUser(user, usuaris);

                    logOut = false;

                    if (Functions.comprovaRol(user[0], usuaris).equals("reader")){ // Lectors
                        menu = System.console().readLine();
                        System.out.println(sep);
                    }
                    else if (Functions.comprovaRol(user[0], usuaris).equals("editor")){ // Escriptors
                        menu = System.console().readLine();
                        System.out.println(sep);
                    }
                    else {  // Admins

                        while (!logOut){
                            menu = System.console().readLine();
                            System.out.println(sep);
    
                            switch (menu) {
                                case "1":
                                    // Crear un post
                                    // Post newPost = new Post(user, title, content, date, ageRestriction);
    
                                break;
                                case "2":
                                    Functions.mostraPosts(posts); //----------
                                break;
                                case "3":
                                break;
                                case "4":
                                    // Upgradear a Editor
                                    boolean upgrade = false;
                                    String userUpgrade = "-";
                                    while (!upgrade){
                                        if (userUpgrade.equals("")){
                                            Functions.mostraLectors(usuaris);
                                        }
                                        System.out.println("   Escriu el nom del lector: (Intro per llistar-los)");
                                        userUpgrade = System.console().readLine();
                                        upgrade = Functions.realitzarUpgrade(userUpgrade, usuaris);
                                    }
                                break;
                                case "5":
                                    // Llistar Editors
                                    Functions.mostraEditors(usuaris);
                                break;
                                case "6":
                                    // Llistar Lectors
                                    Functions.mostraLectors(usuaris);
                                break;
                                case "0":
                                    logOut = true;
                                break;
                                default:
                                    System.out.println("   Opció INCORRECTE!!!!");
                                break;
                            }
                        }
                    }
                break;
                case "2":
                    System.out.println("   Introdueix el teu nom d'usuari: ");
                    userRegister[0] = System.console().readLine("   - ");
                    System.out.println();
                    System.out.println("   Introdueix la teva contrasenya: ");
                    userRegister[1] = System.console().readLine("   - ");
                    System.out.println();
                    System.out.println("   Introdueix la teva data de naixement: (dd-MM-YYYY)"); //----------
                    String edat[] = System.console().readLine("   - ").split("-");
                    
                    LocalDate edatUsuari = LocalDate.of(Integer.parseInt(edat[2]), Integer.parseInt(edat[1]), Integer.parseInt(edat[0]));
                    ReaderUser newUser = new ReaderUser(userRegister[0], userRegister[1], edatUsuari);
                    newUser.setAgeRestriction();
                    usuaris.add(newUser);

                    System.out.println(sep);
                break;
                case "0":
                    endProgram = true;
                    System.out.println("   Sortint del programa...");
                    System.out.println(sep);
                break;
                default:
                    System.out.println();
                    System.out.println("   Opció INCORRECTE!!!");
                    System.out.println(sep);
                break;
            }

        }

    }
}