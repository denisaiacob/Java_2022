package lab10.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class SocialNetwork {
    private List<Person> personList=new ArrayList<>();
    private String personName;

    public boolean request(String line, Socket socket) throws IOException {

        if (line.contains("register"))
            register(line.substring(9),socket);
        else
            if (line.contains("login")) {
                   if(!login(line.substring(6)))
                       return false;
            }
            else
                if (line.contains("friend"))
                    addFriend(line.substring(7));
                else
                    if (line.contains("send"))
                        send(line.substring(5));
                    else
                        if (line.contains("read"))
                            read(socket);
                        else
                            return false;
        return true;
    }

    public void register(String name,Socket socket){
        personList.add(new Person(name,socket));
    }

    public void send(String message) throws IOException {
        int indexPerson=0;
        DataOutputStream outMessage     = null;
        for (int i=0;i<personList.size();i++){
            if(personList.get(i).getName()==personName)
                indexPerson=i;
        }
        for(var friend:personList.get(indexPerson).getFriends()) {
            friend.addMessages(message);
            outMessage = new DataOutputStream(friend.getSocket().getOutputStream());
            outMessage.writeUTF(message);
        }
    }

    public void read(Socket socket) throws IOException {
        String line = "";
    }

    public void addFriend(String line){
        int indexPerson=0;
        String[] attributes = line.split(",");
        for (int i=0;i<personList.size();i++){
            if(personList.get(i).getName()==personName)
                indexPerson=i;
        }

        for(int i=0;i<attributes.length;i++){
            for(int j=0;j<personList.size();j++) {
                if (personList.get(j).getName() == attributes[i]) {
                    personList.get(indexPerson).addFriends(personList.get(j));
                }
            }
        }
    }

    public boolean login(String name){
        for(var p:personList){
            if(p.getName().equals(name)){
                this.personName=name;
                return true;
            }
        }
        return false;
    }
}
