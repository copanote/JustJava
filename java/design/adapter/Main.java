package adapter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Print p = new PrintBanner("Hello");
		p.printStrong();
		p.printWeak();
		
		PrintDelegation pd = new PrintBannerDelegation("Good!");
		pd.printStrong();
		pd.printWeak();

	}

}
