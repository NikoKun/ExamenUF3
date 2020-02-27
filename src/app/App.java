package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import app.classes.AdminUser;
import app.classes.Post;
import app.classes.ReaderUser;
import app.classes.User;
// LISTAR AL ADMIN ENTRE LOS EDITORES DE LA CLASE DE ADMINUSER
public class App {
    static String sep = "--------------------------------------------------";
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
            System.out.println();
            System.out.println("   Registra la contrasenya de l'usuari ADMINISTRADOR: ");
            admin[1] = System.console().readLine("   - ");
            System.out.println();
            System.out.println("   Confirma la contrasenya de l'usuari ADMINISTRADOR: ");
            admin[2] = System.console().readLine("   - ");
            System.out.println();
            if (admin[1].equals(admin[2])) {
                regAdmin = true;
            } else {
                System.out.println(sep);
                System.out.println("   LES CONTRASENYES NO COINCIDEIXEN!!!");
                System.out.println(sep);
            }
        } while  (!regAdmin);


        AdminUser admUser = new AdminUser(admin[0], admin[1]);
        admUser.setRol("");
        usuaris.add(admUser);
        admUser.usuariAfegit();

        while (!endProgram){
            Functions.noUserMenu();
            String menu = System.console().readLine("   - ");
            boolean correcte = false;
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
                        for (User meuUsuari:usuaris){
                            if (user[0].equals(meuUsuari.getUsername())){
                                correcte = meuUsuari.comprovaLogIn( usuaris);
                            }
                        }
                    } while (!correcte);


                    logOut = false;
                    while (!logOut){

                    Functions.getUser(user, usuaris);

                    if (Functions.comprovaRol(user[0], usuaris).equals("reader")){ // Lectors
                        User usuariPost = Functions.returnUser(user, usuaris);
                        menu = System.console().readLine("   - ");
                        System.out.println(sep);
                        switch (menu) {
                            case "1":               // Seguir a un editor nou
                                String seguir = "";
                                correcte = false;
                                do {
                                    System.out.println("   Introdueix el nom de l'editor a seguir: (Enter per llistar-los / 0 per sortir)");
                                    seguir = System.console().readLine("   - ");
                                    if (seguir.equals("")){
                                        usuariPost.mostraEditorsNoSeguits(usuaris);
                                        System.out.println();
                                    }
                                    if (seguir.equals("0")){
                                        break;
                                    }
                                    for (User meuUsuari:usuaris){
                                        if (usuariPost.getUsername().equals(meuUsuari.getUsername())){
                                            correcte = meuUsuari.seguirEditor(usuaris, seguir);
                                        }
                                    }
                                } while (!correcte);
                            break;
                            case "2":
                                // Veure editors que segueixes
                                usuariPost.mostraEditorSeguint();
                            break;
                            case "3":
                                // Veure el mur
                                usuariPost.mostraMur(posts);
                            break;
                            case "0":
                                logOut = true;
                            break;
                            default:
                                System.out.println(sep);
                                System.out.println("   OPCIÓ SEL·LECCIONADA INCORRECTE!!!");
                                System.out.println(sep);
                            break;
                        }


                    }
                    else if (Functions.comprovaRol(user[0], usuaris).equals("editor")){ // Escriptors
                        User usuariPost = Functions.returnUser(user, usuaris);
                        menu = System.console().readLine("   - ");
                        System.out.println(sep);
                        switch (menu) {
                            case "1":
                                // Crear un post
                                String[] post = {"títol","descripció","18? - no"};  // Mirar si ponene algo o no
                                System.out.println("   Introdueix el títol: ");
                                post[0] = System.console().readLine("   - ");

                                System.out.println("   Introdueix el contingut: ");
                                post[1] = System.console().readLine("   - ");

                                do {
                                    System.out.println("   Aquest contingut és per majors de 18? ");
                                    post[2] = System.console().readLine("   - ");
                                } while (!Functions.restringitono(post[2]));

                                posts.add(Post.createpost(usuariPost, post));

                            break;
                            case "2":
                                // Seguir a un editor nou
                                String seguir = "";
                                correcte = false;
                                do {
                                    System.out.println("   Introdueix el nom de l'editor a seguir: (Enter per llistar-los / 0 per sortir)");
                                    seguir = System.console().readLine("   - ");
                                    if (seguir.equals("")){
                                        usuariPost.mostraEditorsNoSeguits(usuaris);
                                        System.out.println();
                                    }
                                    if (seguir.equals("0")){
                                        break;
                                    }
                                    for (User meuUsuari:usuaris){
                                        if (usuariPost.getUsername().equals(meuUsuari.getUsername())){
                                            correcte = meuUsuari.seguirEditor(usuaris, seguir);
                                        }
                                    }
                                } while (!correcte);
                            break;
                            case "3":
                                // Veure editors que segueixes
                                usuariPost.mostraEditorSeguint();
                            break;
                            case "4":
                                // Veure el mur
                                usuariPost.mostraMur(posts);
                            break;
                            case "0":
                                logOut = true;
                            break;
                            default:
                                System.out.println();
                                System.out.println("   OPCIÓ SEL·LECCIONADA INCORRECTE!!!");
                                System.out.println();
                            break;
                        }



                    }
                    else {  // Admins
                            menu = System.console().readLine("   - ");
                            System.out.println(sep);
                            User usuariPost = Functions.returnUser(user, usuaris);
                            switch (menu) {
                                case "1":
                                    // Crear un post
                                    String[] post = {"títol","descripció","18? - no"};  // Mirar si ponene algo o no
                                    System.out.println("   Introdueix el títol: ");
                                    post[0] = System.console().readLine("   - ");

                                    System.out.println("   Introdueix el contingut: ");
                                    post[1] = System.console().readLine("   - ");

                                    do {
                                        System.out.println("   Aquest contingut és per majors de 18? ");
                                        post[2] = System.console().readLine("   - ");
                                    } while (!Functions.restringitono(post[2]));

                                    Post newPost = new Post(usuariPost, post[0], post[1], LocalDateTime.now());
                                    newPost.setAgeRestriction(post[2]);
                                    posts.add(newPost);
                                break;
                                case "2":
                                    usuariPost.mostraMur(posts);
                                break;
                                case "3":
                                    usuariPost.mostraMur(posts);
                                    System.out.println("   Digues el index del post que vols eliminar: ");
                                    String eliminar = System.console().readLine("   - ");   //Añadir restricciones
                                    Functions.eliminaPosts(posts, eliminar);
                                break;
                                case "4":
                                    // Upgradear a Editor
                                    boolean upgrade = false;
                                    String userUpgrade = "-";
                                    while (!upgrade){
                                        if (userUpgrade.equals("")){
                                            Functions.mostraLectors(usuaris);
                                            System.out.println();
                                        }
                                        System.out.println("   Escriu el nom del lector: (Intro per llistar-los / 0 per sortir)");
                                        userUpgrade = System.console().readLine("   - ");
                                        if (userUpgrade.equals("0")){
                                            break;
                                        }
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
                                    System.out.println();
                                    System.out.println("   OPCIÓ SEL·LECCIONADA INCORRECTE!!!");
                                    System.out.println();
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
                    System.out.println("   Introdueix la teva data de naixement: (dd-MM-YYYY)"); // POSAR RESTRICCIONS PER QUE NO PETI
                    String edat[] = System.console().readLine("   - ").split("-");
                    
                    LocalDate edatUsuari = LocalDate.of(Integer.parseInt(edat[2]), Integer.parseInt(edat[1]), Integer.parseInt(edat[0]));
                    ReaderUser newUser = new ReaderUser(userRegister[0], userRegister[1], edatUsuari);
                    newUser.setAgeRestriction();
                    usuaris.add(newUser);
                    newUser.usuariAfegit();
                    
                break;
                case "0":
                    endProgram = true;
                    System.out.println();
                    System.out.println("   SORTINT DEL PROGRAMA...");
                    System.out.println();
                break;
                default:
                    System.out.println();
                    System.out.println("   OPCIÓ SEL·LECCIONADA INCORRECTE!!!");
                    System.out.println();
                break;
            }

        }

    }
}