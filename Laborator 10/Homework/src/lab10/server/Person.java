package lab10.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Socket socket;
    private List<Person>friends=new ArrayList<>();
    private List<String>messagesList=new ArrayList<>();

    public Person(String name,Socket socket){
        this.name=name;
        this.socket=socket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriends(Person friend) {
        friends.add(friend);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void addMessages(String message){
        messagesList.add(message);
    }
}
