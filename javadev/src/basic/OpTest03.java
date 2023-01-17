package basic;

public class OpTest03 {
	public static void main(String[] args) {
		boolean a, b;
		a = true;
		b = true;
		
		System.out.println(a && b);
		
		a = false;
		b = true;
		System.out.println(a && b);
		System.out.println(a || b);
		System.out.println(true ^ false ^ false ^ false ^ false);
	}
}
