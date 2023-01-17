package basic;

public class ForTest03 {
  public static void main(String[] args) {
    // Q7. 1부터 1000까지 정수 중 3의 배수 합계를 구하세요 - for
    int sum = 0;
    for (int i = 1; i <= 1000; i += 1) {
      if (i % 3 == 0)
        sum += i;
    }
    System.out.println(sum);
  }
}
