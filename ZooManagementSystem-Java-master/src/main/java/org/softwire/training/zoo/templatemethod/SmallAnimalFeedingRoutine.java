package org.softwire.training.zoo.templatemethod;

public class SmallAnimalFeedingRoutine extends FeedingRoutine{

	public SmallAnimalFeedingRoutine() {

	}


	@Override
	public void prepareFood() {
		System.out.println("Preparing vegetables, fruits, mealworms, grains...");
		
	}

	@Override
	public void feedAnimal() {
		System.out.println("Hand-feeding the animals...");
	}


}
