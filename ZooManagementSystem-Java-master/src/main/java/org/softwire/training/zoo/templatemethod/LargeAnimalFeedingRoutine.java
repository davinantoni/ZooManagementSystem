package org.softwire.training.zoo.templatemethod;

public class LargeAnimalFeedingRoutine extends FeedingRoutine {

	public LargeAnimalFeedingRoutine() {

	}

	@Override
	public void prepareFood() {
		System.out.println("Preparing grass, hay, meats...");
		
	}

	@Override
	public void feedAnimal() {
		System.out.println("Hanging or feeding through tongs...");
	}

}
