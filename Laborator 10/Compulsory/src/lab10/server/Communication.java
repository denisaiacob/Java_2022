package lab10.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Communication {
    private DataInputStream in       =  null;
    private DataOutputStream out     = null;

    public void communicate(Socket socket) throws IOException {
        in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));

        out    = new DataOutputStream(socket.getOutputStream());

        String line = "";
        SocialNetwork socialNetwork=new SocialNetwork();

        // citeste mesaje de la client pana primeste "Stop"
        while (!line.equals("Stop"))
        {
            try
            {
                line = in.readUTF();
                if(line.equals("Stop"))
                    out.writeUTF("Server stopped");
                else{
                    if(socialNetwork.request(line,socket))
                       out.writeUTF("Server received the request ... ");
                    else
                        out.writeUTF("Command not found");

                }
            }
            catch(IOException i) {
                System.out.println(i);
            }
        }
        in.close();
        out.close();
    }

}
