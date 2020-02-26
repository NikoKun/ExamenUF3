package app.classes;

import java.time.LocalDate;

public class ReaderUser extends User {
    LocalDate age;
    boolean ageRestriction;
//----------------------------------------------------------------------

    public ReaderUser(String username, String password, LocalDate age) {
        super(username, password);
        this.age = age;
    }

//----------------------------------------------------------------------

    public LocalDate getAge() {
        return age;
    }
    public void setAge(LocalDate age) {
        this.age = age;
    }

//----------------------------------------------------------------------
    
    public void setAgeRestriction(){
        this.rol = "reader";
        LocalDate menor = LocalDate.now().minusYears(18);
        if (this.age.isAfter(menor)){
            this.ageRestriction = true;
        }
        this.ageRestriction = false;
    }

    @Override
    public void menu() {
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 Menú de Lector                  |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|       2 - Seguir a un Editor nou                |");
        System.out.println("|       3 - Veure Editors que segueixo            |");
        System.out.println("|       4 - Visualitzar el mur                    |");
        System.out.println("|                                                 |");
        System.out.println("|       0 - Log Out                               |");
        System.out.println("|-------------------------------------------------|");
    }
}