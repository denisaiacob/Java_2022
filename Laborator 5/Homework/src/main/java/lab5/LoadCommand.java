package lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LoadCommand extends CatalogUtil{

    public static Catalog load(String path)
            throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = null;
        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (Exception m) {
            System.out.println(m.toString());
        }
        return catalog;
    }
}
