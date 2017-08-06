package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		UnderlinePen upen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("string message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);
		
		Product p1 = manager.create("string message");
		p1.use("Hellow, world!");
		Product p2 = manager.create("warning box");
		p2.use("Hello, world");
		Product p3 = manager.create("slash box");
		p3.use("Hello, world");
		
	}

}
