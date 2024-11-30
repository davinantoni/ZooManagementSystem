package org.softwire.training.zoo.observerable;

import java.util.ArrayList;

import org.softwire.training.zoo.models.Promo;
import org.softwire.training.zoo.observer.PromoObserver;


public class Zoo {
	private ArrayList<PromoObserver> visitors;
	
	public Zoo() {
		visitors = new ArrayList<>();
	}
	
	//3 method utama -> add observer, remove observer, notify observer
	
	public void addObserver(PromoObserver visitor) {
		visitors.add(visitor);
	}
	
	public void removeObserver(PromoObserver visitor) {
		visitors.remove(visitor);
	}
	
	public void notifyObserver(Promo promo, int type) {
		for (PromoObserver visitor : visitors) {
			visitor.update(promo, type);
		}
	}
	
	public void viewObserver() {
		if(visitors.isEmpty()	) {
			System.out.println("Visitor list is empty");
			return;
		}
		else {
			for (PromoObserver visitor: visitors) {
				System.out.println(visitor);
			}
		}
	}
	public boolean hasVisitor() {
        return visitors.isEmpty();
    }
}
