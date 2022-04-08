package lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bag {
    private final Map<Tile, Integer> nr=new HashMap<>();
    private final List<Tile> letters=new ArrayList<>();
    int val=0;
    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            while(val<1) {
                //val = Integer.parseInt(String.valueOf(Math.random() * 11));
                val=(int)(Math.random() * 11);
            }
            Tile t=new Tile(c,val);
            letters.add(t);
            nr.put(t,10);
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            val = (int)(Math.random() * 25);

            if (letters.isEmpty()) {
                break;
            }
            extracted.add(letters.get(val));
            nr.replace(letters.get(val),nr.get(letters.get(val))-1);
        }
        return extracted;
    }
}
