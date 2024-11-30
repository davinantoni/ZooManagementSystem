package org.softwire.training.zoo.models;

import java.time.LocalDate;

import org.softwire.training.zoo.strategies.MovementStrategy;
import org.softwire.training.zoo.strategies.SoundStrategy;

public class LargeAnimal extends AbstractAnimal {
	private int strengthLevel;
	
	public LargeAnimal(String name, String color, String habitat, LocalDate dateOfBirth,
			MovementStrategy movementStrategy, SoundStrategy soundStrategy, int strengthLevel) {
		super(name, color, habitat, dateOfBirth, movementStrategy, soundStrategy);
		// TODO Auto-generated constructor stub
		this.strengthLevel = strengthLevel;
	}

	public int getStrengthLevel() {
		return strengthLevel;
	}

	public void setStrengthLevel(int strengthLevel) {
		this.strengthLevel = strengthLevel;
	}


//    public abstract void showStrength();
}
