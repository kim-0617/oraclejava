package basic;

import java.util.Scanner;

public class OpTest07 {
	public static void main(String[] args) {
		int a = 5;
		String str = a > 6 ? "big" : "small"; 
		System.out.println(str);
		System.out.println(a == 5 ? "5 입니다" : "5 아닙니다");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("id를 입력해 주세요 : ");
		int id = sc.nextInt();
		System.out.println(
				id == 1 ? "남자" :
				id == 2 ? "여자" : 
					"에러"
		);
		sc.close();
	}
}
