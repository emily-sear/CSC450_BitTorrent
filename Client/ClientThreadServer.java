import java.net.*;

public class ClientThreadServer extends Thread
{
    private int listeningPort;


    public ClientThreadServer(int portNumber)
    {
        this.listeningPort = portNumber;
    }

    public void run()
    {
        try
        {
            ServerSocket ss = new ServerSocket(this.listeningPort);

            // listen for incoming peer connections 
            while(true)
            {
                Socket aNewPeer = ss.accept();
                (new ClientSendThread(aNewPeer)).start(); // listens for incoming byte request
                (new ClientRequestThread(aNewPeer)).start(); // sends byte requests to other clients
            }
        }
        catch(Exception e)
        {

        }
    }
}
