package ThreadSpecificStorage;

public class Main_NoTS {

	public static void main(String[] args) {
		System.out.println("BEGIN");
		for (int i = 0; i < 10; i++) {
			Log_NoTS.println("main: i = " + i);
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){}
		}
		
		Log_NoTS.close();
		System.out.println("END");
	}

}
