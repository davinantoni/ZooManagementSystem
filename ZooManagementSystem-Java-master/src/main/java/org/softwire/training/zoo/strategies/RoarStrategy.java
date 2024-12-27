package org.softwire.training.zoo.strategies;

public class RoarStrategy implements SoundStrategy{

	@Override
	public void makeSound(String name) {
		System.out.println(name + " roars mightily!");
	}

}
