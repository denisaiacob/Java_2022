package lab5;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class ReportCommand extends Catalog {

    public static void report() throws Exception {

        // 1. Configure FreeMarker

        Configuration cfg = new Configuration();

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(ReportCommand.class, "template.ftl");

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);


        //  Prepare the template input:

        Map<String, Object> input = new HashMap<>();

        input.put("exampleObject", new Item("article1", "knuth67", "Arta programarii pe computer", "d:/books/programming/tacp.ps"));

        List<Item> exemple = new ArrayList<>();
        exemple.add(new Item("book1", "java 17", "Java", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html"));

        input.put("exemple", exemple);

        //  Get the template

        Template template = cfg.getTemplate("template.ftl");


        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }
}
