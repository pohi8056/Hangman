import java.io.*;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Server{

    public static void main(String [] args) throws IOException{
	//JFrame frame = new JFrame("Hej");
	//frame.setSize(200, 400);
	//frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	//frame.setVisible(true);
	Secret secret_word = new Secret(2);//lvl 1, 2, 3
	secret_word.loadWord();
    }
}
