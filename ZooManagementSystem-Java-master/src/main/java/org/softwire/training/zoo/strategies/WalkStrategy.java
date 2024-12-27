package org.softwire.training.zoo.strategies;

public class WalkStrategy implements MovementStrategy{

	@Override
	public void move(String name) {
		System.out.println(name + " walks quickly.");
	}

}
