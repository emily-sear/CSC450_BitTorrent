import java.util.*;
import java.io.*;
import java.net.*;

public class CORETORRENT
{
    private static ArrayList<String> theClientIPAddresses = new ArrayList<String>();
    private static ArrayList<PrintStream> theClientOutputStreams = new ArrayList<PrintStream>();

    public synchronized static void addIPAddressAndOutputStream(String ipAddress, PrintStream outputStream)
    {
        broadcastNewPerson(ipAddress);
        
        theClientIPAddresses.add(ipAddress);
        theClientOutputStreams.add(outputStream);


    }

    public synchronized static void printTheIPAddresses()
    {
        for (String ip : theClientIPAddresses)
        {
            System.out.println(ip);
        }
    }
    
    private synchronized static void broadcastNewPerson(String ipAddress)
    {
        for(int i = 0; i < theClientOutputStreams.size(); i++)
        {
            theClientOutputStreams.get(i).println(ipAddress);
        }
    }

    public synchronized static void broadcastFullList()
    {
        for(int i = 0; i < theClientOutputStreams.size(); i++)
        {
            for (int j = 0; j < theClientIPAddresses.size(); j++)
            {
                theClientOutputStreams.get(i).println(theClientIPAddresses.get(j));
            }
        }
    }
    public synchronized static ArrayList<String> getTheList()
    {
        return theClientIPAddresses;
    }
}
