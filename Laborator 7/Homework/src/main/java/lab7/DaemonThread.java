package lab7;

import java.util.Timer;
import java.util.TimerTask;

public class DaemonThread extends Thread
{
    private long timeLimit=30;// timpul limita in secunde

    public DaemonThread(String name){
        super(name);
    }

    public void run()
    {
        System.out.println("Durata jocului este de " + timeLimit +" secunde");
        long startTime = System.nanoTime();
        while (System.nanoTime()-startTime<timeLimit*1000000000){
            ;
        }
        System.out.println("Timpul s-a terminat ");
        System.exit(0);
    }

}
