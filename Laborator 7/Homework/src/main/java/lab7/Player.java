package lab7;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    int nrPoints=0;

    public Player(String name) {
        this.name = name;
    }
    public void submitWord() throws InterruptedException, IOException {

        List<Tile> extracted=new ArrayList<>();
        while(game.getBag().isTrue()) {
            extracted.addAll(game.getBag().extractTiles(7));
            String word = new String();
            for (int j = 0; j < extracted.size(); j++) {
                System.out.println(extracted.get(j));
            }

            int ok = 0;
            while (ok == 0) {
                Scanner input = new Scanner(System.in);
                System.out.println("Cuvantul: ");
                word = input.nextLine();
                for (int k = 0; k < word.length(); k++) {
                    ok = 0;
                    for (int j = 0; j < extracted.size(); j++) {
                        if (extracted.get(j).getLetter() == word.charAt(k)) {
                            ok = 1;
                        }
                    }
                    if (ok == 0) {
                        break;
                    }
                }
                //verific daca caracterele folosite sunt dintre cele extrase altfel citesc cuvinte pana cand se vor potrivi
            }
            game.getBoard().addWord(this, word);
            extracted.removeAll(extracted);
        }
        Thread.sleep(50);

    }

    public void setNrPoints(String word){
        int sum=0;
        for(int i=0;i<word.length();i++)
            sum=sum+game.getBag().getPointsOnLetter(word.charAt(i));
        this.nrPoints=nrPoints+word.length()*sum;
        //insumez nr de puncte pentru fiecare litera dupa care inmultesc cu lungimea cuvantului
    }


    public int getNrPoints() {
        return nrPoints;
    }


    @Override
    public void run() {
       /* try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread Interrupted");
        }*/

        try {
            submitWord();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //notify();
    }

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
