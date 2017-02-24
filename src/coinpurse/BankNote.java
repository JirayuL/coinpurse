package coinpurse;

/**
 * BankNote represents money with a fixed value and currency.
 * 
 * @author Jirayu Laungwilawan
 * @version 17.2.17
 */
public class BankNote implements Comparable<BankNote>, Valuable {
	/**
	 * I make it static because every time i call this object the serial number
	 * change too.
	 */
	private static long nextSerialNumber = 1000000;
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;
	/** Set default of currency. */
	public static final String DEFAULT_CURRENCY = "Baht";
	/** The serial number of bank note. */
	private long serialNumber;

	/**
	 * Receive value from user and set currency to default.
	 * 
	 * @param value
	 *            of bank note.
	 */
	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
	}

	/**
	 * Recieve value and currency from user.
	 * 
	 * @param Recieve
	 *            value of bank note.
	 * @param Recieve
	 *            currency of bank note.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
	}

	/**
	 * Return serial number of the bank note.
	 * 
	 * @return Return serial number of the bank note.
	 */
	private long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Return value of bank note.
	 * 
	 * @return Return value of bank note.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Return currency of bank note.
	 * 
	 * @return Return currency of bank note.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compare two coin using value to compare.
	 * 
	 * @param BankNote
	 *            b from user to compare.
	 * @return Return result of comparison.
	 */
	@Override
	public int compareTo(BankNote b) {
		if (b == null)
			return -1;
		return (int) Math.signum(this.value - b.getValue());
	}

	/**
	 * Method for check whether it is alike.
	 * 
	 * @param Object
	 *            obj to check whether it is alike.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if (other.getValue() == this.getValue() && other.getCurrency().equals(this.getCurrency()))
			return true;
		return false;
	}

	/**
	 * Return information of the bank note.
	 * 
	 * @return Return information of the bank note.
	 */
	@Override
	public String toString() {
		return String.format("%f-&s note <%l>", this.value, this.currency, this.serialNumber);
	}

}
