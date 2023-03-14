package addressSort;

import java.util.Arrays;

public class AddressZipComparatorDemo {
	private Address[]adressen = new Address[8];
	
public AddressZipComparatorDemo(){
	this.adressen[0] = new Address("Boeblinger Strasse 104", 70199, "Stuttgart");
	this.adressen[1] = new Address("Schlossplatz 1", 83684, "Tegernsee");
	this.adressen[2] = new Address("Karlstrasse 66", 74405, "Gaildorf");
	this.adressen[3] = new Address("Falkenstrasse 11", 81541, "Muenchen");
	this.adressen[4] = new Address("Ritterstrasse 6", 74523, "Schwaebisch Hall");
	this.adressen[5] = new Address("Landsberger Strasse 35", 80339, "Muenchen");
	this.adressen[6] = new Address("Tuebinger Strasse 46", 70178, "Stuttgart");
	this.adressen[7] = new Address("Im Brunnenfeld 2", 79224, "Umkirch");
	
	System.out.println("Sortier nach Postleitzahl: ");
	Arrays.sort(adressen, new ZipComparator());
	printArray(adressen);
	System.out.println("-------------------------------------------------");
	
	System.out.println("Sortier nach Stadt: ");
	Arrays.sort(adressen, new CityZipComparator());
	printArray(adressen);
}

public void printArray(Address [] array) {
	for(int i = 0; i < array.length; i++) {
		System.out.println(array[i].toString());
	}
}
public static void main(String[] args) {
	new AddressZipComparatorDemo();
}
}
