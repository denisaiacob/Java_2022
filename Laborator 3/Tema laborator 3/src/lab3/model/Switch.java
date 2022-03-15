package lab3.model;

import java.util.List;

public class Switch extends Node{
   public Switch(String name){
       setName(name);
    }

    @Override
    public void sort(List<Node> list) {
    }

    @Override
    public void sort(List<Node> list, Comparator<? super Node> c) {
    }
}
