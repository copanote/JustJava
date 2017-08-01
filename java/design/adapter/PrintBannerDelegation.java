package adapter;

public class PrintBannerDelegation extends PrintDelegation {
	private Banner banner;

	public PrintBannerDelegation(String string) {
		this.banner = new Banner(string);
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		banner.showWithAster();
	}

}
