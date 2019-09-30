package console;

import processing.core.PApplet;

class Seg_lettre extends Component{
	private PApplet p;
	  private int tailleP,tailleh=4;
	  private int pos = 0,posy;
	  private int periode;
	  private boolean aff =false;
	  public Seg_lettre(int taillepolice,int pos,float freq,PApplet p)
	  {
	    tailleP = taillepolice;
	    this.pos=pos;
	    this.posy=p.height-(int)(p.height*0.025);
	    periode = (int)(((float)1/freq)*(float)1000);
	    this.p= p;
	    Thread clign = new Thread(new Runnable(){// realisation du clignotement dans une boucle à pars pour avoir la frequence voulu
	      public void run()
	      { 
	        while(true)
	        {
	          aff = aff?false:true;//inverse un bolean qui renseignera si il faut ou non afficher le rectangle de la console
	         try {
				Thread.sleep(periode);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//attend un certain temps avec d'inverser a nouveau
	        }
	      }
	    });
	    clign.start();
	  }
	  @Override
	  public void aff(){
	    if(aff){
	      p.fill(255,255,255);
	      
	      // rect((int)(width*0.02)+(int)(tailleP*0.6)*pos,posy,(int)(tailleP*0.6),tailleh); 
	       p.rect((float) ((p.width*0.02)+tailleP*0.6*pos),p.height-(2*tailleP),2,tailleP); 
	      
	    }
	  }
	  
	  
	  public void addPos(){
	    if(((float)(pos+1)*0.6*(float)tailleP)+(float)(p.width*0.02)< (float)((float)p.width-0.02*p.width))
	    this.pos++;
	  }
	  public void backPos(){
	    this.pos--;
	  }
	  public void resetPos(){
	    this.pos=0;
	  }
	  public int getPos()
	  { 
	    return pos;
	  }
	  
	}
