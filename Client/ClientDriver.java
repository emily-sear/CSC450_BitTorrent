import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ClientDriver 
{
    private static String TRACKERIP = "localhost";
    private static int TRACKERPORT = 6881;
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket(TRACKERIP, TRACKERPORT);

        PrintStream output = new PrintStream(s.getOutputStream());
        Scanner input = new Scanner(s.getInputStream());
        Scanner userInput = new Scanner(System.in);

        // gets the localhost and the IP Address
        output.println(Inet4Address.getLocalHost().getHostAddress());
        String myPortNumber = input.nextLine();
        String listOfConnectedClients = input.nextLine();
        ClientCORE.updateTheConnectedClientIPS(listOfConnectedClients);
        
        // maintain the connection with the tracker to get updates on connected clients
        (new ClientTrackerListenerThread(input)).start();
        
        // create a server thread to establish connections with the Swarm 
        (new ClientThreadServer(Integer.parseInt(myPortNumber))).start();
        output.println(userInput.nextLine());


        while(true)
        {
            System.out.println(input.nextLine());
        }
    }

}
