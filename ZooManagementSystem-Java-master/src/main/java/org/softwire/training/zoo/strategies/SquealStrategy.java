package org.softwire.training.zoo.strategies;

public class SquealStrategy implements SoundStrategy{

	@Override
	public void makeSound(String name) {
		System.out.println(name + " squealing.");
	}

}
