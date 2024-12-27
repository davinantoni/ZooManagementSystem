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
	
	// overload constructor for prototype
	public LargeAnimal(AbstractAnimal animal, int strengthLevel) {
		super(animal);
		this.strengthLevel = strengthLevel;
	}

	public int getStrengthLevel() {
		return strengthLevel;
	}

	public void setStrengthLevel(int strengthLevel) {
		this.strengthLevel = strengthLevel;
	}
	
	// return instance of itself for prototype
	@Override
	public Animal clone() {
		return new LargeAnimal(this, this.strengthLevel);
	}

	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Strength Level: " + strengthLevel);
	}
	
}
