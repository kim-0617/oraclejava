package oop05.abstract02;

public class Dog extends Animal {
  public void bark() {
    System.out.println("개가 짖습니다.");
  }

  @Override
  public void sleep() {
    System.out.println("개가 잡니다.");
  }
}
