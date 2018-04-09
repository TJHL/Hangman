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
	String Display="";
	ArrayList <String> dox;
	ArrayList <String> hangmanReadyWords;
	String tempForFileReader= "";
	int randomInt;
	
	
public static void main(String[] args) {
	Hangman a = new Hangman();
	
}
	Hangman(){
	dox= new ArrayList <String>();
	hangmanReadyWords= new ArrayList <String>();
	findWords();
	panel = new JPanel();
	frame = new JFrame();
	label = new JLabel(Display);
	frame.add(panel);
	panel.add(label);
	frame.setSize(500, 500);
	frame.setLocation(700, 230);
	frame.setVisible(true);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	
	void findWords(){
		
		//	tempForFileReader gets its tempartary word
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
				
				String dox = br.readLine();
				while(dox != null){
					dox = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		//
			dox.add(tempForFileReader);
		}
	
	void randomHangmanWords() {
		Random r = new Random();
		for (int i = 0; i < dox.size(); i++) {
		randomInt= r.nextInt(dox.size());
			hangmanReadyWords.add(dox.get(randomInt));
			
		}
		for (int i = 0; i < hangmanReadyWords.size(); i++) {
			System.out.println(hangmanReadyWords.get(i));
		}
	}
}
