import java.util.*;
import java.io.*;
import java.net.*;

public class CORE
{
    private static ArrayList<String> theClientIPAddresses = new ArrayList<String>();
    private static ArrayList<PrintStream> theClientPrintStreams = new ArrayList<PrintStream>();
    private static int currentClientPort = 3000;
    public static synchronized void addPrintStream(PrintStream ps)
    {
        CORE.theClientPrintStreams.add(ps);
    }

    public static synchronized int getNextClientPort()
    {
        return CORE.currentClientPort++;
    }

    public static void broadcastStringToClients(String s)
    {
        for(PrintStream ps : CORE.theClientPrintStreams)
        {
            ps.println(s);
        }
    }

    public static String getConnectedClientIPsString()
    {
        String answer = "";
        for(int i = 0; i < CORE.theClientIPAddresses.size(); i++)
        {
            if(answer.length() == 0)
            {
                answer = answer + CORE.theClientIPAddresses.get(i);
            }
            else 
            {
                answer = answer + ", " + CORE.theClientIPAddresses.get(i);
            }
        }
        return answer;
    }

    public static synchronized void changeConnectedClientIPs(String ip, boolean shouldAdd)
    {
        // if shouldAdd is true, we are adding the ip, else we are removing the IP
        if(shouldAdd)
        {
            CORE.theClientIPAddresses.add(ip);
        }
        else
        {
            for(int i = 0; i < CORE.theClientIPAddresses.size(); i++)
            {
                if(CORE.theClientIPAddresses.get(i).equals(ip))
                {
                    CORE.theClientIPAddresses.remove(i);
                    return;
                }
            }
        }
    }
}
