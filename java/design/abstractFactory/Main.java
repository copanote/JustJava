package abstractFactory;


import abstractFactory.factory.Factory;
import abstractFactory.factory.Link;
import abstractFactory.factory.Page;
import abstractFactory.factory.Tray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		if (args.length != 1) {
//			System.out.println("usage");
//			System.exit(0);
//		}
		String listfactory = "abstractFactory.listfactory.ListFactory";
		String tablefactory = "abstractFactory.tablefactory.TableFactory";
		Factory factory = Factory.getFactory(tablefactory);
		
		Link joins = factory.createLink("�߾��Ϻ�", "http://www.joins.com/");
		Link chosun = factory.createLink("�����Ϻ�", "http://www.chosun.com/");
		
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link kr_yahoo = factory.createLink("Yahoo!Korea", "http://yahoo.co.kr/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http://www.google.com");
		
		Tray traynews = factory.createTray("�Ź�");
		traynews.add(joins);
		traynews.add(chosun);
		
		Tray trayyahoo = factory.createTray("Yahoo");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(kr_yahoo);
		
		Tray traysearch = factory.createTray("�˻�����");
		traysearch.add(excite);
		traysearch.add(google);
		
		Page page = factory.createPage("LinkPage", "��������");
		page.add(traynews);
		page.add(traysearch);
		
		page.output();
		

	}

}
