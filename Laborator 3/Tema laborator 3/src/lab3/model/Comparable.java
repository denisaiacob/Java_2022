package lab3.model;

import java.util.Collections;
import java.util.List;

public interface Comparable<N> {
    int compareTo(Node other);
    //Collections.sort(Node items);
   void sort(List<Node> list);
    void sort(List<Node> list, Comparator<? super N> c);
}
