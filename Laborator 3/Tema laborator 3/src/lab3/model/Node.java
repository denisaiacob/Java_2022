package lab3.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }
    public int getCost(Node node) {
        return cost.get(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;
        return cost.equals(node.cost);
    }

}
