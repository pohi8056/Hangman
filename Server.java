import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

public class Server{
    ConnectionHandler connectionHandler;
    ConnectionHandler currentThread;
    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    int port = 9090;
    int clientNumber = 1;
    int maxClients = 3;
    String clientString;
    Math m;
    int ans;
    int correctClient = -1;
    Information info;
    ObjectOutputStream obOut = null;
    ObjectInputStream obIn = null;
    double time;

    ArrayList<ConnectionHandler> threadList = new ArrayList<ConnectionHandler>();

    public void loopClients(){

	for(int i = 0; i < threadList.size(); i++){
	    currentThread = threadList.get(i);
	    if(currentThread != null){
		currentThread.broadcast("Player[" + clientNumber + "] connected!");
		
		if(clientNumber < maxClients){
		    currentThread.broadcast("Waiting for " + (maxClients-clientNumber) + " additional client(s)....");
		}else{
		    currentThread.broadcast("All players ("+ maxClients +") connected. Starting the game...");
		}
	    }
	}	
    }
    

    public int sendMath(){
	m = new Math();
	m.generateMath();
	System.out.println(m.toString());
	info.setMath(m);
	info.setTypeOfMsg(2);
	currentThread = null;
	for(int i = 0; i < threadList.size(); i++){
	    currentThread = threadList.get(i);
	    if(currentThread != null){
		currentThread.broadcastMath(info);
	    }
	}
	int answer = m.getAnswer();
	return answer;
    }


     public void checkActive(){
	 int client;
	 currentThread = null;
	 
	 for(int i = 0; i < threadList.size(); i++){
	     currentThread = threadList.get(i);
	     if(currentThread != null && currentThread.isActive() == false){
		 client = currentThread.getClientNumber();
		 threadList.remove(i);
		 broadcastToAll("Player[" + client + "] disconnected.");
		 System.out.println("[Player " + client + "] Disconected from server.");
	     }
	 }	 
     }


    public int listenForAnswers(int answer){
	Boolean correct = false;
	currentThread = null;
	String inputAns;
	int ia;

	while(correct == false){
	    checkActive();
	    for(int i = 0; i < threadList.size(); i++){
		currentThread = threadList.get(i);
		if(currentThread != null){
		    inputAns = currentThread.getString();
		    ia = Integer.parseInt(inputAns);
		    if(ia == answer){
			time = currentThread.getDelay();
			correctClient = currentThread.getClientNumber();
			correct = true;
		    }
		}
	    }
	}
	return correctClient;
    }

    public void broadcastToAll(String str){
	currentThread = null;
	for(int i = 0; i < threadList.size(); i++){
	    currentThread = threadList.get(i);
	    if(currentThread != null){
		currentThread.broadcast(str);
	    }
	}
    }
    

    public void runServer() throws IOException{

	//Create new serversocket
	try{
	    serverSocket = new ServerSocket(port);


	} catch(IOException e){
	    System.err.println("Could not listen on port" + port);
	}
	
	System.out.println("Waiting for an incoming connection.....");
	
	//Keep listening for new clients forever or until max
	while(clientNumber <= maxClients){
	    try{
		clientSocket = serverSocket.accept();
		info = new Information();
		connectionHandler = new ConnectionHandler(clientSocket, clientNumber);
		threadList.add(connectionHandler);
		connectionHandler.start();
	    } catch (IOException e){
		System.err.println("Failed to accept incoming connection.");
		System.exit(1);
	    }
	    
	    System.out.println("[Player "+ clientNumber + "] Connection successful!");
	    System.out.println("[Player "+ clientNumber + "] Waiting for input from client...");
	    //Send connection info to all clients
	    loopClients();
	    clientNumber++;
	}
	while(true){
	    int mathAns = sendMath();
	    listenForAnswers(mathAns);
	    broadcastToAll("Player " + correctClient + " entered the correct answer " + mathAns + " and received the key. Time: " + time + "s");
	}
    }

}
