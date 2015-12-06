
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String [] args) throws IOException{
	String hostName = "83.253.0.226";
	int portNumber = 9090;
	Socket clientSocket = null;
	int playerNumber = -1;
	Boolean enoughPlayers = false;
	int latestPlayer;
	ClientReader readThread =null;
	ObjectInputStream obIn = null;
	ObjectOutputStream obOut = null;
	Information info = new Information();
	long timeStart = 0;
	long timeStop = 0;
	String loggedUser;

	//Clear client terminal window.
	System.out.print("\033[H\033[2J");  
	System.out.flush();  

	System.out.println("Trying to connect to host: " + hostName + " on port: " + portNumber);
	
	try{
	    clientSocket = new Socket(hostName, portNumber);
	    obOut = new ObjectOutputStream(clientSocket.getOutputStream());
	    obIn = new ObjectInputStream(clientSocket.getInputStream());

	    readThread = new ClientReader(clientSocket, playerNumber, obIn);
	    readThread.start();
	} catch(UnknownHostException e){
	    System.err.println("Donno about the host:" + hostName);
	    System.exit(1);
	} catch(IOException e){
	    System.err.println("Couldn't get IO for the connection: " + hostName + e);
	    System.exit(1);
	}

	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	String userInput;
	String stringFromServer;
	while(playerNumber == -1){
	    playerNumber = readThread.getClientNumber();
	}
	/*
	Get logged in computer to use as name later.
       	loggedUser = System.getProperty("user.name");
	*/

	//write to server.

	while((userInput = stdIn.readLine()) != null){
	    info.setMsg(userInput);

	    //Read time since last math received.
	    timeStart = readThread.getTime();
	    timeStop = System.currentTimeMillis();
	    info.setTime((timeStop-timeStart)/1000.0);
	
	    obOut.writeObject(info); //send userinput to server
	    System.out.print("Player[" + playerNumber + "]: "); //input line
	    obOut.reset();

	}
	
	clientSocket.close();
	obIn.close();
	obOut.close();
    }
}
