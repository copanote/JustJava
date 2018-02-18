package ThreadSpecificStorage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {
	private PrintWriter writer = null;
	
	public TSLog(String filename) {
		try {
			writer = new PrintWriter(new FileWriter(filename));
		}catch(IOException e) {
			e.printStackTrace();
		} 
	}
	
	//log를 적는다
	public void println(String s) {
		writer.println(s);
	}
	
	// log를 닫는다. 
	public void close() {
		writer.println("===== End of log =====");
		writer.close();
	}

}
