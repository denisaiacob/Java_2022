package lab7;

import java.util.ArrayList;
import java.util.List;

public class Board extends Dictionary{

    private static List<String>words=new ArrayList<>();
    public void addWord(Player player, String word) {
        words.add(word);
        if(isWord(word)){
            player.setNrPoints(word);
            //daca cuvantul se afla in dictionar ii calculez nr de puncte
        }
        System.out.println(player.getName() + ": " + word + " nr de puncte:"+ player.getNrPoints() +"\n");
    }

    @Override
    public String toString() {
        return words.toString();
    }
}
