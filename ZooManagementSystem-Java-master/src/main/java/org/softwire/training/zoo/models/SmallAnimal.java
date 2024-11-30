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

	public int getSpeedLevel() {
		return speedLevel;
	}

	public void setSpeedLevel(int speedLevel) {
		this.speedLevel = speedLevel;
	}


//    public abstract void escape();
}
