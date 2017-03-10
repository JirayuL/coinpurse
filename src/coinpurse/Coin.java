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

}