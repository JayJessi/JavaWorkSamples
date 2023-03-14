package ChristmasTree;
import java.text.SimpleDateFormat;

import processing.core.PApplet;
import processing.core.PImage;

//READ ME
//Farbe ändern mit r = rot, g = grau, b = blau, y = gelb, Leertaste = säubern

public class Baum extends PApplet {
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


	public static void main(String args[]) {
		PApplet.main(new String[] { Baum.class.getName() });
	}

	public void settings() {
		size(765, 900);
	}

	public void setup() {
//	short[][]image = Toolbox.loadImage("lab/ex59/tannenbaum.jpg");
//	Toolbox.showImage(image);
	PImage treeImage = loadImage("ChristmasTree/tannenbaum.jpg");
	image(treeImage,0,0);
	
	}
	public void draw() {
		PImage treeImage = loadImage("ChristmasTree/tannenbaum.jpg");
		fill(255,255,0);
			noStroke();
		
		if(key == 'r') {
			fill(255,0,0);
		}else if(key == 'g') {
			fill(150);
		}else if(key == 'b') {
			fill(0,0,255);
		}else if(key == ' ') {
			image(treeImage,0,0);
			key = '4';
		}
		
		if(mousePressed) {
			
			ellipse(mouseX,mouseY,70,70);
			fill(255);
			ellipse(mouseX-15,mouseY-15,5,5);
		}
		System.out.println();
		}
	

}

