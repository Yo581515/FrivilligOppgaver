package Frivillig4Packe;

public class tester {
	
	
	public static void main(String[] args) {
		
		final String LETTERS = "[A-Za-z]*";
		
		String a ="edlfsdA";
		String b="bdhfhA";
		String c="";
		
		System.out.println(a.matches("^"+LETTERS+"$"));
		System.out.println(b.matches("^"+LETTERS+"$"));
		System.out.println(c.equals(null));
		
		
	}

}
