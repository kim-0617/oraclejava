package basic;

public class MethodTest01 {
  public static void main(String[] args) {
    print();
    print("Hi there");

    int a = 7, b = 4;
    System.out.printf("%d + %d = %d \n", a, b, add(a, b));
    System.out.printf("%d - %d = %d \n", a, b, sub(a, b));
    System.out.printf("%d * %d = %d \n", a, b, mul(a, b));
    System.out.printf("%d / %d = %f \n", a, b, div(a, b));
    System.out.printf("%d // %d = %d \n", a, b, mod(a, b));
  }

  private static int mod(int a, int b) {
    return a % b;
  }

  private static double div(int a, int b) {
    return a / b;
  }

  private static int mul(int a, int b) {
    return a * b;
  }

  private static int sub(int a, int b) {
    return a - b;
  }

  private static int add(int a, int b) {
    return a + b;
  }

  private static void print(String string) {
    System.out.println(string);
  }

  private static void print() {
    System.out.println("Hello");
  }
}
