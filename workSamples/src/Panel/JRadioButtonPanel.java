package Panel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import hdm.shared.MyBasicFrame;

public class JRadioButtonPanel {
public static void main(String[] args) {
	JPanel panel = new JPanel();
	JLabel label = new JLabel("E-Mail-Adresse");
	JTextField tf = new JTextField(9);
	JCheckBox box = new JCheckBox("Bitte senden Sie mir Informationen zu");
	JRadioButton rb1 = new JRadioButton ("Schweden");
	JRadioButton rb2 = new JRadioButton ("Finnland");
	JRadioButton rb3 = new JRadioButton ("Norwegen");
	JButton button = new JButton("Anfrage abschicken");
	
	ButtonGroup buttonGroup = new ButtonGroup();
	buttonGroup.add(rb1);
	buttonGroup.add(rb2);
	buttonGroup.add(rb3);
	
	panel.add(label);
	panel.add(tf);
	panel.add(box);
	panel.add(rb1);
	panel.add(rb2);
	panel.add(rb3);
	panel.add(button);
	
	new MyBasicFrame("Reiseprospekt", 320, 200, panel);
}
}
