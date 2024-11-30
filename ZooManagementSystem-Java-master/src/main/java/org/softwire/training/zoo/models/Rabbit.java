package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.softwire.training.zoo.strategies.HopStrategy;
import org.softwire.training.zoo.strategies.SquealStrategy;

public class Rabbit extends SmallAnimal implements CanBeGroomed {
	private LocalDateTime lastGroomed;
	
	public Rabbit(String name, String color, String habitat, LocalDate dateOfBirth, int speedLevel) {
		super(name, color, habitat, dateOfBirth, new HopStrategy(), new SquealStrategy(), speedLevel);
		// TODO Auto-generated constructor stub
	}


    @Override
    public void feed() {
        System.out.println("<Munch munch>");
        super.feed();
    }

    @Override
    public void groom() {
        lastGroomed = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}; Last Groomed {1}", super.toString(), lastGroomed);
    }
}
