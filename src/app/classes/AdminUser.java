package app.classes;

import java.util.ArrayList;

public class AdminUser extends User {

//----------------------------------------------------------------------

    public AdminUser(String username, String password) {
        super(username, password);
    }

//----------------------------------------------------------------------

    @Override
    public void menu() {
        System.out.println("|-------------------------------------------------|");
        System.out.println("|             Menú de l'Administrador             |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|       1 - Crear un Post                         |");
        System.out.println("|       2 - Llistar els Posts                     |");
        System.out.println("|       3 - Eliminar un Post                      |");
        System.out.println("|       4 - Ascendre un Lector a Editor           |");
        System.out.println("|       5 - Llistar Editors                       |");
        System.out.println("|       6 - Llistar Lectors                       |");
        System.out.println("|                                                 |");
        System.out.println("|       0 - Log Out                               |");
        System.out.println("|-------------------------------------------------|");
    }

    @Override
    public void addEditor(User editor) {
    }

    @Override
    public void mostraEditorSeguint(){
    }

    @Override
    public boolean seguirEditor(ArrayList<User> usuaris, String seguir){
        return false;
    }

    @Override
    public void mostraMur(ArrayList<Post> posts){
        System.out.println();
        for (Post thisPost:posts){
            System.out.println((posts.indexOf(thisPost)+1)+" - Post creat per "+thisPost.getUser().getUsername()+" el día "+thisPost.getDate().getDayOfMonth()+"-"+thisPost.getDate().getMonthValue()+"-"+thisPost.getDate().getYear()+" a les "+thisPost.getDate().getHour()+":"+thisPost.getDate().getMinute()+" hores");
            System.out.println("     "+thisPost.getTitle()+":");
            System.out.println("     "+thisPost.getContent());
            System.out.println();
        }
    }

    @Override
    public void mostraEditorsNoSeguits(ArrayList<User> usuaris){
    }


    @Override
    public void usuariAfegit() {
        System.out.println();
        System.out.println("   USUARI ADMINISTRADOR AFEGIT CORRECTAMENT...");
        System.out.println();
    }
}