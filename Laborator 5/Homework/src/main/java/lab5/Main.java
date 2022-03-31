package lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws Exception {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    static String path = "E:\\Desktop\\An 2 sem 2\\java\\Laborator 5\\catalog.json";

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyRefs");
        var book = new Item("article1", "knuth67", "Arta programarii pe computer", "d:/books/programming/tacp.ps");
        var article = new Item("book1", "java 17", "Java", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        AddCommand.add(book);
        AddCommand.add(article);

        SaveCommand.save(catalog, path);
        ListCommand.list();
    }

    private void testLoadView() throws Exception {
        Catalog catalog = LoadCommand.load(path);
        ViewCommand.view(catalog.findById("java 17"));
       // ReportCommand.report();
    }
}
