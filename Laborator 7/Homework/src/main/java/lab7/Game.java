package lab7;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    public final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.dictionary.readScanner();
        game.play();
        game.printWinner();
    }
    public void play() {
        DaemonThread t1 = new DaemonThread("t1");
        t1.setDaemon(true);
        t1.start();
        for (Player player : players) {
            Thread thread = new Thread(player);
            thread.start();
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public void printWinner(){
        int max=0;
        int winner=0;
        for(int i=0;i<players.size();i++){
            if(players.get(i).nrPoints>max){
                max=players.get(i).nrPoints;
                winner=i;
            }
        }
        System.out.println(players.get(winner).getName());
    }
}
