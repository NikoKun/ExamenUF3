package app.classes;

import java.util.ArrayList;

public class EditorUser extends User {

//----------------------------------------------------------------------

    public EditorUser(String username, String password) {
        super(username, password);
    }

//----------------------------------------------------------------------



    @Override
    public void menu() {
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 Menú de Editor                  |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|       1 - Crear un Post                         |");
        System.out.println("|       2 - Seguir a un altre Editor              |");
        System.out.println("|       3 - Veure Editors que segueixo            |");
        System.out.println("|       4 - Visualitzar el mur                    |");
        System.out.println("|                                                 |");
        System.out.println("|       0 - Log Out                               |");
        System.out.println("|-------------------------------------------------|");
    }



    @Override
    public void addEditor(User editor) {
        ArrayList<User> nouUsuari = new ArrayList<User>();
        for (User antigaLlista : this.getFollowing()){
            nouUsuari.add(antigaLlista);
        }
        nouUsuari.add(editor);
        this.setFollowing(nouUsuari);
    }

    @Override
    public void mostraEditorSeguint(){
        System.out.println();
        System.out.println("   Registre d'usuaris EDITORS SEGUITS:");
        System.out.println();        
        for (User editor:this.following){
            System.out.print("   - "+editor.getUsername());
            if (editor.getRol().equals("")){
                System.out.print(" (admin)");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public boolean  seguirEditor(ArrayList<User> usuaris, String seguir){
        for (User meuUsuari : usuaris) {
            if (this.getUsername().equals(meuUsuari.getUsername())){
                for (User thisUser : usuaris) {
                    if (seguir.equals(thisUser.getUsername().toString()) && (thisUser.getRol().equals("editor") || thisUser.getRol().equals(""))) {
                        meuUsuari.addEditor(thisUser);
                        System.out.println();
                        System.out.println("   USUARI SEGUIT CORRECTAMENT");
                        System.out.println();
                        return true;
                    }
                }
            }
        }
        if (!seguir.equals("")){
            System.out.println();
            System.out.println("   EDITOR NO TROVAT...");
            System.out.println();
        }
        return false;
    }


    @Override
    public void mostraMur(ArrayList<Post> posts){
        boolean isempty = true;
        for (Post postActual:posts){
            for (User editor:this.following){
                isempty = false;
                if ((postActual.getUser().getUsername().equals(editor.getUsername())) || postActual.getUser().getUsername().equals(this.getUsername())){
                    System.out.println();
                    System.out.println("   - Post creat per "+postActual.getUser().getUsername()+" el día "+postActual.getDate().getDayOfMonth()+"-"+postActual.getDate().getMonthValue()+"-"+postActual.getDate().getYear()+" a les "+postActual.getDate().getHour()+":"+postActual.getDate().getMinute()+" hores");
                    System.out.println("   Per a majors de 18? ("+postActual.getAgeRestriction()+")");
                    System.out.println("   "+postActual.getTitle()+":");
                    System.out.println("   "+postActual.getContent());
                }
            }
            if (postActual.getUser().getUsername().equals(this.getUsername()) && isempty == true){
                System.out.println();
                System.out.println("   - Post creat per "+postActual.getUser().getUsername()+" el día "+postActual.getDate().getDayOfMonth()+"-"+postActual.getDate().getMonthValue()+"-"+postActual.getDate().getYear()+" a les "+postActual.getDate().getHour()+":"+postActual.getDate().getMinute()+" hores");
                System.out.println("   Per a majors de 18? ("+postActual.getAgeRestriction()+")");
                System.out.println("   "+postActual.getTitle()+":");
                System.out.println("   "+postActual.getContent());
            }
        }
    }

    
    @Override
    public void mostraEditorsNoSeguits(ArrayList<User> usuaris){
        boolean isempty = true;
        System.out.println();
        System.out.println("   Registre d'usuaris EDITORS NO SEGUITS:");
        System.out.println();
        for (User thisUser:usuaris){
            for (User editor:this.getFollowing()){
                isempty = false;
                if (((thisUser.getRol().equals("editor") || thisUser.getRol().equals("")) && !thisUser.getUsername().equals(editor.getUsername())) && !thisUser.getUsername().equals(this.getUsername())){
                    System.out.print("   - "+thisUser.getUsername());
                    if (thisUser.getRol().equals("")){
                        System.out.print(" (admin)");
                    }
                    System.out.println();
                }
            }
            if (((thisUser.getRol().equals("editor") || thisUser.getRol().equals("")) && isempty == true) && !thisUser.getUsername().equals(this.getUsername())){
                System.out.println("   - "+thisUser.getUsername());
                if (thisUser.getRol().equals("")){
                    System.out.print(" (admin)");
                }
            }
        }
        System.out.println();
    }

    @Override
    public void usuariAfegit() {
    }

    
}