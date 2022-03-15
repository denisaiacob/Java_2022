package lab3;
import lab3.model.*;

public class Main {
    public static void main(String[] args) {
        Network nodes = new Network();

        nodes.addNode(new Computer("Computer A"," 192.168.0.1",2));
        nodes.addNode(new Router("Router A"," 192.168.1.1"));
        nodes.addNode(new Switch("Switch A"));
        nodes.addNode(new Switch("Switch B"));
        nodes.addNode(new Router("Router B"," 192.168.1.2"));
        nodes.addNode(new Computer("Computer B"," 192.168.0.2",3));

        nodes.addCost(0,nodes.getNode(1),10);
        nodes.addCost(0,nodes.getNode(2),50);
        nodes.addCost(1,nodes.getNode(2),20);
        nodes.addCost(1,nodes.getNode(3),20);
        nodes.addCost(1,nodes.getNode(4),10);
        nodes.addCost(2,nodes.getNode(3),20);
        nodes.addCost(3,nodes.getNode(4),30);
        nodes.addCost(3,nodes.getNode(5),10);
        nodes.addCost(4,nodes.getNode(5),20);

        System.out.println(( (Computer)nodes.get(0)).getStorageCapacity());

        for(int i=0;i<6;i++)
        {
            System.out.println(nodes.getName(i)+ "--" + nodes.get(i).getCost()+"\n");
        }

        nodes.sortIdentifiableNodes();
    }

}
