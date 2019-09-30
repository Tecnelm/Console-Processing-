package console;

import processing.core.PApplet;
import processing.core.PFont;

public class ArchLigne   {
	  private String str;
	  private PFont font ;
	  private int taille;
	  private PApplet p;
	  private int R=255,G=255,B=255;
	  
	  public ArchLigne(String l,int tailleP,PApplet p){
	  this.p = p;
	  str=l;
	  font = p.createFont("Lucida Console",tailleP);
	  taille = tailleP;
	}
	  public ArchLigne(String l,int tailleP,int R,int G,int B,PApplet p)
	  {
		  this(l,tailleP,p);
		  this.R =R;this.G=G;this.B = B;
	  }

	  
	public void aff(int pos){
	  p.fill(R,G,B);
	  p.textFont(font,taille);
	  p.text(str,(int)(p.width*0.02),(float) (p.height-(3.5*taille)-taille*pos));
	}
}
