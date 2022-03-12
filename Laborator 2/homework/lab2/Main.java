package lab2;

import lab2.alg.Algorithm;
import lab2.alg.GreedyAlgorithm;
import lab2.alg.Solution;
import lab2.model.*;

public class Main {
    public static void main(String args[]) {

        Problem pb = new Problem();
        Room[] rooms = new Room[4];
        rooms[0]= new ComputerLab("401", 30);
        rooms[1]= new ComputerLab("405",30);
        rooms[2]= new ComputerLab("403",30);
        rooms[3]= new LectureHall("309", 100);

        Event[] events = new Event[5];
        for(int i=0; i< 5; i++)
        {
            events[i]=new Event();
        }
        events[0].addEvent("C1",100,8,10);
        events[1].addEvent("C2",100,10,12);
        events[2].addEvent("L1",30,8,10);
        events[3].addEvent("L2",30,8,10);
        events[4].addEvent("L3",30,10,12);

        /*events[0].setName("C1");
        events[0].setSize(100);
        events[0].setInterval(8,10);
        events[1].setName("C2");
        events[1].setSize(100);
        events[1].setInterval(10,12);
        events[2].setName("L1");
        events[2].setSize(30);
        events[2].setInterval(8,10);
        events[3].setName("L2");
        events[3].setSize(30);
        events[3].setInterval(8,10);
        events[4].setName("L3");
        events[4].setSize(30);
        events[4].setInterval(10,12);
*/
        pb.newProblem(events,rooms);
        System.out.println(pb);
        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution sol = greedy.solve();
        System.out.println(sol);

    }
}
