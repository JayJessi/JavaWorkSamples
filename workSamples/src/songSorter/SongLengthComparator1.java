package songSorter;

import java.util.Comparator;

public class SongLengthComparator1 implements Comparator<Song> {

	@Override
	public int compare(Song song1, Song song2) {
		if (song1.length < song2.length) {
			return -1;
		} else if (song1.length > song2.length) {
			return 1;
		} else {
			return 0;
		}
	}

}
