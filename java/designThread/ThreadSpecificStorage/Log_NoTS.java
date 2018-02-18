package ThreadSpecificStorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log_NoTS {
	private static PrintWriter writer = null;
	
	//writer 필드의 초기화 
	static {
		try {
			writer = new PrintWriter(new FileWriter("log.txt"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//log를 적는다
	public static void println(String s) {
		writer.println(s);
	}
	
	// log를 닫는다. 
	public static void close() {
		writer.println("===== End of log =====");
		writer.close();
	}
	
	
	

}
