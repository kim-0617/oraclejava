package basic;

public class DoWhileTest02 {
  public static void main(String[] args) {
    int n1, n2;
    n1 = (int) (Math.random() * 6) + 1;

    do {
      n2 = (int) (Math.random() * 6) + 1;
    } while (n2 == n1);

    System.out.printf("%d %d", n1, n2);
  }
}
