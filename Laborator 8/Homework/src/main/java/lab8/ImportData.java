package lab8;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.SQLException;

public class ImportData {
   private int count=0;

  public void readData() throws FileNotFoundException {

      Path pathToFile= Paths.get("E:\\Desktop\\An 2 sem 2\\java\\lab8 partea2\\src\\main\\resources\\concap.csv");
      try (BufferedReader br = Files.newBufferedReader(pathToFile,
              StandardCharsets.ISO_8859_1)) {

          String line = br.readLine();
        while (line != null) {
            String[] attributes = line.split(",");
            if(count!=0) {
                int id = addContinent(attributes);
                addCountry(attributes, id);
            }
            line = br.readLine();
            count++;
        }
    } catch (IOException v) {
        v.printStackTrace();
    } catch (SQLException t) {
          t.printStackTrace();
      }
  }

     private int addContinent(String[] metadata) throws SQLException {
         var continents = new ContinentDAO();
         continents.create(count,metadata[5]);
         Database.getConnection().commit();
         return continents.findByName(metadata[5]);
     }

  private void addCountry(String[] metadata,int id) throws SQLException {
      var countries = new CountryDAO();
      countries.create(metadata[0],id,metadata[4]);
      Database.getConnection().commit();
      var city = new CityDAO();
      city.create(metadata[1],countries.findByName(metadata[0]),true,
              Double.parseDouble(metadata[2]),Double.parseDouble(metadata[3]));
      Database.getConnection().commit();
  }


}
