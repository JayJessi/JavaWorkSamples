package songSorter;

import hdm.shared.Toolbox;

public class Song implements Comparable<Song>{

	private final String RATING_SYMBOL = "*";
	long id;
	String artist;
	String title;
	double length;
	int rating;
	
	public Song(long id, String artist, String title, double length, int rating) {
		this.id = id;
		this.artist = artist;
		this.title = title;
		this.length = length;
		this.rating = rating;
	}

	public String toString() {
		String song = id +": "+artist+", "+title+", "+length+", "+stars(rating);
		return song;
	}
	public int compareTo(Song otherSong) {
		if(this.id < otherSong.id) {
			return -1;
		}else if(this.id > otherSong.id) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public String toHTMLString() {
		String ratingStars = "";

		for (int i = 0; i < rating; i++) {
			ratingStars += RATING_SYMBOL;
		}

		return "\t\t\t<tr>\n" + "\t\t\t\t<td class='id'>" + id + "</td>\n" + "\t\t\t\t<td>" + artist + "</td>\n" + "\t\t\t\t<td>" + title + "</td>\n"
				+ "\t\t\t\t<td>" + Toolbox.formatDuration(length) + "</td>\n" + "\t\t\t\t<td>" + ratingStars + "</td>\n" + "\t\t\t</tr>\n";
	}
	
	
	public String stars(int rating){
		String output = "";
		for(int i = 0; i < rating; i++) {
			output += "*";
		}
		return output;
	}
}
