package countdown;

import java.text.SimpleDateFormat;

import hdm.shared.Toolbox;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class HdmZeitblock extends PApplet {
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	PImage myImage;

	boolean test = true;

	int startHour = 8 - 1;
	int startMinute = 15 - 1;
	int startSeconds = 0;

	final int hoursPerDay = 24;
	final int minutesPerDay = 60;
	final int secondsPerDay = 60;

	final int startingHour = 1;
	final int startingMinute = 45;

	int hour = 1;
	int minutes = 45;
	int seconds = 0;
	int b = 0;
	String point = "";

	int missingMinutes;

	int timeTextSize = 125;

	int hoursPerDay2 = 2400;

	int Xtime = 50;
	int Ytime = 530;
	boolean button = false;
	boolean timeIsOver = false;

	public static void main(String args[]) {
		// "--present" for activating full screen mode.
		PApplet.main(new String[] { HdmZeitblock.class.getName() });

	}

	public void settings() {
		size(1440, 900);
	}

	public void setup() {

		myImage = loadImage("lab/countdown/hdm_logo.png");

		background(255, 255, 255);
		noStroke();

		// rotes Rechteck
		fill(255, 0, 0);
		rect(0, 600, 1440, 300);

		// grauer Streifen
		fill(200);
		rect(0, 550, 1440, 50);

		// Logo
		image(myImage, 1255, 20, 160, 150);

	}

	public void draw() {

		int missingHours = (hoursPerDay + startHour) - hour();
		int missingMinute = (minutesPerDay + startMinute) - minute();
		int missingSeconds = (secondsPerDay + startSeconds) - second();

		int currentMinute = (hour() * 60) + minute();
		int startTime = (8 * 60) + 15;
		int endTime = (21 * 60) + 15;
		int currentTime = (hour() * 60) + minute();

	
		if ((currentMinute - 855) % 105 == 0) {
			hour = 1;
			minutes = 45;
			seconds = 0;
			
		} else {// time after break
			if ((currentMinute >= 855) && (currentMinute <= 1160)) {
				int restMinute = 105 - ((currentMinute - 855) % 105);
				minutes = restMinute % 60;
				hour = restMinute / 60;
				seconds = 59 - second();

			} else if ((currentMinute >= 795) && (currentMinute < 855)) {// break
				background(255);
				text("Mittagspause!", 50, 600);
				
				}else if(currentMinute >= 1160) {
					int restMinute = (9 - (currentMinute - 870) % 105);
					System.out.println(currentMinute);
					System.out.println(restMinute);
					minutes = (restMinute % 60)-15;
					hour = restMinute / 60;
					seconds = 59 - second();
				
			} else {// time before break
				int restMinute = (105 - (currentMinute - 495) % 105);
				System.out.println(currentMinute);
				minutes = restMinute % 60;
				hour = restMinute / 60;
				seconds = 59 - second();
			}
		}
//minutes under 10 sec
		if (minutes < 10) {
			fill(255);
			textSize(timeTextSize);
			rect(Xtime - 20, Ytime - 115, 500, 130);
			fill(0, 0, 0);
			text("0" + hour + ":0" + minutes + ":00", Xtime, Ytime);

			minutes--;
			Toolbox.pause(1000);
			seconds = 59;
		}

		if ((currentTime >= startTime) && (currentTime <= endTime)) {
			if (seconds > 0) {
				
				// sekunden under 10 sec
				if (seconds < 10) {
					fill(255);
					textSize(timeTextSize);
					rect(Xtime - 20, Ytime - 115, 500, 130);
					fill(0, 0, 0);
					text("0" + hour + ":" + minutes + ":0" + seconds, Xtime, Ytime);
					Toolbox.pause(1000);
					seconds--;

					// Sekunden over 10 sec
				} else {
					fill(255);
					textSize(timeTextSize);
					rect(Xtime - 20, Ytime - 115, 500, 130);
					fill(0, 0, 0);
					text("0" + hour + ":" + minutes + ":" + seconds, Xtime, Ytime);
					Toolbox.pause(1000);
					seconds--;
				}

			} else {// minute
				fill(255);
				textSize(timeTextSize);
				rect(Xtime - 20, Ytime - 115, 500, 130);
				fill(0, 0, 0);
				text("0" + hour + ":" + minutes + ":00", Xtime, Ytime);

				minutes--;
				Toolbox.pause(1000);
				seconds = 59;
			}
		} else {// timer bis 8:15
			textSize(timeTextSize);
			// background for time
			fill(255, 255, 255);
			rect(Xtime - 10, Ytime - 100, 600, 120);
			fill(0, 0, 0);

			// minutes over 60
			if (missingMinute >= 60) {
				missingMinutes = missingMinute - 60;
			} else {
				missingMinutes = (minutesPerDay + startMinute) - minute();
			}

			// hours over 24
			if (missingHours >= 24) {
				missingHours -= 24;
			} else if ((missingHours == 23) && (missingMinutes < 15)) {
				missingHours = 0;
			}

			// debugging minute chance
			if (second() == 0) {

				if (missingHours < 10) {
					text("0" + missingHours + ":", Xtime, Ytime);
				} else {
					text(missingHours + ":", Xtime, Ytime);
				}
				missingMinutes += 1;
				if (missingMinutes < 10) {
					text("0" + missingMinutes + ":", Xtime + 155, Ytime);
				} else {
					text(missingMinutes + ":", Xtime + 155, Ytime);
				}
				text("00", Xtime + 305, Ytime);

			} else {
				// hours
				if (missingHours < 10) {
					text("0" + missingHours + ":", Xtime, Ytime);
				} else {
					text(missingHours + ":", Xtime, Ytime);
				}

				// minutes
				if (missingMinutes < 10) {
					text("0" + missingMinutes + ":", Xtime + 155, Ytime);
				} else {
					text(missingMinutes + ":", Xtime + 155, Ytime);
				}

				// seconds
				if (missingSeconds < 10) {
					text("0" + missingSeconds, Xtime + 305, Ytime);
				} else {
					text(missingSeconds, Xtime + 305, Ytime);
				}
				if (missingHours >= 24) {
					missingHours -= 24;
				}
			}

			// time is over
			if ((hour() == 8) && (minute() == 15) && (second() == 0)) {
				fill(255, 255, 255);
				rect(0, 0, 1440, 550);
				fill(0, 0, 0);
				text("Informatik hat begonnen!", 500, 500);
				System.out.println("wow");
				System.out.println(hour() + minute() + second());
			}

			// grey rect
			fill(200);
			rect(0, 550, 1440, 50);
			fill(100);
			rect(0, 550, b, 50);
			b += 2;

			// restart bar
			if (b > 1440) {
				fill(100);
				rect(0, 550, 1440, 50);
				fill(200);
				rect(24, 550, 1440, 50);
				b = 0;
			}
		}
	}

	public void loading() {
		if (point.length() <= 3) {
			fill(255, 255, 255);
			rect(640, 500, 200, 50);
			// Toolbox.pause(1000);
			fill(0, 0, 0);
			textSize(40);
			text("loading" + point, 650, 540);

			point += '.';

		} else {
			fill(255, 255, 255);
			rect(640, 500, 200, 50);
			fill(0, 0, 0);
			textSize(40);
			text("loading", 650, 540);
			point = ".";

		}
	}
}
