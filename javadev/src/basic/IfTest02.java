package basic;

import java.util.Scanner;

public class IfTest02 {
	public static void main(String[] args) {
		// Q4. score(if)
		// 0 ~ 100 사이의 점수 입력 받아서 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점이상이면 D 그 외 F
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해 주세요 : ");
		int score = sc.nextInt();
		
		if(score >= 90) {
			System.out.println("A");
		} else if(score >= 80) {
			System.out.println("B");
		} else if(score >= 70) {
			System.out.println("C");
		} else if(score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		sc.close();
	}
}
