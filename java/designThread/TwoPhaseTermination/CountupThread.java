package TwoPhaseTermination;

public class CountupThread extends Thread {
	//ī������ ��
	private long counter = 0;
	
	//���� �䱸�� ���õǾ����� true
	private volatile boolean shutdownRequested = false;
	
	//���� �䱸
	public void shutdownRequest() {
		shutdownRequested = true;
		interrupt();
	}
	
	//����䱸�� ���õǾ������� �׽�Ʈ
	public boolean isShutdownRequest() {
		return shutdownRequested;
	}
	
	//����
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
	
	//�۾�
	private void doWork() throws InterruptedException {
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}
	
	//����ó��
	private void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
	}

}
