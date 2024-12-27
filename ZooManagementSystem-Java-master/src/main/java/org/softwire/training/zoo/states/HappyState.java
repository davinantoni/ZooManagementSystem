package org.softwire.training.zoo.states;

public class HappyState implements AnimalState{

	@Override
	public void feed() {
		System.out.println("The animal is happy and does not need food right now.");
	}

	@Override
	public void groom() {
		System.out.println("The animal is happy and enjoys being groomed.");
	}

	@Override
	public void play() {
		 System.out.println("The animal is happy and loves to play!");
	}

}
