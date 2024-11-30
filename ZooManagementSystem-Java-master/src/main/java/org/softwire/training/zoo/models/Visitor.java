package org.softwire.training.zoo.models;


public abstract class Visitor {
	protected String visitorName;
	protected String visitorType;
	protected Promo zooPromo;
	
	public Visitor(String visitorName) {
		// TODO Auto-generated constructor stub
		this.visitorName = visitorName;	
	}
	
	@Override
	public String toString() {
		if(zooPromo == null) {
			return String.format("No promo for %s", visitorName);
		}
		return String.format("%s (%s) %s", visitorName, visitorType, zooPromo);
	}
}
