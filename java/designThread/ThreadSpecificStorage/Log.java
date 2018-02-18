package ThreadSpecificStorage;

public class Log {
	private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();
	
	//로그를 적는다.
	public static void println(String s) {
		getTSLog().println(s);
	}
	
	//로그를 닫는다. 
	public static void close() {
		getTSLog().close();
	}
	
	
	
	
	//쓰레드 고유의 로그를 구한다.
	public static TSLog getTSLog() {
		TSLog tsLog = tsLogCollection.get();
		
		//그 쓰레드에서 처음 호출하는 것이라면 신규로 작성해야 한다.
		if(tsLog == null) {
			tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
			tsLogCollection.set(tsLog);
		}
		
		return tsLog;
	}

}
