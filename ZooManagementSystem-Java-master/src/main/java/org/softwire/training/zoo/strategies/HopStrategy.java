package org.softwire.training.zoo.strategies;

public class HopStrategy implements MovementStrategy{

	@Override
	public void move(String name) {
		System.out.println(name + " hops quickly.");
	}

}
