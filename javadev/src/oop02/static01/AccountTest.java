package oop02.static01;

public class AccountTest {
  public static void main(String[] args) {
    Account acc1 = new Account(10000);
    System.out.println("acc1.money1 : " + Account.money1);
    System.out.println("acc1.money2 : " + acc1.money2);

    Account acc2 = new Account(10000);
    System.out.println("acc2.money1 : " + Account.money1);
    System.out.println("acc2.money2 : " + acc2.money2);

    Account acc3 = new Account(10000);
    System.out.println("acc3.money1 : " + Account.money1);
    System.out.println("acc3.money2 : " + acc3.money2);

  }
}
