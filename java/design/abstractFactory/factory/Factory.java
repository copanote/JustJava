package abstractFactory.factory;

public abstract class Factory {
	public static Factory getFactory(String classname) {
		Factory factory = null;
		
		try {
			factory = (Factory)Class.forName(classname).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factory;
	}
	public abstract Link createLink(String caption, String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title, String author);
}
