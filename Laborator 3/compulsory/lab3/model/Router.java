package lab3.model;

public class Router extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    public Router(String name){
        setName(name);
    }


    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public int getStorageCapacity() {
        return 0;
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }
}
