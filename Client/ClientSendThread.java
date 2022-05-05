import java.net.*;
import java.io.*;
import java.util.*;

public class ClientSendThread extends Thread
{
    private Socket s; 

    public ClientSendThread(Socket s)
    {
        this.s = s;
    }

    public void run()
    {
        try 
        {   
            System.out.println("Client Send Thread started");
            Scanner input = new Scanner(this.s.getInputStream());
            //DataOutputStream outputBytes = new DataOutputStream(this.s.getOutputStream());
            PrintStream outputText = new PrintStream(this.s.getOutputStream());

            while(true)
            {
                 //wait for a request
                String byteNumber = input.nextLine(); // blocks 

                // check to see if we have that byteNumber and respond yes or no 
                boolean doIHaveByte = false;
                outputText.println("made it here");

                if(doIHaveByte)
                {
                    outputText.println("yes");

                    // actually send the byte 
                    byte b = 5; // place for the actual byte 

                    //outputBytes.writeByte(b);
                }
                else 
                {
                    outputText.println("no");
                }

            }
        }
        catch (Exception e)
        {

        }
    }
}
