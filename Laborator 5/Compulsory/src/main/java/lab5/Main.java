package lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    static String path = "E:\\Desktop\\An 2 sem 2\\java\\Laborator 5\\catalog.json";

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyRefs");
        var book = new Item("article1", "knuth67", "Arta programarii pe computer", "d:/books/programming/tacp.ps");
        var article = new Item("book1", "java 17", "Java", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        // var book = new Item("article1",article);
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, path);
        System.out.println(catalog.toString());
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load(path);
    }
}
