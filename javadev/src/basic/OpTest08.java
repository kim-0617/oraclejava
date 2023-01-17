package basic;

import java.util.Scanner;

public class OpTest08 {
	public static void main(String[] args) {
		// Q1 정수를 입력 받아서 짝수인지 홀수인지 판별 - 3항 연산자
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(i < 10) {
			System.out.print("정수를 입력해 주세요 : ");
			int id = sc.nextInt();
			
			System.out.println(id % 2 != 0 ? "홀수 입니다." : "짝수 입니다.");
			System.out.print("\n");
			i++;
		}
		sc.close();
	}
}
