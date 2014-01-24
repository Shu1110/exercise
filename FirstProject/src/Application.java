public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		simulator.playSound(new Dog());
		simulator.playSound(new Cat());
		// TODO Auto-generated method stub

	}

}

abstract class Animal {

	void cry() {
		System.out.println("crying...");
	}

	String getAnimalName() {
		System.out.println("This is Animal.");
		return null;
	}
}

class Dog extends Animal {
	void cry() {
		System.out.println("Dog crying...");
	}

	String getAnimalName() {
		System.out.println("This is a Dog.");
		return null;
	}
}

class Cat extends Animal {
	void cry() {
		System.out.println("Cat crying...");
	}

	String getAnimalName() {
		System.out.println("This is a Cat.");
		return null;
	}
}

class Simulator {
	void playSound(Animal animal) {
		animal.getAnimalName();
		animal.cry();

	}
}