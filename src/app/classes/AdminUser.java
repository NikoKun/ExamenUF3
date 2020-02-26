package app.classes;


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
}