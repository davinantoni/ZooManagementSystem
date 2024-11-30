package org.softwire.training.zoo.factories;

import java.time.LocalDate;

import org.softwire.training.zoo.models.AbstractAnimal;
import org.softwire.training.zoo.strategies.MovementStrategy;
import org.softwire.training.zoo.strategies.SoundStrategy;

public abstract class AnimalFactory {
	public abstract AbstractAnimal createAnimal(String name, String color, String habitat,
			LocalDate dateOfBirth, int level, MovementStrategy movementStrategy, SoundStrategy soundStrategy);
}
