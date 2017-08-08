package bridge;

public class CountDisplay extends Display {

	public CountDisplay(DisplayImpl impl) {
		super(impl);
	}
	
	public void miltiDisplay(int times) {
		open();
		for(int i =0; i < times ; i++) {
			print();
		}
		close();
	}

}
