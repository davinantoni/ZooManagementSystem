package org.softwire.training.zoo.models;

import org.softwire.training.zoo.Config;
import org.softwire.training.zoo.states.AnimalState;
import org.softwire.training.zoo.states.HungryState;
import org.softwire.training.zoo.strategies.MovementStrategy;
import org.softwire.training.zoo.strategies.SoundStrategy;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class AbstractAnimal implements Animal {
	private String name; //Atribut name sampai habitat baru ditambahkan
	private String color;
	private String habitat;
    private LocalDate dateOfBirth;
    private LocalDateTime lastFed;
    private MovementStrategy movementStrategy;
    private SoundStrategy soundStrategy;
    private AnimalState state;

    public AbstractAnimal(String name, String color, String habitat,
			LocalDate dateOfBirth, MovementStrategy movementStrategy, SoundStrategy soundStrategy) {
		super();
		this.name = name; 
		this.color = color;
		this.habitat = habitat;
		this.dateOfBirth = dateOfBirth;
		this.movementStrategy = movementStrategy;
        this.soundStrategy = soundStrategy;
        this.state = new HungryState(); // Default state
	}
    
    // overload constructor for prototype
	public AbstractAnimal(AbstractAnimal animal) {
		this.name = animal.name;
		this.color = animal.color;
		this.habitat = animal.habitat;
		this.dateOfBirth = animal.dateOfBirth;
		this.lastFed = animal.lastFed;
		this.movementStrategy = animal.movementStrategy;
		this.soundStrategy = animal.soundStrategy;
	}
	
	// clone for prototype
	public abstract Animal clone();
	
	public void setState(AnimalState state) {
        this.state = state;
    }

    public AnimalState getState() {
        return state;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getLastFed() {
		return lastFed;
	}

	public void setLastFed(LocalDateTime lastFed) {
		this.lastFed = lastFed;
	}

	public Duration age() {
        return Duration.between(LocalDate.now(), dateOfBirth);
    }
	
	public void performMove() {
		
        movementStrategy.move(name);
    }
	

    public MovementStrategy getMovementStrategy() {
		return movementStrategy;
	}

	public SoundStrategy getSoundStrategy() {
		return soundStrategy;
	}

	public void performSound() {
        soundStrategy.makeSound(name);
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void setSoundStrategy(SoundStrategy soundStrategy) {
        this.soundStrategy = soundStrategy;
    }

    @Override
    public void feed() {
        lastFed = LocalDateTime.now();
    }

    @Override
    public boolean isHungry() {
        // Obviously an animal wouldn't get hungry in a matter of seconds.
        // But it means we can see activity in real time when we run the code...
        return Duration.between(LocalDateTime.now(), lastFed).compareTo(Config.getFeedingFrequency()) > 0;
    }
    
    public void getInfo() {
    	System.out.println("Name: " + name);
		System.out.println("Color: " + color);
		System.out.println("Habitat: " + habitat);
		System.out.println("Date of Birth: " + dateOfBirth);
		System.out.println("Movement Strategy: " + movementStrategy.getClass().getSimpleName());
		System.out.println("Sound Strategy: " + soundStrategy.getClass().getSimpleName());
    }
    
}
