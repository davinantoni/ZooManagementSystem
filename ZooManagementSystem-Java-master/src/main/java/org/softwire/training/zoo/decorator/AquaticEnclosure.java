package org.softwire.training.zoo.decorator;

public class AquaticEnclosure extends EnclosureDecorator{

	public AquaticEnclosure(Enclosure wrappedEnclosure) {
		super(wrappedEnclosure);
	}

	@Override
	public void specification() {
		super.specification();
		System.out.println("This enclosure has water filtration system");
	}


}
