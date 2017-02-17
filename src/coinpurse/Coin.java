package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 *  
 * @author Jirayu Laungwiawan
 * @version 20.1.17
 */
/** Implement Comparable to able to make a comparison. */
public class Coin implements Comparable<Coin> , Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * Receive value from user and set currency to default.
	 * 
	 * @param value
	 *            of coin
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
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
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Return value of this.value.
	 * 
	 * @return value of this.value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return this.currency of the coin.
	 * 
	 * @return this.currency of the coin.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Method for check whether it is alike.
	 * 
	 * @param Object
	 *            obj to check whether it is alike.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin other = (Coin) obj;
		if (other.getValue() == this.getValue() && other.getCurrency() == this.getCurrency())
			return true;
		return false;
	}

	/**
	 * Compare two coin using value to compare.
	 * 
	 * @param Coin
	 *            c from user to compare.
	 * @return Return result of comparison.
	 */
	public int compareTo(Coin c) {
		if (c == null)
			return -1;
		return (int) Math.signum(this.value - c.getValue());
	}

	/**
	 * Return this.value and this.currency of the coin.
	 * 
	 * @return this.value and this.currency of the coin.
	 */
	public String toString() {
		return String.format("%.2f-Coin %s", this.value, this.currency);
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