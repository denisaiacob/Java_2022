package lab10.server;

import java.net.*;
import java.io.*;

public class Server
{
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    public static boolean acceptConection=true;

    public Server(int port) throws IOException {
        // porneste serverul si asteapta conexiunea
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            while (acceptConection) {
                server.setReuseAddress(true);
                System.out.println("Waiting for a client ...");

                socket = server.accept();
                if(acceptConection) {
                    System.out.println("Client accepted");

                        new ClientThread(socket).start();
                }
                else
                    System.exit(0);
                //   Communication com = new Communication();
              //  com.communicate(socket);
            }
           // socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        } finally {
            server.close();
        }

    }

}