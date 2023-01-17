package basic;

public class OpTest04 {
	public static void main(String[] args) {
		int a = 5;
		System.out.printf("%d %d %d", a, a++, ++a );
		
		int i = 5;
		int j = i++;
		System.out.printf("%d %d", i, j);
	}
}
