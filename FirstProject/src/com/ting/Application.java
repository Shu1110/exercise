package com.ting;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Simulator simulator=new Simulator();
		simulator.playSound(new Dog());
		simulator.playSound(new Cat());
		// TODO Auto-generated method stub

	}

}
interface Animal{
	public void cry();
	public String getAnimalName();
}

class Dog implements Animal{
	public void cry(){
		System.out.println("Dog crying...");
	}
	public String getAnimalName(){
		System.out.println("This is Dog.");
		return null;
	}
}

class Cat implements Animal{
	public void cry(){
		System.out.println("Cat crying...");
	}
	public String getAnimalName(){
		System.out.println("This is Cat.");
		return null;
	}
}

class Simulator{
	void playSound(Animal animal){
		animal.cry();
		animal.getAnimalName();
	}
}