package oop06.inter01;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new LgTV();

		tv.turnOn();

		tv.channelUp();
		tv.channelUp();
		tv.channelUp();

		tv.soundUp();
		tv.soundDown();

		tv.turnOff();
	}
}
