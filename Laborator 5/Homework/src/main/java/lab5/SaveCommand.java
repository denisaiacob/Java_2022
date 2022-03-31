package lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends CatalogUtil{

    public static void save(Catalog catalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), catalog);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
