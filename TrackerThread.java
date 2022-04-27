import java.net.*;
import java.util.*;
import java.io.*;

public class TrackerThread extends Thread
{
    private Socket theClient;
    private Scanner textInput;
    private PrintStream textOutput;
    
    public TrackerThread(Socket theClient)
    {
        try
        {
            this.theClient = theClient;
            this.textInput = new Scanner(this.theClient.getInputStream()); // reading in text 
            this.textOutput = new PrintStream(this.theClient.getOutputStream());
        }
        catch(Exception e)
        {

        }

    }

    public void run()
    {
        try{
            System.out.println("Tracker Thread Started...");

            // get the IP address of our connected client 
            // add it to our list of peers
            // then broadcast the current list of peers to this connected client 
            // also, broadcast the current list of peers to all previous clients 
            System.out.println("made it");
    
            String ipAddress = textInput.nextLine();

            this.textOutput.println("We have recieved your IP Address.. adding it to the list...");
    
            
            CORETORRENT.addIPAddressAndOutputStream(ipAddress, this.textOutput);
            
            System.out.println("We made it here");
            
            ArrayList<String> theListOfIPs = CORETORRENT.getTheList();
    
            System.out.println("We successfully got the list");
    
            this.textOutput.println(theListOfIPs.size());
    
            for(int i = 0; i < theListOfIPs.size(); i++)
            {
                this.textOutput.println(theListOfIPs.get(i));
            }
    
            System.out.println("We are done.");
    
            this.textOutput.println("The list is now with the client"); 
    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
    }
}
