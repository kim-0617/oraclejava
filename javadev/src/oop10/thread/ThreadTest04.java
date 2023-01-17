package oop10.thread;

public class ThreadTest04 extends Thread {
	public static void main(String[] args) {
		ThreadTest04 t = new ThreadTest04();
		t.setName("run");
		t.start();

		for (int i = 1; i <= 5; i++) {
			System.out.printf(Thread.currentThread().getName() + "  :  %d \n", i);
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
			System.out.printf(Thread.currentThread().getName() + "  :  %d \n", i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
