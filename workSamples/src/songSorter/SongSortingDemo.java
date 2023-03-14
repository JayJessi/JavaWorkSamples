package songSorter;

import java.util.Arrays;

import hdm.shared.Toolbox;

public class SongSortingDemo {
	
	//d)
//	static String header = Toolbox.readFile("scr/lab/ex32/header.txt");
//	static String footer = Toolbox.readFile("scr/lab/ex32/footer.txt");

	private static Song[] songs = new Song[5];
	private static Song[] songs2 = new Song[5];

	public static void main(String[] args) {
		new SongSortingDemo();

		songs[0] = new Song(1, "Michael Jackson", "Billie Jean", 294, 5);
		songs[1] = new Song(2, "Pink Floyd", "Us and Them", 471, 3);
		songs[2] = new Song(3, "ACDC", "Givin the Dog a Bone", 211, 1);
		songs[3] = new Song(4, "Whitney Houston", "Queen of the Night", 188, 2);
		songs[4] = new Song(5, "Fleetwood Mac", "Second Hand News", 163, 4);
		
		songs2[0] = new Song(4, "Michael Jackson", "Thriller", 357, 2);
		songs2[1] = new Song(2, "Michael Jackson", "Baby Be Mine (Rod Temperton)", 260, 2);
		songs2[2] = new Song(1, "Michael Jackson", "Wanna Be Startin� Somethin�", 363, 2);
		songs2[3] = new Song(3, "Michael Jackson", "The Girl Is Mine", 222, 1);
		songs2[4] = new Song(5, "Michael Jackson", "Thriller", 163, 2);
		
		
//Aufgabe b)
		for (int i = 0; i < songs.length - 1; i++) {
			int boo = songs[i].compareTo(songs[i + 1]);
			if (boo < 0) {

			} else if (boo > 0) {
				Song safe = songs[i + 1];
				songs[i + 1] = songs[i];
				songs[i] = safe;

			}
		}

		System.out.println("--------------------------");
		System.out.println("Nach Id: ");
		printSong();

//Aufgabe c)

		System.out.println("--------------------------");
		System.out.println("Nach Spielzeit: ");
		Arrays.sort(songs, new SongLengthComparator1());
		printSong();
		
		Arrays.sort(songs, new SongLengthComparator2());
		printSong();
		
		System.out.println("--------------------------");
		System.out.println("Nach K�nstler, Tiel, Dauer: ");
		Arrays.sort(songs, new SongArtistTitleLengthComparator());
		System.out.println("--------------------------");
		for (int i = 0; i < songs.length; i++) {
			System.out.println(songs2[i]);
			
			
		}
		
//		for (int i = 0; i < songs.length; i++) {
//				header += songs[i].toHTMLString();
//			}
//			Toolbox.writeFile("scr/lab/ex32/songs.html", header + footer);
	}

	public static void printSong() {
		System.out.println("--------------------------");
		for (int i = 0; i < songs.length; i++) {
			System.out.println(songs[i]);
		}
	}
}
