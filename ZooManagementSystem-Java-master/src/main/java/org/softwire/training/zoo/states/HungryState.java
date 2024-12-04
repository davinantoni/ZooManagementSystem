package org.softwire.training.zoo.states;

public class HungryState implements AnimalState{

	@Override
	public void feed() {
		// TODO Auto-generated method stub
		System.out.println("The animal is being fed. It is no longer hungry.");
	}

	@Override
	public void groom() {
		// TODO Auto-generated method stub
		System.out.println("The animal is too hungry to be groomed!");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("The animal is too hungry to play.");
	}

}
