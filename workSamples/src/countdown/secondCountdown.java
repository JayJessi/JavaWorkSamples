package countdown;

import java.text.SimpleDateFormat;

import hdm.shared.Toolbox;
import processing.core.PApplet;
import processing.core.PImage;

public class secondCountdown extends PApplet {
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	int time = 0;
	float b = 0;
	String point = "";
	int Xtime = 50;
	int Ytime = 530;
	boolean timeIsOver = false;
	PImage hdmLogo;
	int missingMinutes;
	final int hoursPerDay = 24;
	final int minutesPerDay = 60;
	final int secondsPerDay = 60;
	
	int startHour = 8-1;
	int startMinute = 15-1;
	int startSeconds = 0;

	public static void main(String args[]) {
		// "--present" for activating full screen mode.
		PApplet.main(new String[] { secondCountdown.class.getName() });

	}

	public void settings() {
		size(1440, 900);
	}

	public void setup() {
		hdmLogo = loadImage("lab/countdown/hdm_logo.png");
		background(255, 255, 255);
		noStroke();

		// rotes Rechteck
		fill(255, 0, 0);
		rect(0, 600, 1440, 300);

		// Logo
		image(hdmLogo, 1250, 30, 150, 140);
	}

	public void draw() {
		noStroke();
		textSize(125);

		int missingHours = (hoursPerDay + startHour) - hour();
		int missingMinute = (minutesPerDay + startMinute) - minute();
		int missingSeconds = (secondsPerDay + startSeconds) - second();

		if ((missingHours == 0) && (missingMinutes == 30) && (missingSeconds == 0)) {
			Toolbox.playAudioFileAsychronously("/lab/countdown/Stoppuhr.wav");
		}

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
		}else if((missingHours == 23) && (missingMinutes < 15)){
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
		time++;
		if (time == 61) {
			time = 0;
		}
	}
}
