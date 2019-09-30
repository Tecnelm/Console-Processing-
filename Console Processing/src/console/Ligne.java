package console;

import processing.core.PApplet;
import processing.core.PFont;

class Ligne extends Component{
private PApplet p;
private String sentence="" ;
private int tailleP;
private int numL;
private PFont font ;

public Ligne(String s,int tailleP,int numLigne,PApplet p){
  sentence = s;
  this.p = p;
  this.tailleP=tailleP;
  font = p.createFont("Lucida Console",tailleP);

  numL = numLigne; 
}
@Override
public void aff(){
  p.fill(255,255,255);
  p.textFont(font,tailleP);
  //textSize(tailleP);
  p.text(sentence,(int)(p.width*0.02),p.height-(tailleP*numL));
}

public void addLetter(char l){
  if(((float)(sentence.length()+1)*0.6*(float)tailleP)+(p.width*0.02)<(p.width-(int)(0.02*p.width)))
    sentence+=l;
}
public void removeLetter(int pos){
  String temp="";
  for (int i = 0 ; i<sentence.length();i++)
  {
    if(i!=pos)  temp+=sentence.charAt(i);
    
  }
    sentence = temp;
  }
  public void enter()
  {
    sentence="";
  }
  public String getStr(){
    return sentence;
  }
}