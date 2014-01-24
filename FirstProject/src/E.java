public class E {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b = new B();
		Com com = b;
		System.out.println(com.add(12, 6));
		A a = b;
		System.out.println(a.add(10, 5));
		// TODO Auto-generated method stub

	}

}

interface Com {
	int add(int a, int b);
}

interface Coma {
	double f(double a, double b);
}

abstract class A {
	abstract int add(int a, int b);
}

class B extends A implements Com, Coma {
	public int add(int a, int b) {
		return a + b;
	}

	public double f(double a, double b) {
		return a + b;
	}

}