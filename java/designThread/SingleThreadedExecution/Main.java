package SingleThreadedExecution;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing Gate, hit CTRL+C to exit.");
		Gate gate = new Gate();
		
		new UserThread(gate, "Alice", "Alaska").start();
		new UserThread(gate, "Bobby", "Brazil").start();
		new UserThread(gate, "Chris", "Canada").start();

	}

}
