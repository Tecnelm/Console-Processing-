package console;

import java.util.ArrayList;

import processing.core.PApplet;

class Contour extends Component{
	  private ArrayList<int[]>ligneL = new ArrayList<int[]>();
	  private PApplet p;
	  
	  
	  public Contour(int l,int h,int tailleP,PApplet p)
	  {
		  this.p = p; 
	    int tab[];
	    
	    tab= new int[4];
	    tab[0]=(int)(l*0.01);  tab[1]=h-(int)(tailleP*3);  tab[2]=l-2*(int)(0.01*l);tab[3]=2;
	    ligneL.add(tab);
	    
	    tab= new int[4];
	    tab[0]=(int)(l*0.01);tab[1]=h-(int)(h*0.01);tab[2]=l-2*(int)(0.01*l);tab[3]=2;
	    ligneL.add(tab);
	    
	    tab= new int[4];
	    tab[0]=(int)(l*0.01);tab[1]=(int)(h*0.01);tab[2]=l-2*(int)(0.01*l);tab[3]=2;
	    ligneL.add(tab);
	    
	    tab= new int[4];
	    tab[0]=(int)(l*0.01);tab[1]=(int)(h*0.01);tab[2]=2;tab[3]=h-2*(int)(0.01*h);
	    ligneL.add(tab);
	    
	    tab= new int[4];
	    tab[0]=l-(int)(l*0.01);tab[1]=(int)(h*0.01);tab[2]=2;tab[3]=h-2*(int)(0.01*h);
	    ligneL.add(tab);
	    
	  }
	  
	  @Override
	  public void aff(){
	    p.fill(255,255,255);
	    for(int[] val:ligneL)
	    p.rect(val[0],val[1],val[2],val[3]);
	  }
	}