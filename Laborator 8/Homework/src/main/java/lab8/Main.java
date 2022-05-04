package lab8;

import Map.SphericalMercator;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String args[]) throws SQLException {
        try {
            int id=0;
            Database.createConnection();
            var continents = new ContinentDAO();
            continents.create(id,"Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId,"RO");
            countries.create("Ukraine", europeId,"UA");
            Database.getConnection().commit();
            CityDAO city=new CityDAO();
            city.create("Iasi",12,false,4.12,3.1);
            Database.getConnection().commit();
            System.out.println(countries.findById(europeId));

            var dataset= new ImportData();
            dataset.readData();
            var coordinates=new Distance();
            coordinates.printDistance("Jerusalem","Marigot");

            Database.getConnection().rollback();
            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SphericalMercator sphericalMercator=new SphericalMercator();

    }
}
