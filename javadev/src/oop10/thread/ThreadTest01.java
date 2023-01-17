package oop10.thread;

public class ThreadTest01 {
	public static void main(String[] args) {
		run();

		for (int i = 1; i <= 5; i++) {
			System.out.printf("main : %d \n", i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.printf("run : %d \n", i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
