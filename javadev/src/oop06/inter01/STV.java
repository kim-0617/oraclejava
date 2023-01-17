package oop06.inter01;

public class STV implements TV {
  private Speaker speaker = new AppleSpeaker();

  @Override
  public void channelUp() {
    System.out.println("STV 채널을 올립니다.");
  }

  @Override
  public void channelDown() {
    System.out.println("STV 채널을 올립니다.");
  }

  @Override
  public void turnOn() {
    System.out.println("STV 전원을 켭니다.");
  }

  @Override
  public void turnOff() {
    System.out.println("STV 전원을 끕니다.");
  }

  @Override
  public void soundUp() {
    // System.out.println("STV 볼륨을 올립니다.");
    speaker.soundUp();
  }

  @Override
  public void soundDown() {
    // System.out.println("STV 볼륨을 올립니다.");
    speaker.soundDown();
  }
}
