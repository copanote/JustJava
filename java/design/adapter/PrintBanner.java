package adapter;

public class PrintBanner extends Banner implements Print {

	public PrintBanner(String string) {
		super(string);
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		showWithParen();

	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		showWithAster();

	}

}
