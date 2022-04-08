package lab7;

import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    String word=new String();
    public static int amount = 0;

    public Player(String name) {
        this.name = name;
    }
    public boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        for(Tile e:extracted) {
            //word.concat(String.valueOf(e.getLetter()));
            word=word+e.getLetter();
        }

        game.getBoard().addWord(this, word);
       // make the player sleep 50ms;
        return true;
    }

    @Override
    public void run() {
        amount++;
        submitWord();
    }
    //implement the run method;


    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }
}
