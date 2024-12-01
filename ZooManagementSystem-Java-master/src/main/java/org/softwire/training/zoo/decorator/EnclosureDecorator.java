package org.softwire.training.zoo.decorator;

public class EnclosureDecorator implements Enclosure{
	protected Enclosure wrappedEnclosure;

	public EnclosureDecorator(Enclosure wrappedEnclosure) {
		this.wrappedEnclosure = wrappedEnclosure;
	}

	@Override
	public void specification() {
		wrappedEnclosure.specification();
	}

}
