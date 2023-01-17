package oop06.inter03;

public abstract class RemoteTV implements RemoteControl {

	@Override
	public void powerOn() {
		System.out.println("RemoteTV Power On!");
	}

	@Override
	public void powerOff() {
		System.out.println("RemoteTV Power Off!");
	}

	@Override
	public void ChannelUp() {
		System.out.println("RemoteTV Channel Up!");
	}

}
