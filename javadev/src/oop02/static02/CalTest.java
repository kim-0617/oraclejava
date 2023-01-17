package oop02.static02;

public class CalTest {
  public static void main(String[] args) {
    double result1 = 10 * 10 * Calculator.pi;
    System.out.println(result1);

    int result2 = Calculator.plus(10, 20);
    int result3 = Calculator.minus(10, 20);

    System.out.printf("%d %d", result2, result3);
  }
}
