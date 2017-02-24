package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 *  
 * @author Jirayu Laungwiawan
 * @version 20.1.17
 */
/** Implement Comparable to able to make a comparison. */
public class Coin extends AbstractValuable {
	/**
	 * Receive value from user and set currency to default.
	 * 
	 * @param value
	 *            of coin
	 */
	public Coin(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            of coin from user.
	 * @param currency
	 *            of coin from user.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Return information of the coin.
	 * 
	 * @return information of the coin.
	 */
	public String toString() {
		return String.format("%.2f-%s coin", this.value, this.currency);
	}

	public static void main(String[] args) {
		Coin one = new Coin(1);
		Coin five = new Coin(5);
		Coin maly = new Coin(0.5, "Ringgit");
		System.out.println(one.toString());
		System.out.println(one.compareTo(five));
		System.out.println(five.compareTo(one));
		System.out.println(one.equals(five));
	}

}