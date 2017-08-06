package factortyMethod;

import factortyMethod.framework.Factory;
import factortyMethod.framework.IDCardFactory;
import factortyMethod.idcard.Product;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("홍길동");
		Product card2 = factory.create("이순신");
		Product card3 = factory.create("강감찬");
		
		card1.use();
		card2.use();
		card3.use();


	}

}
