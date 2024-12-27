package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.softwire.training.zoo.strategies.RoarStrategy;
import org.softwire.training.zoo.strategies.WalkStrategy;

public class Zebra extends LargeAnimal implements CanBeGroomed {
	public Zebra(String name, String color, String habitat, LocalDate dateOfBirth, int strengthLevel) {
		super(name, color, habitat, dateOfBirth, new WalkStrategy(), new RoarStrategy(), strengthLevel);
	}

	private LocalDateTime lastGroomed;

	
    @Override
    public void groom() {
        lastGroomed = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }
}
