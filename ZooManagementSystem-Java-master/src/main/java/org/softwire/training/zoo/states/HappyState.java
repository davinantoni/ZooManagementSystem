package org.softwire.training.zoo.states;

public class HappyState implements AnimalState{

	@Override
	public void feed() {
		// TODO Auto-generated method stub
		System.out.println("The animal is happy and does not need food right now.");
	}

	@Override
	public void groom() {
		// TODO Auto-generated method stub
		System.out.println("The animal is happy and enjoys being groomed.");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		 System.out.println("The animal is happy and loves to play!");
	}

}
