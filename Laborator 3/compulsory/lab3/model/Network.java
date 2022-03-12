package lab3.model;
import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    public Network(){
    }

    public void addNode(Computer computer) {
        nodes.add(computer);
    }
    public void addNode(Router router) {
        nodes.add(router);
    }
    public void addNode(Switch swit) {
        nodes.add(swit);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
