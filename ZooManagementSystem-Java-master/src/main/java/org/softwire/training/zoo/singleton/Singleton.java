package org.softwire.training.zoo.singleton;

import java.util.ArrayList;
import java.util.List;

import org.softwire.training.zoo.models.AbstractAnimal;
import org.softwire.training.zoo.models.LargeAnimal;
import org.softwire.training.zoo.models.SmallAnimal;

public class Singleton {
	private static volatile Singleton instance = null;
	private ArrayList<AbstractAnimal> db;
	
	private Singleton() {
		db = new ArrayList<AbstractAnimal>();
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
	public int checkDB() {
		return db.size();
	}
	
	public void addAnimal(AbstractAnimal animal) {
		db.add(animal);
	}
	
	public void viewAll() {
		for(int i=0 ; i<db.size() ; i++) {
			AbstractAnimal show = db.get(i);
			System.out.println("Name: " + show.getName());
 		    System.out.println("Color: " + show.getColor());
 		    System.out.println("Habitat: " + show.getHabitat());
 		    System.out.println("Date of Birth: " + show.getDateOfBirth());
 		    System.out.println("Movement Strategy: " + show.getMovementStrategy().getClass().getSimpleName());
 		    System.out.println("Sound Strategy: " + show.getSoundStrategy().getClass().getSimpleName());
 		    if (show instanceof LargeAnimal) {
 		        LargeAnimal largeAnimal = (LargeAnimal) show;
 		        System.out.println("Strength Level: " + largeAnimal.getStrengthLevel());
 		    } else if (show instanceof SmallAnimal) {
 		        SmallAnimal smallAnimal = (SmallAnimal) show;
 		        System.out.println("Speed Level: " + smallAnimal.getSpeedLevel());
 		    }
 		    System.out.println("------------------------");
		}
	}
	
	public void animalList() {
		for(int i=0 ; i<db.size() ; i++) {
			AbstractAnimal show = db.get(i);
        	String movementStrategy2 = show.getMovementStrategy().getClass().getSimpleName();
        	String soundStrategy2 = show.getSoundStrategy().getClass().getSimpleName();
            System.out.println((i + 1) + ". " + show.getName() + ", Movement: " + movementStrategy2 + ", Sound: " +
            						soundStrategy2);
		}
	}
	
	 public List<AbstractAnimal> getAnimals() {
	        return db;
	    }
}
