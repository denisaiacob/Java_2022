package lab4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i)).toArray(Intersection[]::new);
        List<Intersection> nodeList = new ArrayList<>();
        // nodeList.addAll( Arrays.asList(nodes) );
        Collections.addAll(nodeList, nodes);
        //am creat lista de noduri

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        int[] valori = {2, 2, 2, 2, 1, 3, 2, 3, 2, 1, 1, 2, 3, 1, 1, 1};
        //vector cu lungimile tuturor strazilor pentru a le crea

        var streets = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street("e" + i, valori[i])).toArray(Street[]::new);
        //am creat strazile

        cityMap.put(nodeList.get(0), Arrays.asList(streets[0], streets[1], streets[2]));
        cityMap.put(nodeList.get(1), Arrays.asList(streets[2], streets[4], streets[5]));
        cityMap.put(nodeList.get(2), Arrays.asList(streets[0], streets[3], streets[7]));
        cityMap.put(nodeList.get(3), Arrays.asList(streets[1], streets[3], streets[4],streets[6],streets[8]));
        cityMap.put(nodeList.get(4), Arrays.asList(streets[5], streets[6], streets[9],streets[12]));
        cityMap.put(nodeList.get(5), Arrays.asList(streets[7], streets[9], streets[10],streets[11]));
        cityMap.put(nodeList.get(6), Arrays.asList(streets[8], streets[13], streets[14]));
        cityMap.put(nodeList.get(7), Arrays.asList(streets[11], streets[12], streets[14],streets[15]));
        cityMap.put(nodeList.get(8), Arrays.asList(streets[10], streets[13], streets[15]));
        //am creat adiacentele

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

      //  for(Intersection i:intersections)
        for(int i =0;i<intersections.size();i++)
        {
            intersections.remove(nodeList.get(i));
            if(intersections.contains(nodeList.get(i)))
                System.out.println("HashSet-ul contine duplicate");
        }
        System.out.println("HashSet-ul nu contine duplicate");
        //am verificat daca exista duplicate

        /*
        for (Street street : streets) {
            nodeList.stream().filter(v -> cityMap.get(v).contains(street)).forEach(System.out::println);
        }
        for (int i = 0; i < streets.length-1; i++){
            for (int j = i+1; j < streets.length; j++) {
                List<Street> target = Arrays.asList(streets[i], streets[j]);
                List<Intersection> result = nodeList.stream().filter(v -> cityMap.get(v)
                                .containsAll(target))
                        .collect(Collectors.toList());
            }
        }
       */

    }
}
