package oop06.inter01;

public class BoseSpeaker implements Speaker {
	@Override
	public void soundUp() {
		System.out.println("Bose Speaker 볼륨 업!");
	}

	@Override
	public void soundDown() {
		System.out.println("Bose Speaker 볼륨 다운!");
	}

}
