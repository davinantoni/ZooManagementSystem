package org.softwire.training.zoo.commands;

import java.util.List;

import org.softwire.training.zoo.models.AbstractAnimal;
import org.softwire.training.zoo.states.AnimalState;

public class ChangeStateCommand implements Command {
		private List<AbstractAnimal> animals;
	    private AnimalState newState;

	    public ChangeStateCommand(List<AbstractAnimal> animals, AnimalState newState) {
	        this.animals = animals;
	        this.newState = newState;
	    }

	    @Override
	    public void execute() {
	        animals.forEach(animal -> {
	            animal.setState(newState);
//	            System.out.println(animal.getName() + " state changed to: " + newState.getClass().getSimpleName());
	        });
	    }
}
