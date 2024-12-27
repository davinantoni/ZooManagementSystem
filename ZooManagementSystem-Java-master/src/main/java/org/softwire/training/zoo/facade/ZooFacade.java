package org.softwire.training.zoo.facade;


import java.util.List;

import org.softwire.training.zoo.models.AbstractAnimal;
import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;
import org.softwire.training.zoo.states.HappyState;

public class ZooFacade {
		private FeedingScheduler feedingScheduler;
	    private GroomingScheduler groomingScheduler;

	    public ZooFacade() {
	        this.feedingScheduler = FeedingScheduler.getInstance();
	        this.groomingScheduler = GroomingScheduler.getInstance();
	    }

	    public void scheduleFeedingJobs(List<Keeper<? extends Animal>> keepers) {
	        feedingScheduler.assignFeedingJobs(keepers);
	    }

	    public void scheduleGroomingJobs(List<Keeper<? extends Animal>> keepers) {
	        groomingScheduler.assignGroomingJobs(keepers);
	    }
	    
	    public void scheduleDailyCare(List<Keeper<? extends Animal>> keepers) {
	        System.out.println("Scheduling feeding and grooming jobs...");
	        scheduleFeedingJobs(keepers);
	        scheduleGroomingJobs(keepers);
	        changeAllAnimalStatesToHappy(keepers);

	    }
	    
	    private void changeAllAnimalStatesToHappy(List<Keeper<? extends Animal>> keepers) {
	        keepers.forEach(keeper -> 
	            keeper.getResponsibleAnimals().forEach(animal -> {
	                if (animal instanceof AbstractAnimal) {
	                    AbstractAnimal abstractAnimal = (AbstractAnimal) animal;
	                    abstractAnimal.setState(new HappyState());
	                }
	            })
	        );
	    }
}
