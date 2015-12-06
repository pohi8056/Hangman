import java.net.*;
import java.io.*;
import java.util.*;

public class ConnectionHandler extends Thread{
    Socket clientSocket = null;
    String inputLine; 
    int clientNumber = -1;
    Information info = new Information();
    ObjectOutputStream obOut;
    ObjectInputStream obIn;
    double timeFromClient;
    Boolean active = true;
    public ConnectionHandler(Socket newSocket, int clientNumber){

	this.clientSocket = newSocket;
	this.clientNumber = clientNumber;

	try{    
	    obOut = new ObjectOutputStream(clientSocket.getOutputStream());
	    obIn = new ObjectInputStream(clientSocket.getInputStream());
	    info.setClientNumber(clientNumber);
	    //obOut.writeObject(info);
	}catch(IOException e){
	    System.err.println("I/O failed." + e);
	    System.exit(1);
	}
    }

    public void broadcastMath(Information info){
	try{
	    if(info != null){
		obOut.writeObject(info);
		obOut.reset();
	    }
	} catch(IOException e){
	    System.out.println("broadcastmath failed...Client: " + clientNumber + "Error: " + e);
	}
    }

    //Send msg to client
    public synchronized void broadcast(String msg){
	try{
	    if(msg != null){

		info.setMsg(msg);
		obOut.writeObject(info);

		//obOut.flush();
	    }
	} catch(IOException e){
	    System.out.println("broadcasterror " + e);
	}
	try{
	    obOut.reset();
	} catch(IOException e){
	    System.out.println("trouble resetting " + e);
	}
    }

    public int getClientNumber(){
	return clientNumber;
    }

    public String getString(){
	if(inputLine != null){
	    return inputLine;
	}else{
	    return "0";
	}
    }


    public double getDelay(){
	if(timeFromClient != -1){
	    return timeFromClient;
	}else{
	    return -1;
	}
    }
    
    public void closeStreams(){
	try{
	    obOut.close();
	    obIn.close();
	    clientSocket.close();
	} catch(IOException e){
	    System.out.println("Failed closing streams. "+e);
	}
    }
    
    public Boolean isActive(){
	return active;
    }

    @Override
    public void run(){
	while (true){ 	    
	    try{
		//run forever
		info = (Information) obIn.readObject();
		
		if(info != null){
		    timeFromClient = info.getTime();
		    inputLine = info.getMsg();
		    //System.out.println("time: " + timeFromClient);
		    System.out.println ("Player " + clientNumber + ": " + inputLine);
		}
	    
	    }catch(IOException e){
		System.err.println("Failed reading line from client: " + clientNumber + " Error: " + e + " .Closing sockets...");
		closeStreams();
		active = false;
		break;
		//System.exit(1);
	    } catch(ClassNotFoundException e){
		System.out.println("Could not read class " + e);
	    }
	}
    }
}
