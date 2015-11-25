import java.util.*;


public class Math{
    int rdm1;
    int rdm2;
    int operation;
    int[] question = {rdm1, rdm2, operation};
    int answer;
    String opString;
    Boolean correct = false;
    
    private void generateNumbers(){
	Random rand1 = new Random();
	rdm1 = rand1.nextInt((100-3) + 1) + 3;
	rdm2 = rand1.nextInt((100-3) + 1) + 3;
	operation = rand1.nextInt((4-1) + 1) + 1;

    }


    public int generateMath(){
	correct = false;
	generateNumbers();
	switch(operation){
	    
	case 1:
	default:
	    answer = rdm1 + rdm2;
	    opString = "+";
	    break;

	case 2:
	    answer = rdm1 - rdm2;
	    opString = "-";
	    break;

	case 3:
	    answer =  rdm1 * rdm2;
	    opString = "*";
	    break;
	}
	return answer;
    }
    
    
    public int[] getQuestion(){
	return question;
    }

    public int getAnswer(){
	return answer;
    }


    public Boolean isCorrect(int guess){
	if(guess == this.answer){
	    System.out.println("Correct!");
	    correct = true;
	}else{
	    System.out.println("False.");
	    correct = false;
	}
	return correct;
    }

    @Override
    public String toString(){
	return this.rdm1 + " " + this.opString + " " + this.rdm2 + " = ?";
    }


}

