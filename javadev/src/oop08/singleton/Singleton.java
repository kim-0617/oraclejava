package oop08.singleton;

public class Singleton {
	private static Singleton singleton = null;

	private Singleton() {}

	public static Singleton getInstantce() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
