package org.softwire.training.zoo.models;

import java.time.LocalDate;

import org.softwire.training.zoo.strategies.RoarStrategy;
import org.softwire.training.zoo.strategies.WalkStrategy;

public class Lion extends LargeAnimal {

	public Lion(String name, String color, String habitat, LocalDate dateOfBirth, int strengthLevel) {
		super(name, color, habitat, dateOfBirth, new WalkStrategy(), new RoarStrategy(), strengthLevel);
	}
	
}
