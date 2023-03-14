package nameSearch;

import java.io.IOException;
import hdm.shared.Toolbox;
import hdm.shared.StopWatch;

public class NameSearch {
	private StopWatch stopWatch;
	private int index = -1;
	private final int REPETITIONS = 100_000;

	static String input = Toolbox.readFile("E:\\Audiovisuelle Medien\\1. Semester\\Informatik 1\\Informatik2\\src\\lab\\ex25\\namen.txt\\");
	static String[] names = input.split("\n");

	public static void main(String[] args) {

		NameSearch search = new NameSearch();
		String searchedName = Toolbox.readString("Welchen Namen suchen Sie? ");
		search.performBenchmarks(searchedName);
	}

	public void performBenchmarks(String searchedName) {
		// Teilexperiment 1
		this.stopWatch = new StopWatch();
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(searchedName)) {
				System.out.println("Name hat den Index: " + (i + 1));
				System.out.println("Benötigte Zeit: " + (stopWatch.getElapsedTime() / 1000) + " Sekunden");
			}
		}
		System.out.println("-------------------------------------------------");
		
		//Teilexperiment 2
		index = binarySearch(names, searchedName, 0, names.length -1);
		
		if(index != -1){
			System.out.println("Der Name steht an Index " + (index+1));
		}else {
			System.out.println("Name nicht gefunden");
		}
		System.out.println("Suchzeit Binäre Suche =  " + stopWatch.getElapsedTime()/1000 + " Sekunden");
		System.out.println("-----------------------------------------------");
		
		//Teilexperiment 3
		//lin�r
		stopWatch.reset();
		index = binarySearch(names, searchedName, 0, names.length -1);
		for(int i = 0; i < REPETITIONS; i++) {
			index = linearSearch(names, searchedName);
		}
		System.out.println("Suchzeit linear (100000 Wiederholungen): " + stopWatch.getElapsedTime());
		
		//bin�r
		stopWatch.reset();
		for(int i = 0; i < REPETITIONS; i++) {
			index = binarySearch(names, searchedName, 0, names.length -1);
		}
		System.out.println("Bin�re Suche: " + stopWatch.getElapsedTime());
		}

public int linearSearch(String[] inputArray, String searchedName) {
	for (int i = 0; i < inputArray.length; i++) {
		if (inputArray[i].equals(searchedName)) {
			return i;
		}
	}
	return -1;
}
	public int binarySearch(String[] inputArray, String searchedName, int lowest, int highest) {
		// Teilexperiment 2

		if (lowest > highest) {
			return -1;
		}

		int middle = ((lowest + highest) / 2);
		int comparison = searchedName.compareTo(inputArray[middle]);

		if (comparison == 0) {
			return middle;
		}

		else if (comparison < 0) {
			return binarySearch(inputArray, searchedName, lowest, middle - 1);
		}

		else{
			return binarySearch(inputArray, searchedName, middle + 1, highest);
		}
	}
}
