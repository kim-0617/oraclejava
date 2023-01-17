package oop07.anony;

public class AnonyTest {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.turnOn();
		anony.method1();
		anony.method2(new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("SmatTv를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("SmatTv를 끕니다.");
			}
		});
	}
}
