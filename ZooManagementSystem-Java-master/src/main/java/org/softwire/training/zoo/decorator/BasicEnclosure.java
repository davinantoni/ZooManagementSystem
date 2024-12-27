package org.softwire.training.zoo.decorator;

import java.util.ArrayList;
import org.softwire.training.zoo.models.AbstractAnimal;

public class BasicEnclosure implements Enclosure{
	
	private String name;

	public BasicEnclosure(String name) {
		this.name = name;
	}
	

	@Override
	public void specification() {
		System.out.println("Enclosure Name: " + name);
		System.out.println("This enclosure provides safety both for the animals and visitors");
		System.out.println("Strong and durable barriers and adequate space for movements");
	}

}
