package lab3.model;

import java.util.List;

public class Router extends Node implements Identifiable {
    private String address;

    public Router(String name,String address){
        setName(name);
        this.address=address;
    }
    @Override
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "address='" + address + '\'' +
                '}';
    }

    @Override
    public void sort(List<Node> list) {

    }

    @Override
    public void sort(List<Node> list, Comparator<? super Node> c) {

    }

}
