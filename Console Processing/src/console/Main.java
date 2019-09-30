package console;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet  {
	Console c = new Console(new Action()
	{
	@Override
	public void actionToDo() {
		int a  = c.requestInt();
		int b =  c.requestInt();
		c.print(a+b);
	}
	},800,800,15,this) ; 

	  public static void main(String[] args){
	    PApplet.main("console.Main");
	  }
	  
	  public void settings(){
		  c.settings();
	  }
	  public void setup() {
			c.setup();
		}
		
	  public void draw() {
		  c.draw();
		    }
	  
	  public void keyPressed() {c.keyPressed(keyCode, key);;
}
}
	
