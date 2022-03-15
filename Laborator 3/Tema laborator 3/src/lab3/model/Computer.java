package lab3.model;

import java.util.List;

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    public Computer(String name,String address, int storgeCapacity) {
        setName(name);
        this.address=address;
        this.storageCapacity=storgeCapacity;
    }

    @Override
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getStorageCapacity()
    {
        int gb = storageCapacity;
        long mb = gb * 1024;
        long kb = mb * 1024;
        long by = kb * 1024;
        System.out.println("Capacitatea de stocare in byte: "+by +"\n"+
                "Capacitatea de stocare in kilobyte: " + kb + "\n" +
                "Capacitatea de stocare in megabyte: " + mb + "\n" +
                "Capacitatea de stocare in gigabyte: " + storageCapacity);
        return gb;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "address='" + address + '\'' +
                ", storageCapacity=" + storageCapacity +
                '}';
    }

    @Override
    public void sort(List<Node> list) {

    }

    @Override
    public void sort(List<Node> list, Comparator<? super Node> c) {

    }
}
