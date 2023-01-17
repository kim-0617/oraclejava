package basic;

public class ArrayTest03 {
  public static void main(String[] args) {
    int[][] score = {{100, 90, 80, 70}, {90, 80, 70, 60}, {80, 70, 60, 50}};

    System.out.println("배열의 길이 : " + score.length);
    System.out.println("");

    for (int i = 0; i < score.length; i++) {
      int total = 0;
      double avg = 0;
      for (int j = 0; j < score[i].length; j++) {
        System.out.printf("%d행 %d열의 값 : %d \n", i, j, score[i][j]);
        total += score[i][j];
      }

      avg = total / score[i].length;
      System.out.println(i + "행 총점 : " + total);
      System.out.println(i + "행 평균 : " + avg);
      System.out.println("");
    }
  }
}
