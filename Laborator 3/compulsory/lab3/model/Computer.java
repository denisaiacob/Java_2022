package lab3.model;



public class Computer extends Node implements Identifiable, Storage {
        private String address;
        private int storageCapacity;


        public Computer(String name){
            setName(name);
        }
        public Computer(){}

        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public void setStorageCapacity(int storageCapacity)
        {
            this.storageCapacity=storageCapacity;
        }
        @Override
        public int getStorageCapacity() {
            return storageCapacity;
        }

        @Override
        public int compareTo(Location o) {
            return 0;
        }
    }

