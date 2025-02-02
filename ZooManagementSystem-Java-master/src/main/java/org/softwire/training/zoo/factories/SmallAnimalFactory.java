package org.softwire.training.zoo.factories;

import java.time.LocalDate;

import org.softwire.training.zoo.models.AbstractAnimal;
import org.softwire.training.zoo.models.Rabbit;
import org.softwire.training.zoo.models.SmallAnimal;
import org.softwire.training.zoo.strategies.MovementStrategy;
import org.softwire.training.zoo.strategies.SoundStrategy;

public class SmallAnimalFactory extends AnimalFactory{

	@Override
	public SmallAnimal createAnimal(String name, String color, String habitat, LocalDate dateOfBirth, int level, MovementStrategy movementStrategy, SoundStrategy soundStrategy) {
		return new SmallAnimal(name, color, habitat, dateOfBirth, movementStrategy, soundStrategy, level); 
	}
	
}
