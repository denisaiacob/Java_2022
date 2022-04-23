package lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bag {
    private final Map<Tile, Integer> nrTiles=new HashMap<>();
    private final List<Tile> letters=new ArrayList<>();
    private int[] nr={9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
    private int[] points={1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    public Bag() {
        int i=0;
        for (char c = 'A'; c < 'Z'; c++) {
                Tile t=new Tile(c,points[i]);
                letters.add(t);
                nrTiles.put(t,nr[i]);
          i++;
        }
    }

    public boolean isTrue(){
        return !letters.isEmpty();
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        int val;
        for (int i = 0; i < howMany; i++) {
            val = (int)(Math.random() * 26);
            while (val>=letters.size()){
                val = (int)(Math.random() * 26);
            }
            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.get(val));
            int min=nrTiles.get(letters.get(val))-1;
            nrTiles.replace(letters.get(val),min);
            //numarul de aparitii-1
            if(nrTiles.get(letters.get(val))==0) {
                nrTiles.remove(letters.get(val));
                letters.remove(val);
                //daca numarul de aparitii al unei litere in sac ajunge la 0 atunci o elimin din map si din lista
            }
        }
        return extracted;
    }

    public int getPointsOnLetter(char c){
        for(int i=0;i<letters.size();i++) {
            if (letters.get(i).getLetter() == c)
                return letters.get(i).getPoints();
        }
        return 0;
        //functie ce calculeaza nr de puncte pentru o litera
    }
}
