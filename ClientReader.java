import java.io.*;
import java.util.*;
import java.net.*;

public class ClientReader extends Thread{
    Socket socket;
    String strFromServer;
    int playerNumber;
    ObjectInputStream obIn;
    Information info;
    Math math;
    int clientNumber;
    long timeStart;
    public ClientReader(Socket socket, int pn, ObjectInputStream obIn){
	this.socket = socket;
	
	this.playerNumber = pn;
	this.obIn = obIn;

	try{
	    info = (Information) obIn.readObject();
	    clientNumber = info.getClientNumber();
	} catch(IOException e){
	    System.out.println("nope,,,,, failed " + e);
	} catch(ClassNotFoundException e){
	    System.out.println("superfail "+e);
	}
    }

    public int getClientNumber(){
	return clientNumber;
    }
    

    public long getTime(){
	return timeStart;
    }

    @Override
    public void run(){
    
	while(true){
	    try{
		//loop forever, reading from server.
		info = (Information) obIn.readObject();

		switch(info.getTypeOfMsg()){
		case 1:
		    strFromServer = info.getMsg();
		    System.out.println(strFromServer);
		    System.out.print("Player[" + clientNumber + "]: ");
		    break;

		case 2:
		    timeStart = System.currentTimeMillis();
		    math = info.getMath();
		    System.out.println(math);

		    System.out.print("Player[" + clientNumber + "]: ");
		    break;
		}


	    } catch(IOException e){
		System.err.println("Went wrong in Clientreader when looping" + e);
		System.exit(1);
	    } catch (ClassNotFoundException e){
		System.out.println("Cannot find the class" + e);
	    }
	}
	
    }
}
