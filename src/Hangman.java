import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman {
	JFrame frame;
	JPanel panel;
	JLabel label;
	String Display="";
	
	
public static void main(String[] args) {
	Hangman a = new Hangman();
	
}
	Hangman(){
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
}
