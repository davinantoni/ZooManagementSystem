package org.softwire.training.zoo.facade;


import java.util.List;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;

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
	    }
}
