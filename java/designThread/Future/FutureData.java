package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements Data {
	public FutureData(Callable<RealData> callable) {
		super(callable);
	}

	@Override
	public String getContent() {
		String string = null;
		try {
			string = get().getContent();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return string;
	}
	
}
