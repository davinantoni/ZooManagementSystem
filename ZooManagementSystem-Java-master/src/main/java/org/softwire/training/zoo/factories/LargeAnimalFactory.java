package org.softwire.training.zoo.factories;

import java.time.LocalDate;

import org.softwire.training.zoo.models.LargeAnimal;
import org.softwire.training.zoo.models.Lion;
import org.softwire.training.zoo.models.Zebra;
import org.softwire.training.zoo.strategies.MovementStrategy;
import org.softwire.training.zoo.strategies.SoundStrategy;

public class LargeAnimalFactory extends AnimalFactory{

	@Override
	public LargeAnimal createAnimal(String name, String color, String habitat, LocalDate dateOfBirth, int level, MovementStrategy movementStrategy, SoundStrategy soundStrategy) {
		return new LargeAnimal(name, color, habitat, dateOfBirth, movementStrategy, soundStrategy, level);
	}
	
}
