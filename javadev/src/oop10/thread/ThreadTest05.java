package oop10.thread;

public class ThreadTest05 extends Thread {
	public static void main(String[] args) {
		ThreadTest05 t1 = new ThreadTest05();
		ThreadTest05 t2 = new ThreadTest05();
		ThreadTest05 t3 = new ThreadTest05();

		t1.setName("t1");
		t1.start();

		t2.setName("t2");
		t2.start();

		t3.setName("t3");
		t3.start();
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
