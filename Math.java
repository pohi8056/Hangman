import java.util.*;
import java.io.Serializable;

public class Math implements Serializable{
    protected static final long serialVersionUID = 411234324200L;

    int rdm1;
    int rdm2;
    int operation;
    String question = (""+ rdm1 + " " + operation + " " + rdm2 + "= ?");
    int answer;
    String opString;
    Boolean correct = false;
    
    private void generateNumbers(){
	Random rand1 = new Random();
	rdm1 = rand1.nextInt((100-3) + 1) + 3;
	rdm2 = rand1.nextInt((100-3) + 1) + 3;
	operation = rand1.nextInt((4-1) + 1) + 1;

    }
    public void generateMath(){
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
    }
    
    
    public String getQuestion(){
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

