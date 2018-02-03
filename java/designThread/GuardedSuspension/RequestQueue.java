package GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
	private final Queue<Request> queue = new LinkedList<Request>();
	
	public synchronized Request getRequest() {
		while (queue.peek() == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return queue.remove();
	}
	
	public synchronized void putRequest(Request request) {
		queue.offer(request);
		notifyAll();
	}

}
