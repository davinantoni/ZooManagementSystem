package org.softwire.training.zoo.states;

public class HungryState implements AnimalState{

	@Override
	public void feed() {
		System.out.println("The animal is being fed. It is no longer hungry.");
	}

	@Override
	public void groom() {
		System.out.println("The animal is too hungry to be groomed!");
	}

	@Override
	public void play() {
		System.out.println("The animal is too hungry to play.");
	}

}
