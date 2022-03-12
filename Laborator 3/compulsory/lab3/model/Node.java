package lab3.model;


import java.util.Map;
import java.util.HashMap;

public abstract class Node implements Comparable<Location> {
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node(){

    }
   public void setName(String name)
   {
       this.name=name;
   }
    public String getName() {
        return name;
    }
    public Map<Node, Integer> getCost() {
        return cost;
    }
    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }


}