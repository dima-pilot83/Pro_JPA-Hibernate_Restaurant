package ru.mail.dimapilot;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class Action {

	static EntityManagerFactory emf;
	static EntityManager em;

	protected static void addDish() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter dish name: ");
		String dishname = sc.nextLine();

		System.out.print("Enter dish price: ");
		String price1 = sc.nextLine();
		double price = Double.parseDouble(price1);

		System.out.print("Enter dish weight: ");
		String weight1 = sc.nextLine();
		double weight = Double.parseDouble(weight1);

		System.out.print("Enter dish discount: yes/no");
		String discount = sc.nextLine();

		try {
			// create connection
			emf = Persistence.createEntityManagerFactory("JPARestaurant");
			em = emf.createEntityManager();

			em.getTransaction().begin();
			try {
				Menu m = new Menu(dishname, price, weight, discount);
				em.persist(m);
				em.getTransaction().commit();
			}

			finally {
				sc.close();
				em.close();
				emf.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected static void selectByPrice(String min, String max) {

		try {
			// create connection
			emf = Persistence.createEntityManagerFactory("JPARestaurant");
			em = emf.createEntityManager();

			em.getTransaction().begin();
			try {

				Query q = em.createQuery(
						"SELECT m FROM Menu m WHERE m.dish_price>" + min + "AND m.dish_price<" + max + "", Menu.class);

				List<Menu> dishlist = q.getResultList();

				for (Menu menu : dishlist) {

					System.out.println(menu.toString());
				}
			}

			finally {

				em.close();
				emf.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected static void selectByDiscount(String discount) {

		try {
			// create connection
			emf = Persistence.createEntityManagerFactory("JPARestaurant");
			em = emf.createEntityManager();

			em.getTransaction().begin();
			try {

				Query q = em.createQuery("SELECT m FROM Menu m WHERE m.dish_discount=:dis", Menu.class);
				q.setParameter("dis", discount);
				List<Menu> dishlist = q.getResultList();

				for (Menu menu : dishlist) {

					System.out.println(menu.toString());
				}
			}

			finally {

				em.close();
				emf.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected static void selectByWeight(int weight) {

		try {
			// create connection
			emf = Persistence.createEntityManagerFactory("JPARestaurant");
			em = emf.createEntityManager();

			em.getTransaction().begin();
			try {

				Query q = em.createQuery("SELECT m FROM Menu m", Menu.class);
				List<Menu> dishlist = q.getResultList();

				double count = 0;
				for (Menu menu : dishlist) {

					count = count + menu.getDish_weight();

					if (count <= weight) {
						System.out.println(menu.toString());
					} else
						break;
				}
			}

			finally {

				em.close();
				emf.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
