package lab10.client;

import java.net.*;
import java.io.*;

public class Client
{
    private Socket socket            = null;
    private DataInputStream  inputkeyboard   = null;
    private DataInputStream  in   = null;
    private DataOutputStream out     = null;

    public Client(String address, int port)
    {
        // stabilire conexiune
        try
        {
            socket = new Socket(address, port);
           // System.out.println("Connected");

            inputkeyboard  = new DataInputStream(System.in);
            out    = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        String line = "";

        // va citi din terminal pana cand citeste "Exit"
        while (!line.equals("Exit"))
        {
            try
            {
                line = inputkeyboard.readLine();
                if(line.equals("Exit")){
                    System.out.println("Client exit");
                }
                else {
                    out.writeUTF(line);
                    line = in.readUTF();
                    System.out.println(line);
                }
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // inchide conexiunea
        try
        {
            inputkeyboard.close();
            out.close();
            in.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

}
