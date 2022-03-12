package lab3;

import lab3.model.*;


public class Main {

    public static void main(String[] args) {
        Network nodes = new Network();
        //  Identifiable b =new Router("Router A");
        nodes.addNode(new Computer("Computer A"));
        nodes.addNode(new Router("Router A"));
        nodes.addNode(new Switch("Switch A"));
        nodes.addNode(new Switch("Switch B"));
        nodes.addNode(new Router("Router B"));
        nodes.addNode(new Computer("Computer B"));

        System.out.println(nodes.getNodes());

    }

}