package lab10.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<String> personName=new ArrayList<>();
    private DataOutputStream out     = null;

    public boolean request(String line, Socket socket) throws IOException {
        out    = new DataOutputStream(socket.getOutputStream());

        if (line.contains("register"))
             //   register(line.substring(9));
            register();

        else
            if (line.contains("login"))
                login();
            else
                if (line.contains("friend"))
                    addFriend();
                else
                    if (line.contains("send"))
                        send();
                    else
                        if (line.contains("read"))
                            read();
                        else
                            return false;


        return true;
    }

    public void register(){
       // personName.add(name);
    }

    public void send(){

        ;
    }

    public void read(){

        ;
    }

    public void addFriend(){

        ;
    }

    public void login(){

        ;
    }
}
