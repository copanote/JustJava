package Future;

public class FutureData implements Data {
	private RealData realdata = null;
	private boolean ready = false;
	public synchronized void setRealData(RealData realdata) {
		if(ready) {
			return; //balk
		}
		this.realdata = realdata;
		this.ready = true;
		notifyAll();
	}

	@Override
	public synchronized String getContent() {
		while(!ready) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		
		return realdata.getContent();
	}

}
