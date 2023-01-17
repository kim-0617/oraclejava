package oop04.polyb;

public class AnimalTest {
  public static void main(String[] args) {
    Animal a = new Dog();

    Dog d = (Dog) a;
    d.eat();
    d.sleep();
    d.bark();

  }
}
