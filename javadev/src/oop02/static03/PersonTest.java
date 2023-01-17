package oop02.static03;

public class PersonTest {
  public static void main(String[] args) {
    Person p1 = new Person("Kim", "KR");
    Person p2 = new Person("Park", "KR");

    System.out.print(p1 + "\n");
    System.out.print(p2 + "\n");

    System.out.println("========================================");

    p1.setName("Lee");;
    p1.setNation("US");

    System.out.print(p1 + "\n");
    System.out.print(p2 + "\n");
  }
}
