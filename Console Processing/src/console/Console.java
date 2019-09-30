package console;

import java.util.ArrayList;

import processing.core.PApplet;

public class Console {
	  private PApplet p;
	  private int width,height;
	  private int taillepolice;
	  private int nbLigne;
	  private ArrayList<ArchLigne> ligneL = new ArrayList<ArchLigne>();
	  private ArrayList<Component>com = new ArrayList<Component>();
	  private Seg_lettre segment;
	  private Ligne ligneEcr;
	  private int numMax;
	  private int posMonte=0;
	  private Action action;
	  private boolean request = false;
	  private String requeststr;
	  
	  private Thread algo = new Thread(new Runnable(){
	      public void run()
	      {action.actionToDo();}
	    });
	  
	 
	  public Console( Action action,int width,int height,int tailleP,PApplet p){
	    this.width = width;  
	    this.p = p;
	    this.height = height;
	    this.taillepolice=tailleP;
	    this.nbLigne=(int)((height-(3*taillepolice+height*0.01))/taillepolice);
	    this.action = action;
	    
	  } 
	  public void settings(){
	  p.size(width,height);
	  
	  algo.start();
	}
	  public void setup(){
	    segment=new Seg_lettre(taillepolice,0,(float) 1.9,p);
	    com.add(segment);
	    ligneEcr = new Ligne("",taillepolice,1,p);
	    com.add(ligneEcr);
	    
	    com.add(new Contour(width,height,taillepolice,p));
	    p.background(15,15,15);
	    p.frame.setLocationRelativeTo(null);
	    
	    
	    
	     
	  }
	  public void draw(){
	    p.background(15,15,15);
	    for(Component c : com)
	      c.aff();
	    numMax = ligneL.size()<=nbLigne ? 0 :(ligneL.size()-nbLigne-posMonte)>=0? (ligneL.size()-nbLigne-posMonte):0 ;
	    int posi = 0;
	    for(int i =ligneL.size()-1-posMonte ;i>=numMax;i--)
	    {
	      ligneL.get(i).aff(posi);
	      posi++;
	    }
	      
	  }
	  
	  public void print(String str , int R,int G,int B)
	  {
		  ligneL.add(new ArchLigne(str,taillepolice,R,G,B,p));
		  
	  }
	  public void print(String str)
	  {
	    this.print(str,0,255,0);
	  }
	  
	  public void print(int str)
	  {
	    this.print(p.str(str));
	  }
	  public void print(boolean str)
	  {
	    this.print(p.str(str));
	  }
	  public void print(float str)
	  {
	    this.print(p.str(str));
	  }
	  public void print(byte str)
	  {
	    this.print(p.str(str));
	  }
	  public void print(char str)
	  {
	    this.print(p.str(str));
	  }
	  public void print(double str)
	  {
	    this.print(""+str);
	  }

	  public int requestInt()
	  {
	    request = true;
	    
	    try{
	      while(request) algo.sleep(1) ;
	      return Integer.parseInt(requeststr);
	    }catch(Exception e ){
	    
	    this.print("ERROR",255,0,0); return -1;}
	    
	  }
	  
	  public String requestStr()
	  {
	    request = true;
	    
	    try{
	      while(request) algo.sleep(1) ;
	      return requeststr;
	    }catch(Exception e ){
	    
	    this.print("ERROR",255,0,0); return "";}
	    
	  }
	  
	  public Double requestDouble()
	  {
	    request = true;
	    
	    try{
	      while(request) algo.sleep(1) ;
	      
	      return Double.parseDouble(requeststr);
	    }catch(Exception e ){
	    
	    this.print("ERROR",255,0,0); return (double)-1;}
	    
	  }
	  
	  public float requestFloat()
	  {
	    request = true;
	    
	    try{
	      while(request) algo.sleep(1) ;
	      return Float.parseFloat(requeststr);
	    }catch(Exception e ){
	    
	    this.print("ERROR",255,0,0); return -1;}
	    
	  }
	  public void keyPressed(int keycode,char Key){
	    
	      if(Key>=' ' && Key<=126){
	         segment.addPos();      
	         ligneEcr.addLetter(p.key);
	      }
	      else
	        {
	          switch(keycode){
	          case java.awt.event.KeyEvent.VK_BACK_SPACE:
	              if(segment.getPos()>0){
	                ligneEcr.removeLetter(segment.getPos()-1); 
	                segment.backPos();}
	              break;
	            case java.awt.event.KeyEvent.VK_ENTER:
	              ligneL.add(new ArchLigne(ligneEcr.getStr(),taillepolice,p));
	              if(request){
	                this.request=false;
	                requeststr = ligneEcr.getStr();
	              }
	              
	              ligneEcr.enter();
	              segment.resetPos();
	              posMonte = 0;
	              break;
	            case java.awt.event.KeyEvent.VK_UP : posMonte = ligneL.size()>=nbLigne ? ligneL.size()-1-posMonte >0? posMonte+1: posMonte:posMonte; break;
	           case java.awt.event.KeyEvent.VK_DOWN : posMonte = posMonte>0 ? posMonte -1:posMonte; break;
	          }
	      }
	  }
	}     

