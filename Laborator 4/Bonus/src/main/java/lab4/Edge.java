package lab4;

import java.util.ArrayList;
import java.util.List;

public class Edge {
    private int sourceVertex;
    private int targetVertex;

    public Edge(int sourceVertex, int targetVertex) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
    }

    public Edge(){}

    public void setSourceVertex(int sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public void setTargetVertex(int targetVertex) {
        this.targetVertex = targetVertex;
    }

    public int getSourceVertex() {
        return sourceVertex;
    }

    public int getTargetVertex() {
        return targetVertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "sourceVertex=" + sourceVertex +
                ", targetVertex=" + targetVertex +
                '}';
    }
}
