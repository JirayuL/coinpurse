package coinpurse;

/**
 * BankNote represents money with a fixed value and currency.
 * 
 * @author Jirayu Laungwilawan
 * @version 17.2.17
 */
public class BankNote extends AbstractValuable {
	/**
	 * I make it static because every time i call this object the serial number
	 * change too.
	 */
	private static long nextSerialNumber = 1000000;
	/** The serial number of bank note. */
	private long serialNumber;

	/**
	 * Receive value from user and set currency to default.
	 * 
	 * @param value
	 *            of bank note.
	 */
	public BankNote(double value) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * Receive value and currency from user.
	 * 
	 * @param Recieve
	 *            value of bank note.
	 * @param Recieve
	 *            currency of bank note.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
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
	 * Return information of the bank note.
	 * 
	 * @return Return information of the bank note.
	 */
	@Override
	public String toString() {
		return String.format("%f-&s note <%l>", this.value, this.currency, this.serialNumber);
	}

}
