package lab5;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

public class ViewCommand extends CatalogUtil {

    public static void view(Item item) throws IOException{
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(URI.create((item.getLocation())));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
