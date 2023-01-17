package oop06.inter04;

public class FlyingCarTest {
	public static void main(String[] args) {
		FlyingCar car = new FlyingCar();
		car.setSpeed(100);
		System.out.println(car.getSpeed());

		car.fly();
	}
}
