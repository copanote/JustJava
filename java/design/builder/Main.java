package builder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "html";
//		if (args.length != 1) {
//			usage();
//			System.exit(0);
//		}
//		
		if (input.equals("plain")) {
			TextBuilder textbuilder = new TextBuilder();
			Director director = new Director(textbuilder);
			director.construct();
			String result = textbuilder.getResult();
			System.out.println(result);
		} else if (input.equals("html")) {
			HTMLBuilder htmlbuilder = new HTMLBuilder();
			Director director = new Director(htmlbuilder);
			director.construct();
			String filename = htmlbuilder.getResult();
			System.out.println(filename + "가 작성되었습니다.");
			
		} else {
			usage();
			System.exit(0);
		}

	}
	public static void usage() {
		System.out.println("Usage: java Main plain 일반 텍스트로 문서작성");
		System.out.println("Usage: java Main html HTML파일로 문서작성");
	}

}
