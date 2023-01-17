package basic;

public class IfTest01 {
	public static void main(String[] args) {
		int n = 3;
		
		if(n == 1) {
			System.out.println("n == 1");
		}
		else if(n ==2) {
			System.out.println("n == 2");
		}
		else {
			System.out.println("n != 1 && n != 2");
		}
		
		System.out.println("종료");
	}
}
