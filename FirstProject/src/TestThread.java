public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1("t1");

		// TODO Auto-generated method stub

	}

}

class MyThread1 extends Thread {
	MyThread1(String s) {
		super(s);
	}

	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println(getName() + ":" + i);
			if (i % 10 == 0) {
				yield();
			}
		}
	}
}