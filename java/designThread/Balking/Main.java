package Balking;

public class Main {

	public static void main(String[] args) {
		Data data = new Data("data.txt", "(empty)");
		new ChangerThread("changerThread", data).start();
		new SaverThread("SaverThread", data).start();
	}

}
