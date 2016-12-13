package ru.mail.dimapilot;

import javax.persistence.*;

public class Main {

	static EntityManagerFactory emf;
	static EntityManager em;

	public static void main(String[] args) {

		Action.addDish();
		Action.selectByPrice("25", "100");
		Action.selectByDiscount("yes");
		Action.selectByWeight(1000);
	}

}
