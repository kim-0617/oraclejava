package basic;

public class DoWhileTest01 {
  public static void main(String[] args) {
    int sum = 0;

    int i = 1;
    do {
      if (i % 3 == 0) {
        sum += i;
      }
      i++;
    } while (i <= 1000);

    System.out.println(sum);
  }
}
