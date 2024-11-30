package org.softwire.training.zoo.observer;

import org.softwire.training.zoo.models.Promo;

public interface PromoObserver {
	//All Visitor, type =0;
	//Normal Visitor, type = 1;
	//VIP Visitor, type = 2;
	public void update(Promo promo, int type);
}
