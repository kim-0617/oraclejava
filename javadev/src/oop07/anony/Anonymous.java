package oop07.anony;

public class Anonymous {
	RemoteControl field = new RemoteControl() {

		@Override
		public void turnOn() {
			System.out.println("Turn On");
		}

		@Override
		public void turnOff() {
			System.out.println("Turn Off");
		}
	};

	public void method1() {
		RemoteControl local = new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("Audio를 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("Audio를 끕니다.");
			}
		};

		local.turnOn();
	}

	public void method2(RemoteControl rc) {
		rc.turnOn();
	}
}
