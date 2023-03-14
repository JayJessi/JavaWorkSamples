package countdown;

import java.text.SimpleDateFormat;

import hdm.shared.Toolbox;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

/*READ ME
Mit Leertaste springt der Timer auf 30 Sekunden.

Quellen:

CountdownAudio:
https://www.youtube.com/watch?v=ViNcBQ8cDA0&t=41s&ab_channel=StarshipTrooper
restlichen Audios von Soundbase

Logo:
https://de.wikipedia.org/wiki/Datei:HdM_Logo.svg

hdm Hintergrund:
https://www.hdm-stuttgart.de/view_news?ident=news20210310094613

Rakete:
https://www.google.com/imgres?imgurl=https://cdn.pixabay.com/photo/2014/04/03/11/58/rocket-312767__480.png&imgrefurl=https://pixabay.com/de/vectors/search/rakete/&tbnid=Ac7ieg4L9VUZ6M&vet=1&docid=zPUEKSrhqxNILM&w=499&h=480&itg=1&hl=de-DE&source=sh/x/im

Schrift vom timer:
https://www.dafont.com/de/digit.font

*/

public class Countdown extends PApplet {
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	PFont time;
	PFont clock;
	
	PImage rocket2;
	PImage Display;
	PImage Button;
	PImage Logo;
	PImage rocket1;
	PImage hdm;

	int timeTextSize = 130;
	
	int minutes = 5;
	int seconds = 0;


	final int rocketX = 1050;
	final int rocketY = 190;
	int rocketHight = rocketY;

	int Xrect = 470;
	int Yrect = 250;
	int widthRect = 630;
	int heightRect = 370;
	float widthBar = 0;
	float maxWidth = 500;
	
	String points = "";
	String endText = "PROJECT 'FIRST WIEST ON THE MOON' SUCCEED";
	
	int Xtime = 110;
	int Ytime = 815;

	boolean button = false;
	boolean timeIsOver = false;
	boolean lastSecond = false;
	boolean hasStarted = false;

	public static void main(String args[]) {
		// "--present" for activating full screen mode.
		PApplet.main(new String[] { Countdown.class.getName() });

	}

	public void settings() {
		size(1440, 900);
	}

	public void setup() {
		Display = loadImage("countdown/Bildschirm.png");
		Button = loadImage("countdown/Button.png");
		Logo = loadImage("countdown/hdm_logo.png");
		rocket1 = loadImage("countdown/rocket1.png");
		rocket2 = loadImage("countdown/rocket2.png");
		hdm = loadImage("countdown/hdm.jpg");

		time = createFont("courier new",60);
		clock = createFont("countdown/DIGI.TTF",60);
		
		image(hdm, 0, 0);
		noStroke();

		// black rects
		fill(0);
		// for loading
		int loadingwidth = 500;
		rect(470, 530, loadingwidth, 95);
		// for time
		rect(90, 700, 330, 150);

		image(Logo, 1250, 40, 150, 135);
		
	}

	public void draw() {
		textFont(clock);
		
		// cheatmode
		if (key == ' ') {
			minutes = 0;
			seconds = 30;
			widthBar = 500 - (30 * maxWidth / (5 * 60));
			key = 'f'; //else it will stay on 30 sec
		}

		// start button
		if ((Start(mouseX, mouseY, Xrect, Yrect, widthRect, heightRect) == true) && mousePressed) {
			Toolbox.playAudioFileAsychronously("/countdown/Mouse.wav");
			button = true;
			hasStarted = true;
		}

		// declares end of timer
		if ((minutes == 0) && (seconds == 0)) {
			timeIsOver = true;
			button = false;
		}
		
		// start end countdown audio
		if ((minutes == 0) && (seconds == 18)) {
			Toolbox.playAudioFileAsychronously("/countdown/rocketStart.wav");
		}

		// starts end sequence
		if (timeIsOver) {
			image(hdm,0,10,1400,640);
			image(rocket2, rocketX, rocketHight, 450, 600);
			rocketHight -= 8;
			image(Display, 0, 0);
			fill(0);
			rect(Xtime - 20, Ytime - 115, 330, 150);
			if (lastSecond == false) {
				textSize(timeTextSize);
				fill(255, 0, 0);
				text("00:00", Xtime, Ytime);
				Toolbox.pause(1000);
				fill(0, 255, 0);
				rect(470, 610, 500, 15);
				lastSecond = true;
			}
			textSize(timeTextSize);
			fill(255, 0, 0);
			text("00:00", Xtime, Ytime);
			fill(0);
			rect(470, 530, 500, 95);
			fill(0, 255, 0);
			textFont(time);
			textSize(18);
			text(endText, 500, 580);
			fill(0, 255, 0);
			rect(470, 610, widthBar, 15);
		}

		// program after pressed button
		if (button) {
			// surface
			if (hasStarted) {
				image(hdm,0,10,1400,640);
				image(Display, 0, 0);
				image(rocket1, rocketX, rocketY, 450, 600);
			}
			textFont(clock);
			// timer
			if (seconds > 0) {
				// seconds under 10 sec
				if (seconds < 10) {
					fill(0);
					textSize(timeTextSize);
					rect(Xtime - 20, Ytime - 115, 330, 150);
					fill(255, 0, 0);
					text("0" + minutes + ":0" + seconds, Xtime, Ytime);
					Toolbox.pause(1000);
					seconds--;

					// seconds over 10 sec
				} else {
					fill(0);
					textSize(timeTextSize);
					rect(Xtime - 20, Ytime - 115, 330, 150);
					fill(255, 0, 0);
					text("0" + minutes + ":" + seconds, Xtime, Ytime);
					Toolbox.pause(1000);
					seconds--;
				}

			} else {// minutes
				fill(0);
				textSize(timeTextSize);
				rect(Xtime - 20, Ytime - 115, 330, 150);
				fill(255, 0, 0);
				text("0" + minutes + ":00", Xtime, Ytime);
				minutes--;
				Toolbox.pause(1000);
				seconds = 59;
			}

			// loading...
			textFont(time);
			if (timeIsOver) {	
			} else {
				if (points.length() <= 3) {
					fill(0);
					rect(470, 530, 500, 95);
					fill(0, 255, 0);
					textSize(40);
					text("loading" + points, 620, 590);
					points += '.';
				} else {
					fill(0);
					rect(470, 530, 500, 95);
					fill(0, 255, 0);
					textSize(40);
					text("loading", 620, 590);
					points = ".";
				}
			}
			
			// gr�ner Balken
			if (timeIsOver) {
				widthBar = 500;
				fill(0, 255, 0);
				rect(470, 610, widthBar, 15);
			} else {
				fill(0, 255, 0);
				rect(470, 610, widthBar, 15);
				widthBar += maxWidth / (5 * 60);
			}
		} else {
			if (hasStarted == false) {
				image(Button, 0, 0);
			}
		}
	}

	// StartKnopf
	static boolean Start(int mouseX, int mouseY, int Xrect, int Yrect, int width, int height) {
		if ((mouseX >= Xrect) && (mouseX <= (Xrect + width)) && (mouseY >= Yrect) && (mouseY <= (Yrect + height))) {
			return true;
		} else {
			return false;
		}
	}
}
