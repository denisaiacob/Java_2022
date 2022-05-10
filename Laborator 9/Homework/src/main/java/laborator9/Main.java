package laborator9;

import database.ContinentsEntity;

public class Main {

    public static void main(String args[]) {

        ContinentsRepository con=new ContinentsRepository();
        CityRepository city =new CityRepository();
        city.createEntityManager();
        con.testJPA();
        city.create("Iasi");
        city.closeEntityManager();
    }
}
