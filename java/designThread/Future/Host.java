package Future;

import java.util.concurrent.Callable;

public class Host {
	public Data request(final int count, final char c) {
		System.out.println("   request(" + count + ", " + c + ") BEGIN");
		
		//(1) FutureData의 인스턴스를 만든다.
		// 생성자에게 Callable<RealData>를 건넨다
		final FutureData future = new FutureData(
				new Callable<RealData>() {
					@Override
					public RealData call() throws Exception {
						return new RealData(count, c);
					}
				});
		
		//(2) RealData를 만들기 위해 새로운 쓰레드를 기동한다.
		new Thread(future).start();
		System.out.println("   request(" + count + ", " + c + ") END");
		
		//(3) FutureData의 인스턴스를 반환 값으로 한다.
		return future;
	}

}
