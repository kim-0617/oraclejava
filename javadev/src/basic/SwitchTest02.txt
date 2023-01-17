package basic;

import java.util.Scanner;

public class SwitchTest02 {
  public static void main(String[] args) {
    // Q5. switch case 이용
    // 1,3 => 남자, 2,4 => 여자
    Scanner sc = new Scanner(System.in);
    System.out.print("숫자를 입력해 주세요 : ");
    int id = sc.nextInt();

    switch (id) {
      case 1:
      case 3: {
        System.out.println("남자!");
        break;
      }

      case 2:
      case 4: {
        System.out.println("여자!");
        break;
      }
      default:
        System.out.println("에러!");
        break;
    }
    sc.close();
  }
}
