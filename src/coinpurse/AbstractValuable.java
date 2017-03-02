package coinpurse;

public class AbstractValuable implements Valuable {

//	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	protected final double value;
	/** The currency, of course. */
	protected final String currency;

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * @see coinpurse.Valuable#getValue()
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 *@see coinpurse.Valuable#getCurrency()
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Method for check whether it is alike.
	 * 
	 * @see java.util.Comparator#equals(Object)
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Valuable other = (Valuable) obj;
		if (other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency()))
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
	public int compareTo(Valuable v) {
		if (v == null)
			return -1;
		return (int) Math.signum(this.value - v.getValue());
	}

}