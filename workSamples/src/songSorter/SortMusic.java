package songSorter;

public class SortMusic {
	private static Song [] songs = new Song[5];
	
public static void main(String[] args) {
	songs[0] = new Song(1, "Michael Jackson", "Billie Jean", 294, 5);
	songs[1] = new Song(2, "Pink Floyd", "Us and Them", 471, 3);
	songs[2] = new Song(3, "ACDC", "Givin the Dog a Bone", 211, 1);
	songs[3] = new Song(4, "Whitney Houston", "Queen of the Night", 188, 2);
	songs[4] = new Song(5, "Fleetwood Mac", "Second Hand News", 163, 4);
	
	System.out.println(songs[0].compareTo(songs[1]));
	System.out.println("lol");
	System.out.println("lul");
}
}
