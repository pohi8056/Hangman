import java.io.*;
import java.util.*;

public class ServerInfo implements Serializable{

    private int numberOfPlayers = 0;
    private int latestPlayer;

    public void increaseNumberOfPlayers(){
	synchronized(this){
	    this.numberOfPlayers++;
	}
    }

    public void setLatestPlayer(int latestPlayer){
	this.latestPlayer = latestPlayer;
    }

    public int getLatestPlayer(){
	return this.latestPlayer;
    }

    public int getNumberOfPlayers(){
	return this.numberOfPlayers;
    }

}
