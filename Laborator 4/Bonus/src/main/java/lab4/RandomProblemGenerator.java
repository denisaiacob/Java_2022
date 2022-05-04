package lab4;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.*;

public class RandomProblemGenerator {

    private int nrVertices;
    private int nrEdges;
    private List<String>vertices=new ArrayList<>();
    private Map<Edge,Integer> edges=new HashMap<>();
    private static LinkedList<Integer> adjListsNew[];


    public void generate(){
        generateVertex();
        generateEdge();
        System.out.println("Numarul de noduri generate: "+ nrVertices);
        System.out.println("Numarul de muchii generate: " + nrEdges);
        System.out.println("Noduri:"+vertices);
        System.out.println("Muchii:" + edges);
    }

    private void generateVertex(){
        int randomNum=0;
        while(randomNum<3) {
            randomNum = (int) (Math.random() * 21);
        }
        this.nrVertices=randomNum;
        for(int i=0;i<nrVertices ;i++) {
            vertices.add("v"+i);
        }
    }
    private void generateEdge(){

        adjListsNew = new LinkedList[nrVertices];
        for (int j = 0; j <nrVertices ; j++) {
            adjListsNew[j] = new LinkedList<Integer>();
        }
        int randomNum=0;
        int maxEdges=nrVertices*(nrVertices-1)/2;
        while(randomNum<nrVertices-1) {
            randomNum = (int) (Math.random() * maxEdges);
        }
        nrEdges=randomNum;
        int sourceVertex=0;
        int targetVertex=0;

        for(int i=0;i<nrEdges;i++) {
            int ok=0;
            Edge edge=new Edge();
            Edge reverseEdge=new Edge();
            while (ok==0){
                sourceVertex = (int) (Math.random() * nrVertices);
                targetVertex= (int) (Math.random() * nrVertices);
                if(sourceVertex!=targetVertex){
                    edge.setSourceVertex(sourceVertex);
                    edge.setTargetVertex(targetVertex);
                    reverseEdge.setSourceVertex(targetVertex);
                    reverseEdge.setTargetVertex(sourceVertex);
                    if(!edges.containsKey(edge)){
                        ok=1;
                    }
                }
            }//am randomizat cele 2 capete ale muchiei

            int val=0;
            ok=0;
            while (val<1 && ok==0){
                val = (int) (Math.random() * 7);
                for(int j=0;j<nrVertices;j++) {
                    if ( j==(nrVertices-1) ||
                            j<adjListsNew[targetVertex].size() && adjListsNew[sourceVertex].contains(adjListsNew[targetVertex].get(j))) {
                        Edge l1 = new Edge(sourceVertex, j);
                        Edge l2 = new Edge(targetVertex, j);
                        if (j==(nrVertices-1)|| edges.containsKey(l1) && edges.containsKey(l2) &&
                                val <= edges.get(l1) + edges.get(l2) ) {
                            ok = 1;
                            edges.put(edge, val);
                            edges.put(reverseEdge, val);
                            adjListsNew[sourceVertex].add(targetVertex);
                            adjListsNew[targetVertex].add(sourceVertex);
                        }
                    }
                }
            }//am randomizat costul muchiei

        }
    }

    @Override
    public String toString() {
        return "RandomProblemGenerator{" +
                "nrVertices=" + nrVertices +
                ", nrEdges=" + nrEdges +
                ", vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }
}
