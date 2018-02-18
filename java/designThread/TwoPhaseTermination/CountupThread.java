package TwoPhaseTermination;

public class CountupThread extends Thread {
	//카운터의 값
	private long counter = 0;
	
	//종료 요구가 제시되었으면 true
	private volatile boolean shutdownRequested = false;
	
	//종료 요구
	public void shutdownRequest() {
		shutdownRequested = true;
		interrupt();
	}
	
	//종료요구가 제시되었는지를 테스트
	public boolean isShutdownRequest() {
		return shutdownRequested;
	}
	
	//동작
	public final void run() {
		try {
			while(!isShutdownRequest()) {
				doWork();
			}
		}catch(InterruptedException e) {
		}finally {
			doShutdown();
		}
		
	}
	
	//작업
	private void doWork() throws InterruptedException {
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}
	
	//종료처리
	private void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
	}

}
