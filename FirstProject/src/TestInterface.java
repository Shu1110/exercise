interface TakeCarePet {
	public void feeding();

	public void playing();
}

class Worker implements TakeCarePet {
	public void feeding() {
		System.out.println("Worker feeding pet!");
	}

	public void playing() {
		System.out.println("Worker playing with pet!");
	}
}

class Farmer implements TakeCarePet {
	public void feeding() {
		System.out.println("Farmer feeding pet!");
	}

	public void playing() {
		System.out.println("Farmer playing with pet!");
	}
}

class Cadre implements TakeCarePet {
	public void feeding() {
		System.out.println("Cadre feeding pet!");
	}

	public void playing() {
		System.out.println("Cadre playing with pet!");
	}
}

public class TestInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TakeCarePet b1 = new Worker();
		TakeCarePet b2 = new Farmer();
		TakeCarePet b3 = new Cadre();
		b1.feeding();
		b1.playing();
		b2.feeding();
		b2.playing();
		b3.feeding();
		b3.playing();
		// TODO Auto-generated method stub

	}

}
