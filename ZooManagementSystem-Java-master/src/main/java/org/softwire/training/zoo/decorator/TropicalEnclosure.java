package org.softwire.training.zoo.decorator;

public class TropicalEnclosure extends EnclosureDecorator{

	public TropicalEnclosure(Enclosure wrappedEnclosure) {
		super(wrappedEnclosure);
	}

	@Override
	public void specification() {
		super.specification();
		System.out.println("This enclosure has humidity and temperature control system");
	}

	

}
