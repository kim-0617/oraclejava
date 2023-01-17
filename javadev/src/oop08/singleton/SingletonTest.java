package oop08.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstantce();
		Singleton s2 = Singleton.getInstantce();

		if (s1 == s2) {
			System.out.println("same object");
		} else {
			System.out.println("different object");
		}
	}
}
