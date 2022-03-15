package lab3.model;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(){

    }
    public void addNode(Node node) {
        nodes.add(node);
    }
    public void addCost(int index, Node key, int value)
    {
        nodes.get(index).setCost(key,value);
    }
    public String getName(int index)
    {
        return nodes.get(index).getName();
    }
    public Node getNode(int index)
    {
        return nodes.get(index);
    }

   public Node get(int index)
   {
       return nodes.get(index);
   }
    public List<Identifiable> sortIdentifiableNodes()
    {
        List<Identifiable> identifiableNodes = new ArrayList<>();
        for (var node : nodes)
        {
            if (node instanceof Identifiable)
            {
                identifiableNodes.add((Identifiable) node);
            }
        }
        identifiableNodes.sort((firstNode, secondNode) -> (int)( firstNode.getAddress()
                .compareTo(secondNode.getAddress()) ));

            System.out.println(identifiableNodes);
            return identifiableNodes;
    }

    /*public void determineDijkstra()
    {
        List<Identifiable> identifiableNodeCost = new ArrayList<>();
        identifiableNodeCost=sortIdentifiableNodes();
        identifiableNodeCost.sort((firstNode, secondNode) -> ( firstNode.getCost(firstNode)
                .compareTo(secondNode.getCost(secondNode)) ));

        for(var node:nodes)
        {
            if (node instanceof Identifiable)
            {
                List<Node> shortestsTimes = new ArrayList<>();
                shortestsTimes.add(node);
                for (int i=0;i< nodes.size();i++) {
                    for(var j:identifiableNodeCost)
                        if(nodes.get(i).getCost(j))
                }


                System.out.println(shortestsTimes+"\n");
            }
        }
    }*/

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
