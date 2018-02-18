package ActiveObject;

public class DisplayClientThread extends Thread {
	private final ActiveObject activeObject;
	public DisplayClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0; true; i++) {
				//반환 값이 없는 호출
				String string = Thread.currentThread().getName() + " " + i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
			
		}catch(InterruptedException e ){}
	}

}
