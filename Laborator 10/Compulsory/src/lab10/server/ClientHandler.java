package lab10.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    public boolean stop=false;

    // Constructor
    public ClientHandler(Socket socket)
    {
        this.socket = socket;
    }

    public void run()
    {
         DataInputStream in       =  null;
         DataOutputStream out     = null;
        try {
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out    = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";

        // citeste mesaje de la client pana primeste "Stop"
        while (!line.equals("Stop"))
        {
            try
            {
                line = in.readUTF();
                if(line.equals("Stop")) {
                    out.writeUTF("Server stopped");
                    this.stop=true;
                } else{
                    out.writeUTF("Server received the request ... ");
                }
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
                //inchide conexiunea
                socket.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
