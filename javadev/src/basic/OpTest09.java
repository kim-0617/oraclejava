package basic;

public class OpTest09 {
	public static void main(String[] args) {
		double d = 10;
		System.out.println(d); // 자동 형변환
		
		int i = (int) 3.141592;
		System.out.println(i); // 강제 형변환
		
		System.out.println((int)(Math.random() * 6) + 1);
	}
}
