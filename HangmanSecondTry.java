import java.io.*;
import java.net.*;
import java.util.*;

public class HangmanSecondTry {
    
    private String theWord;
    private String input;
    
    private boolean rightGuessedWord = false;
    private boolean rightGuessedChar = false;
    
    private int numberOfGuesses;
    private int charsLeftToGuess;
    
    private char[] arrayOfTheWord;
    private char[] guessedChar;

   

    public HangmanSecondTry(int numberOfGuesses, String theWord){
	
	this.numberOfGuesses = numberOfGuesses;
	this.theWord = theWord;
        this.charsLeftToGuess = theWord.length();
	this.arrayOfTheWord = theWord.toCharArray();
	this.guessedChar = new char[arrayOfTheWord.length];
	signs();
    }

    private void signs(){
	for (int i=0; i<guessedChar.length; i++) {
	    guessedChar[i] = '-';
	}
    }

    private void setTheWord(String theWord){
	this.theWord = theWord;
    }

    private void setInput(String input){
	this.input = input;
    }

    private void printGuessedChars (char[] guessedChar) {
       
	for (int i=0; i<guessedChar.length; i++) {
            System.out.print(guessedChar[i]);
        }
        System.out.println();
    }

    private int numberOfCharsLeft(char[] guessedChar) {
        
	int stillLeft = 0;
        
        for (int i=0; i<guessedChar.length; i++) {
            if(guessedChar[i] == '-') {
		stillLeft++;
	    }       
	}
	return stillLeft;
    }
    
    private void printGuessings(int numberOfGuesses, char[] guessedChar) {
        
	for (int i=0; i<guessedChar.length; i++) {
            System.out.print(guessedChar[i]);
        }

        System.out.println("Number of guesses left: " + numberOfGuesses);
        System.out.println("Guess another letter: ");
    }

    private void printTheHangman() {

	switch ((10-numberOfGuesses)){
	case 1: 
	    System.out.println("        ______            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 2: 
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 3: 
	    System.out.println("         _________        ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 4: 
	    System.out.println("         _________        ");
	    System.out.println("         | /              ");
	    System.out.println("         |/               ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 5: 
	    System.out.println("         _________        ");
	    System.out.println("         | /     |        ");
	    System.out.println("         |/      |        ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 6: 
	    System.out.println("         _________        ");
	    System.out.println("         | /     |        ");
	    System.out.println("         |/      |        ");
	    System.out.println("         |       O        ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 7: 
	    System.out.println("         _________        ");
	    System.out.println("         | /     |        ");
	    System.out.println("         |/      |        ");
	    System.out.println("         |       O        ");
	    System.out.println("         |       |        ");
	    System.out.println("         |       |        ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 8: 
	    System.out.println("         _________        ");
	    System.out.println("         | /     |        ");
	    System.out.println("         |/      |        ");
	    System.out.println("         |       O        ");
	    System.out.println("         |      \\|/      ");
	    System.out.println("         |       |        ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	case 9: 
	    System.out.println("         _________        ");
	    System.out.println("         | /     |        ");
	    System.out.println("         |/      |        ");
	    System.out.println("         |       O        ");
	    System.out.println("         |      \\|/      ");
	    System.out.println("         |       |        ");
	    System.out.println("         |      / \\      ");
	    System.out.println("         |                ");
	    System.out.println("        _|____            ");
	    System.out.println("      _/      \\_         ");
	    System.out.println("    _/          \\_       ");
	    System.out.println("  _/              \\_     ");
	    break;
	default: System.out.println("");
	    break;
	}	
    }
   
    public void wordHandler(String input) {

	
  	
	for (int i=0; i<arrayOfTheWord.length; i++) {
	    if(input.charAt(0) == arrayOfTheWord[i]) {
		guessedChar[i] = input.charAt(0);
		rightGuessedChar = true;
		System.out.println("");
	      	System.out.println(guessedChar);
	    }
	}
	
	if (!rightGuessedChar) {
	    numberOfGuesses--;
	    System.out.println("");
	    System.out.println(guessedChar);
	    System.out.println("The letter " + input + " is not in this word, please try again.");
	} else {
	    charsLeftToGuess = numberOfCharsLeft(guessedChar);
	    rightGuessedChar = false;
	    System.out.println("The letter " + input + " is in the secret word, good guess.");
	}

	if (numberOfGuesses == 0) {
	    System.out.println("You have run out of guesses.");
	    System.out.println("The secret word was " + theWord);
	    System.out.println("");
	} else {
	    System.out.println("You still have " + numberOfGuesses + " possible wrong guesses left, so keep trying.");
	}

	if (charsLeftToGuess == 0) {
	    System.out.println("You managed to guess the secret word, congratulations!");
	    System.out.println("The secret word was : " + theWord);   
	    System.out.println("");          
	} else {
	    System.out.println("You have " + charsLeftToGuess  + " letter left to guess.");
	    System.out.println("");
	}
	printTheHangman();
	System.out.println("");
    }
}

