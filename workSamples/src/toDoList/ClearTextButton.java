package toDoList;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearTextButton extends JButton implements ActionListener{

	JTextArea secondText;
	ClearTextButton(String title, JTextArea secondText){
		super(title);
		this.secondText = secondText;
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.secondText.setText("");
	}
}
