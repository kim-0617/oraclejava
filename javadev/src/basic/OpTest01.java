package basic;

import java.util.Scanner;

public class OpTest01 {
	public static void main(String[] args) {
		//		System.in => 표준입력 (키보드 입력)
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 a 값 입력 : ");
		int a = sc.nextInt();
		
		System.out.print("정수 b 값 입력 : ");
		int b = sc.nextInt();
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		
		sc.close();
	}
}
