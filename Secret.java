import java.io.*;
import java.util.*;


public class Secret{

    private int level;
    private String secret_word;
    private int randomInt;
    private int maxLetters;
    private int minLetters;
    private int wordsInList = 24;

    public Secret(int level){
	this.level = level;
    }

    private void setMaxLetters(int level){
	
	switch(level){ 
	case 0: //EASY
	    minLetters = 1;
	    maxLetters = 3;
	    break;
	case 1:
	    //INTERMEDIATE
	    minLetters = 3;
	    maxLetters = 7; 
	    break;
	case 2: //HARD
	    minLetters = 7;
	    maxLetters = 16;
	    break;
	default:
	    minLetters = 1;
	    maxLetters = 20;
	    break;
	}
    }

    
    public int getLevel(){
	return level;
    }


    private void randomizeInt(){
	Random rand = new Random();
	this.randomInt = rand.nextInt(wordsInList);
    }


    public String loadWord() throws IOException{
	String temp_word;
	FileReader fileReader = new FileReader("words.txt");
	BufferedReader buffReader = new BufferedReader(fileReader);
	randomizeInt();
	setMaxLetters(level);

	/*
	  Som det är nu måste orden i words.txt vara var tredje i svårhetsgrad för att det ska bli jämn fördelning av sannolikhet.
	 */
	for(int i = 0; i <= randomInt; i++){
	    temp_word = buffReader.readLine();
	    //System.out.println(temp_word);
	    if((temp_word.length() <= maxLetters) && (minLetters <= temp_word.length())){
		secret_word = temp_word;
	    }
	}
	System.out.println("SECRET:" + secret_word);
	return secret_word;
    }

    public String getWord(){
	return secret_word;
    }


}
