package prototype;

import prototype.framework.Product;

public class MessageBox implements Product {
	
	private char dechchar;
	public MessageBox(char dechchar) {
		this.dechchar = dechchar;
	}

	@Override
	public void use(String s) {
		int length = s.getBytes().length;
		for (int i = 0; i < length + 4; i++) {
			System.out.print(dechchar);
		}
		System.out.println("");
		System.out.println(dechchar + "" + s + "" + dechchar);
		for (int i = 0; i < length + 4; i++) {
			System.out.print(dechchar);
		}
		System.out.println();
		
	}

	@Override
	public Product createClone() {
		Product p = null;
		try {
			p = (Product)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}

}
