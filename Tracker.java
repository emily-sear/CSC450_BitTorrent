import java.net.*;
import java.io.*;


public class Tracker 
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket listener = new ServerSocket(6881);
        
        while(true)
        {
            Socket s = listener.accept();
            TrackerThread t = new TrackerThread(s);
            t.start();
        }
    }
}
