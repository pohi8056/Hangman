
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String [] args) throws IOException{
	String hostName = "localhost";
	int portNumber = 9090;
	Socket clientSocket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	int playerNumber = 0;
	DataInputStream intIn = null;

	System.out.println("Trying to connect to host: " + hostName + " on port: " + portNumber);

	try{
	    clientSocket = new Socket(hostName, portNumber);
	    out = new PrintWriter(clientSocket.getOutputStream(), true);
	    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    intIn = new DataInputStream(clientSocket.getInputStream());
	} catch(UnknownHostException e){
	    System.err.println("Donno about the host:" + hostName);
	    System.exit(1);
	} catch(IOException e){
	    System.err.println("Couldn't get IO for the connection: " + hostName);
	    System.exit(1);
	}

	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	String userInput;
	//System.out.println("Select a difficulty level [0-2]: ");

	String stringFromServer;

	//Successful connection, welcome msg.
	playerNumber = intIn.readInt();
	stringFromServer = in.readLine();
	System.out.println(stringFromServer);

	//Read and write to server.
	while((userInput = stdIn.readLine()) != null){
	    System.out.println("Player " + playerNumber + ": ");
	    out.println(userInput);
	    stringFromServer = in.readLine();
	    System.out.println("Server: " + stringFromServer);
	}
	
	clientSocket.close();
	in.close();
	out.close();

    }





    // private Hangman hangman;

    // private BufferedReader in;

    // public String getUniqueLetters(String word) {

    // 	String empty = "";

    // 	for (int i = 0; i < word.length(); i++) {
    // 	    char character = word.charAt(i);
	    
    // 	}
    // }


}
