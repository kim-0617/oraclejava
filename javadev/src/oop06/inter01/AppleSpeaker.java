package oop06.inter01;

public class AppleSpeaker implements Speaker {

  @Override
  public void soundUp() {
    System.out.println("Apple Speaker 볼륨 업!");
  }

  @Override
  public void soundDown() {
    System.out.println("Apple Speaker 볼륨 다운!");
  }

}
