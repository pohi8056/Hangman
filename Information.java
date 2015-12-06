import java.util.*;
import java.io.*;
import java.net.*;

public class Information implements Serializable{
    protected static final long serialVersionUID = 1112122200L;

    String msg;
    double time = -1;
    Boolean changed = false;
    Math math;
    int clientNumber;
    int type; //1 = string, 2 = math, 3 = clientnumber int, 4 = time long.

    public Information(){
	this.type = 1;
    }

    public Information(int type){
	this.type = type;
    }
    
    public void setTypeOfMsg(int type){
	this.type = type;
    }

    public int getTypeOfMsg(){
	return this.type;
    }

    public void setMsg(String msg){
	this.msg = msg;
    }

    public String getMsg(){
	return msg;
    }

    public void setMath(Math math){
	this.math = math;
    }

    public Math getMath(){
	return math;
    }

    public void setTime(double time){
	this.time = time;
    }

    public double getTime(){
	return time;
    }

    public void setClientNumber(int c){
	clientNumber = c;
    }
    public int getClientNumber(){
	return clientNumber;
    }

}
