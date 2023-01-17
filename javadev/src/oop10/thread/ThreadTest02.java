package oop10.thread;

public class ThreadTest02 extends Thread {
	public static void main(String[] args) {
		ThreadTest02 t = new ThreadTest02();
		t.start();

		for (int i = 1; i <= 5; i++) {
			System.out.printf("main : %d \n", i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
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
