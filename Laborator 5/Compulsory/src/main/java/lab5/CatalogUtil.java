package lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class CatalogUtil {


    public static void save(Catalog catalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Catalog load(String path)
            throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = null;
        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (Throwable m) {
            System.out.println(m.toString());
        }
        return catalog;
    }

}

