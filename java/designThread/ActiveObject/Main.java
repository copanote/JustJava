package ActiveObject;

public class Main {

	public static void main(String[] args) {
		ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
		new MakerClientThread("Alice", activeObject).start();
		new MakerClientThread("Bobby", activeObject).start();
		new MakerClientThread("Chris", activeObject).start();

		

	}

}
