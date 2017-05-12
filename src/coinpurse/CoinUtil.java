package coinpurse;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Jirayu Laungwilawan
 * @version 14.2.17
 */
public class CoinUtil {

	/**
	 * Return the larger of a and b, according to the natural ordering (defined
	 * by compareTo).
	 * 
	 * @param a
	 * @param b
	 * @return the larger of a and b.
	 */
	public static <E extends Comparable<? super E>> E max(E... a) {
		List<E> max = Arrays.asList(a);
		return max.stream().max((e1, e2) -> e1.compareTo(e2)).get();
	}

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 * @throws NullPointerException
	 *             if the currency is null.
	 */
	public static List<? extends Valuable> filterByCurrency(final List<? extends Valuable> valuablelist,
			String currency) throws NullPointerException {
		Predicate<? super Valuable> isCurrency = (v) -> (v.getCurrency().equals(currency));
		List<? extends Valuable> result = valuablelist.stream().filter(isCurrency).collect(Collectors.toList());
		return result;
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sort.
	 *
	 *            TODO: 1. Write a Comparator<Coin> (you can write the class at
	 *            the end of this file. Declare it as "class CompareByCurrency"
	 *            without the "public"). You can also write Comparator as an
	 *            anonymous class, if you know how. The compare method should
	 *            order coins by currency. 2. Create a comparator instance and
	 *            use it to sort the coins.
	 */
	public static void sortByCurrency(List<Valuable> valuable) {
		Collections.sort(valuable, (v1, v2) -> (v1.getCurrency().compareToIgnoreCase(v2.getCurrency())));
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> money) {
		Map<String, Double> map = new HashMap<>();
		for (Valuable valuable : money) {
			String currency = valuable.getCurrency();
			map.put(currency, map.getOrDefault(currency, 0.0) + valuable.getValue());
		}
		for (String currency : map.keySet())
			System.out.println(map.get(currency) + " " + currency);
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 * @throws NullPointerException
	 *             if the currency of filterByCurrency is null.
	 */
	public static void main(String[] args) throws NullPointerException {
		Valuable max = CoinUtil.max(new Coin(5), new Coin(10), new BankNote(20));
		System.out.println(max);

		// String currency = "Rupee";
		// System.out.println("Filter coins by currency of " + currency);
		// List<Valuable> coins = makeInternationalCoins();
		// int size = coins.size();
		// System.out.print(" INPUT: ");
		// printList(coins, " ");
		// List<? extends Valuable> rupees = filterByCurrency(coins, currency);
		// System.out.print("RESULT: ");
		// printList(rupees, " ");
		// if (coins.size() != size)
		// System.out.println("Error: you changed the original list.");
		//
		// System.out.println("\nSort coins by currency");
		// coins = makeInternationalCoins();
		// System.out.print(" INPUT: ");
		// printList(coins, " ");
		// sortByCurrency(coins);
		// System.out.print("RESULT: ");
		// printList(coins, " ");
		//
		// System.out.println("\nSum coins by currency");
		// coins = makeInternationalCoins();
		// System.out.print("coins= ");
		// printList(coins, " ");
		// sumByCurrency(coins);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List<? extends Valuable> rupees, String separator) {
		Iterator<? extends Valuable> iter = rupees.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}