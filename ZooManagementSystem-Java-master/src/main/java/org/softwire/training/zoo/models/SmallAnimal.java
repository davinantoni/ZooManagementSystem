package org.softwire.training.zoo.models;

import java.time.LocalDate;

import org.softwire.training.zoo.strategies.MovementStrategy;
import org.softwire.training.zoo.strategies.SoundStrategy;

public class SmallAnimal extends AbstractAnimal {
	private int speedLevel;

	public SmallAnimal(String name, String color, String habitat, LocalDate dateOfBirth,
			MovementStrategy movementStrategy, SoundStrategy soundStrategy, int speedLevel) {
		super(name, color, habitat, dateOfBirth, movementStrategy, soundStrategy);
		this.speedLevel = speedLevel;
	}
	
	// overload constructor for prototype
	public SmallAnimal(AbstractAnimal animal, int speedLevel) {
		super(animal);
		this.speedLevel = speedLevel;
	}

	public int getSpeedLevel() {
		return speedLevel;
	}

	public void setSpeedLevel(int speedLevel) {
		this.speedLevel = speedLevel;
	}

	
	// clone itself for prototype
	@Override
	public Animal clone() {
		// TODO Auto-generated method stub
		return new SmallAnimal(this, this.speedLevel);
	}

	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Speed Level: " + speedLevel);
	}
	
}
