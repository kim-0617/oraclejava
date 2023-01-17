package oop06.inter05;

public class FlyingCar implements Flyable, Drivable {

	@Override
	public void drive() {
		System.out.println("Driving...");
	}

	@Override
	public void fly() {
		System.out.println("Flying...");
	}

}
