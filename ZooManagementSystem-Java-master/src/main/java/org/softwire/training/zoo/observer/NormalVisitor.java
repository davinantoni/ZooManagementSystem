package org.softwire.training.zoo.observer;

import org.softwire.training.zoo.models.Promo;
import org.softwire.training.zoo.models.Visitor;


public class NormalVisitor extends Visitor implements PromoObserver{

	public NormalVisitor(String visitorName) {
		super(visitorName);
		// TODO Auto-generated constructor stub
		this.visitorType = "Normal Visitor";
	}

	@Override
	public void update(Promo promo, int type) {
		// TODO Auto-generated method stub
		if (type==0 || type==1) {
			this.zooPromo = promo;
		}
	}

}
