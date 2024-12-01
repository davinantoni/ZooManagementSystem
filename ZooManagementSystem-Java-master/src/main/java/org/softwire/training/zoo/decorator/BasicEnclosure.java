package org.softwire.training.zoo.decorator;

import java.util.ArrayList;
import org.softwire.training.zoo.models.AbstractAnimal;

public class BasicEnclosure implements Enclosure{
	
	private String name;
//	private ArrayList<AbstractAnimal> animals;

	public BasicEnclosure(String name) {
		this.name = name;
//		this.animals = new ArrayList<AbstractAnimal>();
	}
	
//	public void addAnimal(AbstractAnimal animal) {
//		animals.add(animal);
//	}

	@Override
	public void specification() {
		System.out.println("Enclosure Name: " + name);
//		if(animals.size() == 0) System.out.println("There is no animals in this enclosure!");
//		else {
//			System.out.println("Animals in this enclosure: ");
//			int i = 0;
//			for(AbstractAnimal animal:animals) {
//				System.out.print(++i + ". ");
//				System.out.println(animal.getName());
//			}
//		}
		System.out.println("This enclosure provides safety both for the animals and visitors");
		System.out.println("Strong and durable barriers and adequate space for movements");
	}

}
