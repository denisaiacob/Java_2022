package lab4;

import com.github.javafaker.Faker;
import org.jgrapht.graph.*;

import java.lang.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i)).toArray(Intersection[]::new);
        List<Intersection> nodeList = new ArrayList<>();
        Collections.addAll(nodeList, nodes);
        //am creat lista de noduri

        City cityMap = new City();
        int[] valori = {2, 2, 2, 2, 1, 3, 2, 3, 2, 1, 1, 2, 3, 1, 1, 1};
        //vector cu lungimile tuturor strazilor pentru a le crea

        var streets = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street("e" + i,valori[i])).toArray(Street[]::new);
        //am creat strazile
        {
            streets[0].setAdjacency(nodes[0], nodes[2]);
            streets[1].setAdjacency(nodes[0], nodes[3]);
            streets[2].setAdjacency(nodes[0], nodes[1]);
            streets[3].setAdjacency(nodes[2], nodes[3]);
            streets[4].setAdjacency(nodes[1], nodes[3]);
            streets[5].setAdjacency(nodes[1], nodes[4]);
            streets[6].setAdjacency(nodes[3], nodes[4]);
            streets[7].setAdjacency(nodes[2], nodes[5]);
            streets[8].setAdjacency(nodes[3], nodes[6]);
            streets[9].setAdjacency(nodes[0], nodes[2]);
            streets[10].setAdjacency(nodes[0], nodes[2]);
            streets[11].setAdjacency(nodes[0], nodes[2]);
            streets[12].setAdjacency(nodes[0], nodes[2]);
            streets[13].setAdjacency(nodes[0], nodes[2]);
            streets[14].setAdjacency(nodes[0], nodes[2]);
            streets[15].setAdjacency(nodes[0], nodes[2]);

            cityMap.put(nodeList.get(0), Arrays.asList(streets[0], streets[1], streets[2]));
            cityMap.put(nodeList.get(1), Arrays.asList(streets[2], streets[4], streets[5]));
            cityMap.put(nodeList.get(2), Arrays.asList(streets[0], streets[3], streets[7]));
            cityMap.put(nodeList.get(3), Arrays.asList(streets[1], streets[3], streets[4], streets[6], streets[8]));
            cityMap.put(nodeList.get(4), Arrays.asList(streets[5], streets[6], streets[9], streets[12]));
            cityMap.put(nodeList.get(5), Arrays.asList(streets[7], streets[9], streets[10], streets[11]));
            cityMap.put(nodeList.get(6), Arrays.asList(streets[8], streets[13], streets[14]));
            cityMap.put(nodeList.get(7), Arrays.asList(streets[11], streets[12], streets[14], streets[15]));
            cityMap.put(nodeList.get(8), Arrays.asList(streets[10], streets[13], streets[15]));
        }//am creat adiacentele

        List<Street> streetList = new LinkedList<>();
        Collections.addAll(streetList, streets);

        List<Street> newSortedList = streetList.stream()
                .sorted(Comparator.comparing(Street::getLength)).collect(Collectors.toList());
        //am sortat strazile dupa lungime

        HashSet<Intersection> intersections = new HashSet<>();
        intersections.add(nodeList.get(0));
        intersections.add(nodeList.get(1));
        intersections.add(nodeList.get(0));
        intersections.add(nodeList.get(2));
        //am creat HashSet de intersectii

        for(int i =0;i<intersections.size();i++)
        {
            intersections.remove(nodeList.get(i));
            if(intersections.contains(nodeList.get(i)))
                System.out.println("HashSet-ul contine duplicate");
        }
        System.out.println("HashSet-ul nu contine duplicate");
        //am verificat daca exista duplicate

       int specifiedValue=0;
        streetList.stream()
                .filter(v -> ((cityMap.getCity()).get(v.getV1()).size()
                        + (cityMap.getCity()).get(v.getV2()).size() > 5)
                        && v.getLength() > specifiedValue)
                .forEach(System.out::println);

        fake(nodeList,streetList);
        //am creat numele fake
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph= createGraf(nodeList);
       //am creat graful
        List<String> mst=new ArrayList<>();
        mst= primAlg(graph);
        //cu primAlg aplicam algoritmul lui Prim pe graful creat anterior
    }
    public static void fake(List<Intersection>nodeList,List<Street>streetList){
        List<String> fakeNameIntersection = new ArrayList<>();
        List<String> fakeNameStreet = new ArrayList<>();
        Faker faker = new Faker();
        for(Intersection i:nodeList) {
            fakeNameIntersection.add(faker.name().name());
        }
        for(Street s:streetList)
        {
            fakeNameStreet.add(faker.name().name());
        }
        System.out.println("Numele fake ale intersectiilor" + fakeNameIntersection + "\n");
        System.out.println("Numele fake ale strazilor" + fakeNameStreet + "\n");

    }
    public static SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> createGraf(List<Intersection> nodeList){
        SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> g =
                new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);


        for(int i=0;i< nodeList.size();i++) {
            g.addVertex("v"+i);
        }
        DefaultWeightedEdge e0 =g.addEdge("v0", "v1");
        g.setEdgeWeight(e0, 2);
        DefaultWeightedEdge e1 =g.addEdge("v0", "v2");
        g.setEdgeWeight(e1, 2);
        DefaultWeightedEdge e2 =g.addEdge("v0", "v3");
        g.setEdgeWeight(e2, 2);
        DefaultWeightedEdge e3= g.addEdge("v1", "v4");
        g.setEdgeWeight(e3, 3);
        DefaultWeightedEdge e4=g.addEdge("v1", "v3");
        g.setEdgeWeight(e4, 1);
        DefaultWeightedEdge e5= g.addEdge("v2", "v5");
        g.setEdgeWeight(e5, 3);
        DefaultWeightedEdge e6=g.addEdge("v2", "v3");
        g.setEdgeWeight(e6, 2);
        DefaultWeightedEdge e7=g.addEdge("v3", "v4");
        g.setEdgeWeight(e7, 2);
        DefaultWeightedEdge e8=g.addEdge("v3", "v6");
        g.setEdgeWeight(e8, 2);
        DefaultWeightedEdge e9=g.addEdge("v4", "v5");
        g.setEdgeWeight(e9, 1);
        DefaultWeightedEdge e10=g.addEdge("v4", "v7");
        g.setEdgeWeight(e10, 3);
        DefaultWeightedEdge e11=g.addEdge("v5", "v8");
        g.setEdgeWeight(e11, 1);
        DefaultWeightedEdge e12=g.addEdge("v5", "v7");
        g.setEdgeWeight(e12, 2);
        DefaultWeightedEdge e13=g.addEdge("v6", "v7");
        g.setEdgeWeight(e13, 1);
        DefaultWeightedEdge e14=g.addEdge("v6", "v8");
        g.setEdgeWeight(e14, 1);
        DefaultWeightedEdge e15=g.addEdge("v7", "v8");
        g.setEdgeWeight(e15, 1);

        return g;
    }
    public static List<String> primAlg(SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph){
      Map<String,Boolean> visited=new HashMap<>();
      List<String> startVertex=new ArrayList<>();
      String vertexAdd ="v0";
        startVertex.add(vertexAdd);
      List<String> mst=new ArrayList<>(); //lista de varfuri in ordinea in care au fost parcurse de algoritm
        List<DefaultWeightedEdge> edgeList=new ArrayList<>(); // lista de muchii in ordinea parcurgerii de catre algoritm

        mst.add(vertexAdd);

      for(String i: graph.vertexSet())
      {
          visited.put(i,false);
      }
      visited.replace(vertexAdd,true);
      int ok=0; // il folosim pentru a sti cand au fost vizitate toate nodurile

        int costMin=-1;
        while(ok==0) {
             costMin=-1;
             for(String j:startVertex) {
                 for (DefaultWeightedEdge i : graph.edgesOf(j)) {
                     if (costMin == -1 || graph.getEdgeWeight(i) < costMin) {
                         if (visited.get(graph.getEdgeTarget(i)) == false) {
                             costMin = (int) graph.getEdgeWeight(i);
                             vertexAdd = graph.getEdgeTarget(i);
                             edgeList.add(i);
                         }
                     }
                 }
             }
            //am cautat muchia cu costul minim dintre cele care au o extremitate in startVertex
            //si i-am salvat varful din cealalta extremitate

            mst.add(vertexAdd);
            startVertex.add(vertexAdd);
            //am adaugat cealalta extremitate in mst apoi am atribuit nodului de inceput startVertex, valoarea acestuia
            visited.replace(vertexAdd,true);

            if(visited.containsValue(false)) {
                ok = 0;
            }
            else {
                ok = 1;
            }
        }
        System.out.println("Lista de intersectii in ordinea parcurgerii"+ mst);
        System.out.println("Lista de strazi in ordinea parcurgerii"+ edgeList);
        return mst;
    }
}
