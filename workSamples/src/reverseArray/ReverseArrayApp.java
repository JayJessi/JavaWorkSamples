package reverseArray;

import hdm.shared.Toolbox;

public class ReverseArrayApp {
public static void main(String[] args) {
	
	int n = Toolbox.readInt("Anzahl der Namen: ");
	
	String [] idk = new String [n];
	
for(int i = 0; i < idk.length; i++) {
	idk[i] = Toolbox.readString("String eingeben: ");
}

for(int i = idk.length -1; i >= 0; i--) {
	System.out.println(idk[i]);
}
	
	
}
}
