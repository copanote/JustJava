package TwoPhaseTermination;

public class Main {

	public static void main(String[] args) {
		System.out.println("main: BEGIN");
		try {
			//쓰레드 기동
			CountupThread t = new CountupThread();
			t.start();
			
			//조금 시간을 비워둔다
			Thread.sleep(10000);
			
			//쓰레드의 종료요구
			System.out.println("main: shutdownRequest");
			t.shutdownRequest();
			
			System.out.println("main: join");
			
			//쓰레드이 종료를 기다린다.
			t.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main END");
	}

}
