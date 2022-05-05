import java.net.*;
import java.io.*;
import java.util.*;

public class ClientRequestThread extends Thread
{
    private Socket s; 

    public ClientRequestThread(Socket s)
    {
        this.s = s;
    }

    public void run()
    {
       try 
       {
           System.out.println("Client Request Thread Started");
           Scanner input = new Scanner(this.s.getInputStream());
           PrintStream output = new PrintStream(this.s.getOutputStream());

           while(true)
           {
               // send request 
               int byteNumber = 8;
               output.println(byteNumber);

               String answer = input.nextLine();
               if(answer.equals("yes"))
               {
                   String bytes = input.nextLine();
               }
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }

        
    }
}
