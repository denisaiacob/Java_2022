package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
    private List<String> words = new ArrayList<>();

    public boolean isWord(String str) {
        if(words.contains(str))
              return true;
        else
            return false;
    }
    public void readScanner() {
        File file = new File("E:\\Desktop\\An 2 sem 2\\java\\Laborator 7\\src\\main\\resources\\words.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
               words.add(scanner.nextLine().toUpperCase());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

