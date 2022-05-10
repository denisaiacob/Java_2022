package lab10.server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Server
{
    private Socket          socket   = null;
    private ServerSocket    server   = null;

    public Server(int port)
    {
        // porneste serverul si asteapta conexiunea
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            server.setReuseAddress(true);
            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            Communication com=new Communication();
            com.communicate(socket);
         /*   boolean stop=false;
            while (stop==false) {
                socket = server.accept();
                System.out.println("Client accepted");

                ClientHandler clientSock
                        = new ClientHandler(socket);

                new Thread(clientSock).start();
                if(clientSock.stop==true)
                    stop=true;
            }
*/
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

}