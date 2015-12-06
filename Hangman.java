
public class Hangman{

    private int lengthOfTheWord;
    private char inputCharFromClient;
    private int numberOfMaxTries;
    private int numberOfWrongTries;
    private String theWord;
    private StringBuffer alreadyGuessedChars;
    private char rightGuessedChars;
    private String underscores = "";
    private int position;
    private char charsLeftToGuess;
    private boolean clientsGuessOfTheWord;
    private boolean isGuessedCharInTheWord;


    public Hangman (char inputCharFromCLient, int numberOfMaxTries, int numberOfWrongTries, 
		    String theWord, StringBuffer alreadyGuessedChars, char rightGuessedChars) {              //constructor
	
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

    public String printTheWordAsUnderScores() {                                //method
	

	for(int i=1; i<=lengthOfTheWord(); i++){
	    underscores = underscores.concat("_ ");
	}
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


public String iDontKnowBigLoop() {

	while(charsLeftToGuess > 0 && numberOfWrongTries < 10) {

	    isGuessedCharInTheWord = (theWord.indexOf(inputCharFromClient)) != -1;

	    if (clientsGuessOfTheWord == false) {
		
		System.out.println("Good try, but wrong guess.");
				
		numberOfWrongTries++;
	    
		printTheHangman();

	    } else {
		
		System.out.println("Well done, that was a correct guess.");
		
		for (position = 0; position < lengthOfTheWord; position++){
		    
		    if (theWord.charAt(position) == inputCharFromClient) {
			
			System.out.println(inputCharFromClient);
			
			charsLeftToGuess--;

		    } else {
			
			printTheWordAsUnderScores();
		    }
		}
	    }

	    alreadyGuessedChars = buffer.append(inputCharFromClient);
	    
	    System.out.println("Guessed letters: " + alreadyGuessedChars);
	    
	    System.out.println(charsLeftToGuess);
		
	}
	
	if (numberOfWrongTries == numberOfMaxTries) {

	    System.out.println("Sorry, the man has been haned, you lost.");
		
	} else {
	    System.out.println("You won, the word was: " + theWord);
	}	
}

    public void printAll( ) {

	System.out.println(" ");
	System.out.println("====================================================");
	System.out.println(printTheHangman());
	System.out.println("Maximum possible wrong guesses: " + numberOfMaxTries);
	System.out.println("Number of already wrong guesses: " + numberOfWrongTries);
	System.out.println("The word: " + printTheWordAsUnderScores());
	System.out.println("Length of the word: " + lengthOfTheWord());
	System.out.println(" ");
	System.out.println("====================================================");
	System.out.println(" ");

    }
  
}
