package ru.mail.dimapilot;


public class Main {


	public static void main(String[] args) {

		Action.addDish();
		Action.selectByPrice("25", "100");
		Action.selectByDiscount("yes");
		Action.selectByWeight(1000);
	}

}
