import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class Hangman implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	String display = "";
	ArrayList<String> dox;
	ArrayList<String> hangmanReadyWords;
	String tempForFileReader = "";
	int randomInt;
	boolean needNewWord = true;
	int currentWord = 0;
	String currentWordUp = "";
	String blanks = "";
	String toBeDisplayed = "";
	char charTyped;
	String temporatyToBeUpdated = "";
	int lifeRemaining = 9;
	ArrayList<Character> wrongLetters;

	public static void main(String[] args) {
		Hangman a = new Hangman();

	}

	Hangman() {
		dox = new ArrayList<String>();
		hangmanReadyWords = new ArrayList<String>();
		wrongLetters = new ArrayList<Character>();
		findWords();
		randomHangmanWords();
		panel = new JPanel();
		frame = new JFrame();
		label = new JLabel(display);
		displayWord();
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setSize(500, 500);
		frame.setLocation(700, 230);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void findWords() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));

			tempForFileReader = br.readLine();
			while (tempForFileReader != null) {
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
			randomInt = r.nextInt(dox.size());
			hangmanReadyWords.add(dox.get(randomInt));

		}
	}

	void displayWord() {
		if (needNewWord == true) {
			for (int i = 0; i < hangmanReadyWords.get(currentWord).length(); i++) {
				blanks += "_";
			}
			toBeDisplayed = toBeDisplayed + blanks;
			currentWordUp = hangmanReadyWords.get(currentWord);
			updateDisplay();

			//
			// System.out.println(hangmanReadyWords.get(currentWord));
			//

			needNewWord = false;
		}

	}

	void updateWord() {
		temporatyToBeUpdated = "";
		boolean bob = false;

		for (int i = 0; i < hangmanReadyWords.get(currentWord).length(); i++) {
			if (toBeDisplayed.charAt(i) == currentWordUp.charAt(i)) {
				temporatyToBeUpdated += currentWordUp.charAt(i);
				if (temporatyToBeUpdated.charAt(i) == charTyped) {
					bob = true;
				}

			} else if (currentWordUp.charAt(i) == charTyped) {
				temporatyToBeUpdated += currentWordUp.charAt(i);
				bob = true;

			} else {
				temporatyToBeUpdated += blanks.charAt(i);

			}

		}

		if (bob == false) {

			if (!wrongLetters.contains(charTyped)) {
				lives();
			}

		}
		toBeDisplayed = temporatyToBeUpdated;

		updateDisplay();
		finishedWord();
	}

	void lives() {
		lifeRemaining = lifeRemaining - 1;
		wrongLetters.add(charTyped);
		if (lifeRemaining == 0) {
			updateDisplay();
			JOptionPane.showMessageDialog(null, "LOL, you suck at this game!!!!");
			System.exit(0);
		}

	}

	void updateDisplay() {
		display = "Guess a letter \n" + toBeDisplayed + " You have " + lifeRemaining + " attemps left";
		label.setText(display);
	}

	void finishedWord() {
		if (toBeDisplayed.equals(currentWordUp)) {
			JOptionPane.showMessageDialog(null, "Good Job! You got the word correct!!!");
			needNewWord = true;
			toBeDisplayed = "";
			currentWord = currentWord + 1;
			blanks = "";
			lifeRemaining = 9;
			for (int i = 0; i < wrongLetters.size(); i++) {
				wrongLetters.remove(i);
			}
			displayWord();
		}
	}

	public void keyTyped(KeyEvent e) {
		charTyped = e.getKeyChar();
		updateWord();

	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}
