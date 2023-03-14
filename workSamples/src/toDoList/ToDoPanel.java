package toDoList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import hdm.shared.MyBasicFrame;

public class ToDoPanel extends JPanel {

InsertTextButton insertButton;	
ClearTextButton clearButton;
JTextField firstText;
JTextArea secondText;

	public static void main(String[] args) {
		ToDoPanel panel = new ToDoPanel();
		new MyBasicFrame("To Do Liste", 300, 600, panel);
	}

	public ToDoPanel() {
		firstText = new JTextField(20);
		secondText = new JTextArea(20, 20);
		insertButton = new InsertTextButton("Text einf�gen", firstText, secondText);
		secondText.setEditable(false);
		clearButton = new ClearTextButton("Text l�schen", secondText);
		
		this.add(firstText);
		this.add(insertButton);
		this.add(secondText);
		this.add(clearButton);
	}
}
