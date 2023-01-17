package basic;

public class OpTest10 {
	public static void main(String[] args) {
		// Q2. 난수 발생 (4 ~ 15 사이의 정수 발생)
		System.out.println((int)(Math.random() * 12) + 4);
		
		// Q3. 난수 발생 (600 부터 2300 사이의 100단위 정수 발생)
		System.out.println(((int)(Math.random() * 18) + 6) * 100);
	}
}
