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

        // gets the localhost and the IP Address
        output.println(Inet4Address.getLocalHost().getHostAddress());
         
        
        int length = Integer.parseInt(input.nextLine());

        ArrayList<String> listOfIPAddresses = new ArrayList<String>();
        for(int i = 0; i < length; i++)
        {
            listOfIPAddresses.add(input.nextLine());
        }


        for(int j = 0; j < listOfIPAddresses.size(); j++)
        {
            System.out.println(listOfIPAddresses.get(j));
        }
        System.out.println(input.nextLine()); 
    }

}
