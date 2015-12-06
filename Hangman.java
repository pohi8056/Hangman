
public class Hangman{

    private int lengthOfTheWord;
    private char inputCharFromClient;
    private int numberOfMaxTries;
    private int numberOfWrongTries;
    private String theWord;
    private char[] alreadyGuessedChars;
    private char rightGuessedLetters;
    private String underscores = "";

    public Hangman (char inputCharFromCLient, int numberOfMaxTries, int numberOfWrongTries, 
		    String theWord, char[] alreadyGuessedChars, char rightGuessedLetters) {              //constructor
	
	this.inputCharFromClient = inputCharFromClient;
	this.numberOfMaxTries = numberOfMaxTries;
	this.numberOfWrongTries = numberOfWrongTries;
	this.theWord = theWord;
	this.alreadyGuessedChars = alreadyGuessedChars;
    } 
    
    public int getNumberOfTries() {                                           //getter
	return this.numberOfWrongTries;
    }

     public void setNumberOfTries() {                                          //setter
    	this.numberOfWrongTries++;
    }
    
    public int lengthOfTheWord() {
	
	int lengthOfTheWord = theWord.length();
	return lengthOfTheWord;
    }

    public String printTheWord() {                                             //method
	

	for(int i=1; i<=lengthOfTheWord(); i++){
	    underscores = underscores.concat("_ ");
	}


	// rightGuessedLetter insert in its right place in theWord as "_ _ _" e.g. underscores.

	
	
	    

	return underscores;
    }
	
    
    public String printTheHangman() {
	
	switch (numberOfWrongTries){
	
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
	default: System.out.println("Invalid input!");
	    break;
	}
	return "";
    }



    public void printAll( ) {

	System.out.println(" ");
	System.out.println("====================================================");
	System.out.println(printTheHangman());
	System.out.println("Maximum possible wrong guesses: " + numberOfMaxTries);
	System.out.println("Number of already wrong guesses: " + numberOfWrongTries);
	System.out.println("The word: " + printTheWord());
	System.out.println("Length of the word: " + lengthOfTheWord());
	System.out.println(" ");
	System.out.println("====================================================");
	System.out.println(" ");

    }
  
}
