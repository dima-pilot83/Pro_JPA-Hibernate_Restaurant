package ru.mail.dimapilot;

import javax.persistence.*;

@Entity
@Table(name = "MenuInRestaurant")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "dish_name", nullable = false)
	private String dish_name;

	@Column(name = "dish_price", nullable = false)
	private double dish_price;

	@Column(name = "dish_weight", nullable = false)
	private double dish_weight;

	@Column(name = "dish_discount")
	private String dish_discount;

	public Menu() {
		super();
	}

	public Menu(String dish_name, double dish_price, double dish_weight, String dish_discount) {
		super();
		this.dish_name = dish_name;
		this.dish_price = dish_price;
		this.dish_weight = dish_weight;
		this.dish_discount = dish_discount;
	}

	public double getDish_weight() {
		return dish_weight;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", dish_name=" + dish_name + ", dish_price=" + dish_price + ", dish_weight="
				+ dish_weight + ", dish_discount=" + dish_discount + "]";
	}

}
