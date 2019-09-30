package console;

public class Timer {
	
	private Action action;
	private static int delay;
	private Thread time;
	public Timer(Action a , int delay )
	{
		action = a;
		this.delay = delay;
		time = new Thread (new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(Timer.delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					action.actionToDo();
					
				}
			});
		time.start();
		
		
	}
	
	public Timer(Action a , int delay,final int nbRep )
	{
		action = a;
		this.delay = delay;
		time = new Thread (new Runnable() {
				
				@Override
				public void run() {
					for(int i = 0 ; i <nbRep;i++)
					{
					try {
						Thread.sleep(Timer.delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					action.actionToDo();
					}
					
				}
			});
		time.start();
	}
	public void stop()
	{
		time.stop();
		time.destroy();
	}
}
