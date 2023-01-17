package basic;

public class WhileTest02 {
  public static void main(String[] args) {
    int sum = 0;
    int i = 1;
    while (i <= 1000) {
      if (i % 3 == 0) {
        sum += i;
      }
      i++;
    }
    System.out.println(sum);
  }
}
