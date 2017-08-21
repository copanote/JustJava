package flyweight;

public class BigString {
	private BigChar[] bigchars;
	
	public BigString(String string) {
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for(int i = 0; i < bigchars.length; i++) {
			bigchars[i] = factory.getBigChar(string.charAt(i));
		}
	}
	
	//Ç¥½Ã
	public void print() {
		for(int i = 0 ; i <bigchars.length; i++) {
			bigchars[i].print();
		}
	}

}
