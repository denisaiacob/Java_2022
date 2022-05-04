package com.company;

public class Room {
    private String name;
    private RoomType type;
    private String capacity;

    public enum RoomType {
       LECTURE_HALL,
        COMPUTER_LAB
    }
    public Room(String name, RoomType type) {
        this.name = name;
        this.type = type;
    }
    public void setCapacity(RoomType type){

        if(type==RoomType.LECTURE_HALL){
            capacity="100";
        }
        else{
            if(type==RoomType.COMPUTER_LAB){
                capacity="30";
            }
        }
    }
    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", capacity='" + capacity + '\'' +
                "}";
    }

    public static void main(String[] args) {
        Room R1 = new Room("309", RoomType.LECTURE_HALL);
        Room R2 =new Room("401", RoomType.COMPUTER_LAB);
        Room R3 =new Room("403", RoomType.COMPUTER_LAB);
        Room R4 =new Room("405", RoomType.COMPUTER_LAB);
        R1.setCapacity(R1.type);
        R2.setCapacity(R2.type);
        R3.setCapacity(R3.type);
        R4.setCapacity(R4.type);
        System.out.println(R1);
        System.out.println(R2);
        System.out.println(R3);
        System.out.println(R4);
    }
}
