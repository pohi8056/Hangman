import java.net.*;
import java.io.*;
import java.util.*;

public class ConnectionHandler implements Runnable{
    Socket clientSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    DataOutputStream intOut = null;

    String inputLine; 
    int clientNumber = -1;

    public ConnectionHandler(Socket newSocket, int clientNumber){
	this.clientSocket = newSocket;
	this.clientNumber = clientNumber;
    }

    @Override
    public void run(){

	try{    
	    out = new PrintWriter(clientSocket.getOutputStream(), true);
	    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    intOut = new DataOutputStream(clientSocket.getOutputStream()); 
	}catch(IOException e){
	    System.err.println("I/O failed.");
	    System.exit(1);
	}
	out.println("    Hangman server: Player " + clientNumber + " connected.");
	try{
	    System.out.println(clientNumber);
	    intOut.writeInt(clientNumber);
	    while ((inputLine = in.readLine()) != null) 
	    { 
		System.out.println ("Player " + clientNumber + ": " + inputLine); 
		out.println(inputLine); 
	    }
	}catch(IOException e){
	    System.err.println("Failed reading line");
	    System.exit(1);
	}
    }
}
