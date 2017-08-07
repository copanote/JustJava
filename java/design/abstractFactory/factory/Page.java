package abstractFactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public abstract class Page {
	protected String title;
	protected String author;
	protected ArrayList content = new ArrayList();
	public Page(String title, String author) {
		this.title = title;
		this.author = author;
	}
	public void add(Item item) {
		content.add(item);
	}
	
	//Templeate Method. 
	public void output() {
		String filename = title + ".html";
		Writer writer;
		try {
			writer = new FileWriter(filename);
			writer.write(this.makeHTML());
			writer.close();
			System.out.println(filename + "�� �ۼ��Ͽ����ϴ�.");

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract String makeHTML();
	

}
