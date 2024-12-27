package org.softwire.training.zoo.observer;

import org.softwire.training.zoo.models.Promo;
import org.softwire.training.zoo.models.Visitor;

public class VIPVisitor extends Visitor implements PromoObserver{
	public VIPVisitor(String visitorName) {
		super(visitorName);
		this.visitorType = "VIP Visitor";
	}

	@Override
	public void update(Promo promo, int type) {
		if (type==0 || type==2) {
			this.zooPromo = promo;
		}
	}
}
