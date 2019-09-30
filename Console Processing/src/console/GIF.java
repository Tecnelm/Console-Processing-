package console;

import processing.core.PApplet;
import processing.core.PImage;

public class GIF extends Component {
	private static PApplet p;
	private PImage[] images;
	private int imageCount;
	private int frame=0;
	private int freq  ;
	private boolean aff = false;
	private float xpos,ypos;
	
	private Thread count = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(true)
			if(!aff)
				try {
					Thread.sleep(1);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
			{
				frame = (frame+1) % imageCount;
				
				try {
					Thread.sleep(freq);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	});	
	public GIF(PImage [] img,int largeurNImage,int hauteurNImage,PApplet p)
	{
		images =img;
		this.p = p;
		if(largeurNImage==0||hauteurNImage==0)
			for(PImage temp : images)
			temp.resize(largeurNImage, hauteurNImage);
		imageCount = images.length;
		
		count.start();
				}
	public GIF(PImage sprite ,int nbL,int nbH,int largeurNImage,int hauteurNImage,int periode,PApplet p)
	{
		this.p = p;
		this.freq=periode;
		PImage temp;
		imageCount = nbL*nbH;
		int tL = sprite.width/nbL;
		int tH = sprite.height/nbH;
		images = new PImage [nbL*nbH];
		int id = 0;
		for(int h = 0 ; h<nbH ; h++)
		{
			for(int l = 0 ; l<nbL ; l++)
			{	
				temp =sprite.get(l*tL, h*tH, tL, tH);
				System.out.println(temp.height+"       "+temp.width);
				if(largeurNImage==0||hauteurNImage==0)
					temp.resize(largeurNImage, hauteurNImage);
				System.err.println(temp.height+"       "+temp.width);
				
				images[id] =temp ;
				id++;	
			}
		}
		count.start();
		
	}
	

	
	public void display(float xpos, float ypos) {
		aff = true;
		frame = 0;
	  this.xpos = xpos;this.ypos = ypos;
	  System.out.println("done");
	}
	 public void noDisplay()
	{
		aff = false;
		frame = 0;
	}

	 public int getWidth() {
	  return images[0].width;
	}

	@Override
	public void aff() {
		if(aff)
		this.p.image(images[frame], xpos, ypos);
	}
}


