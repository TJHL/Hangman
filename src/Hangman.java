import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	JFrame frame;
	JPanel panel;
	JLabel label;
	String display="";
	ArrayList <String> dox;
	ArrayList <String> hangmanReadyWords;
	String tempForFileReader= "";
	int randomInt;
	boolean needNewWord= true;
	int currentWord=0;
	String blanks="";
	String toBeDisplayed ="";
	
	
	
public static void main(String[] args) {
	Hangman a = new Hangman();
	
}
	Hangman(){
	dox= new ArrayList <String>();
	hangmanReadyWords= new ArrayList <String>();
	findWords();
	randomHangmanWords();
	displayWord();
	panel = new JPanel();
	frame = new JFrame();
	label = new JLabel(display);
	frame.add(panel);
	panel.add(label);
	frame.setSize(500, 500);
	frame.setLocation(700, 230);
	frame.setVisible(true);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	void findWords(){
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
				
				tempForFileReader = br.readLine();
				while(tempForFileReader != null){
					dox.add(tempForFileReader);
					tempForFileReader = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	
	void randomHangmanWords() {
		Random r = new Random();
		for (int i = 0; i < dox.size(); i++) {
		randomInt= r.nextInt(dox.size());
			hangmanReadyWords.add(dox.get(randomInt));
			
		}
	}
	

		void displayWord () {
			if(needNewWord== true) {
				
				for (int i = 0; i < hangmanReadyWords.get(currentWord).length(); i++) {
					blanks += "_";
				}
				toBeDisplayed= toBeDisplayed +blanks;
				updateDisplay();
				
				//////
				System.out.println(hangmanReadyWords.get(currentWord));
				
				
				////
			//WHEN WORD IS FOUND TO BE CORRECT	currentWord= currentWord +1;
				////
				needNewWord= false;
				
			}
		}
		void updateDisplay(){
			display="Guess a letter \n"+toBeDisplayed+" You have "+"INSERT THINGS"+" attemps left";
		}
	
	
	
}
