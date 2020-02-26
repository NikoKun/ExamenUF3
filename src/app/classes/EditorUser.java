package app.classes;


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
}