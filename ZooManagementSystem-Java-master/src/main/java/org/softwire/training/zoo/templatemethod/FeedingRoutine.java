package org.softwire.training.zoo.templatemethod;

public abstract class FeedingRoutine {

	public void executeFeedingRoutine() {
		callAnimal();
		prepareFood();
		feedAnimal();
		observeHealthCondition();
		cleanEnclosure();
	}
	
	public abstract void prepareFood();
	public abstract void feedAnimal();
	
	public void callAnimal() {
		System.out.println("Calling animal...");
	}
	
	public void observeHealthCondition() {
		System.out.println("Observing health condition...");
	}
	
	public void cleanEnclosure() {
		System.out.println("Cleaning enclosure...");
	}

}
