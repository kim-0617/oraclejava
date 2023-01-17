package oop06.inter02;

public class Pitcher implements BodySign {

	@Override
	public void throwBall(int how) {
		String str = null;

		switch (how) {
			case BodySign.CENTER:
				str = "가운데";
				break;
			case BodySign.LEFT:
				str = "왼쪽";
				break;
			case BodySign.RIGHT:
				str = "오른쪽";
				break;
			case BodySign.DOWN:
				str = "아래";
				break;
			case BodySign.UP:
				str = "위";
				break;
			default:
				str = "???";
		}
		System.out.println("방향 : " + str);
	}

}
