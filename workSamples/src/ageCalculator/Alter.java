package ageCalculator;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class Alter {
public static void main(String[] args) {
	String yearAsString = JOptionPane.showInputDialog(null, "In welchem Jahr wurden Sie geboren?");
	int year = Integer.parseInt(yearAsString);
	int age = LocalDateTime.now().getYear()-year;
	JOptionPane.showMessageDialog(null, "Dann sind Sie " + age + " Jahre alt.");
	System.out.println(year);
}
}
