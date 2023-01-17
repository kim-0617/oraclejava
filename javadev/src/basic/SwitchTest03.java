package basic;

import java.util.Scanner;

public class SwitchTest03 {
  public static void main(String[] args) {
    // Q6. score => switch~case
    Scanner sc = new Scanner(System.in);
    System.out.print("점수를 입력해 주세요 : ");
    int score = sc.nextInt();
    char alpha;

    if (score >= 90) {
      alpha = 'A';
    } else if (score >= 80) {
      alpha = 'B';
    } else if (score >= 70) {
      alpha = 'C';
    } else if (score >= 60) {
      alpha = 'D';
    } else {
      alpha = 'F';
    }

    switch (alpha) {
      case 'A': {
        System.out.println("A");
        break;
      }
      case 'B': {
        System.out.println("B");
        break;
      }
      case 'C': {
        System.out.println("C");
        break;
      }
      case 'D': {
        System.out.println("D");
        break;
      }
      default:
        System.out.println('F');
    }

    sc.close();
  }
}
