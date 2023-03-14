package toDoList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InsertTextButton extends JButton implements ActionListener {
	private JTextField firstText;
	private JTextArea secondText;
	
	
InsertTextButton(String title, JTextField firstText, JTextArea secondText){
	super(title);
	this.firstText = firstText;
	this.secondText = secondText;
	this.addActionListener(this);
}

public void actionPerformed(ActionEvent e) {
	String input = this.firstText.getText() + "\n";
	this.secondText.append(input);
	this.firstText.setText("");
}
}
