package com.company;

public class Event {
    private String name;
    private int size;
    private int start;
    private int end;

    public Event(){
    }
    public Event(String name) {

        this.name = name;
    }
    public void setSize(int size) {
        this.size=size;
    }
    public void setInterval(int start,int end){
        this.start=start;
        this.end=end;
    }
    public void setName(String name){

        this.name=name;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String args[]) {
        Event c1 = new Event();
        c1.setName("C1");
        c1.setSize(100);
        c1.setInterval(8,10);
        Event c2 = new Event();
        c2.setName("C2");
        c2.setSize(100);
        c2.setInterval(10,12);
        Event l1 = new Event();
        l1.setName("L1");
        l1.setSize(30);
        l1.setInterval(8,10);
        Event l2 = new Event();
        l2.setName("L2");
        l2.setSize(30);
        l2.setInterval(8,10);
        Event l3 = new Event();
        l3.setName("L3");
        l3.setSize(30);
        l3.setInterval(10,12);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }
}
