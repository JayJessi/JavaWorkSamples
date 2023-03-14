package songSorter;

import java.util.Comparator;

public class SongArtistTitleLengthComparator implements Comparator<Song>{

	@Override
	public int compare(Song song1, Song song2) {
		int comparison = song1.artist.compareTo(song2.artist);
		
		if(comparison !=0) {
			return comparison;
		}else{
			comparison = song1.title.compareTo(song2.title);
			
			if(comparison != 0) {
				return comparison;
			}else {
				if (song1.length < song2.length) {
					return 1;
				} else if (song1.length > song2.length) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
	
}
