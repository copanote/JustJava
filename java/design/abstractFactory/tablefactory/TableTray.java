package abstractFactory.tablefactory;

import java.util.Iterator;

import abstractFactory.factory.Item;
import abstractFactory.factory.Tray;

public class TableTray extends Tray {
	public TableTray(String caption) {
		super(caption);
	}

	@Override
	public String makeHTML() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("<td>");
		buffer.append("<table width=\"100%'\" border =\"1\"><tr>");
		buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" clospan=\"" + tray.size() + "\"><b>" + caption + "</b></td>");
		buffer.append("/tr>\n");
		buffer.append("<tr>\n");
		
		Iterator it = tray.iterator();
		while(it.hasNext()) {
			Item item = (Item)it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</tr></table>");
		buffer.append("</td>");
		
		return buffer.toString();
	}
	
	

}
