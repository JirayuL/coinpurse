package coinpurse;

/**
 * BankNote represents money with a fixed value and currency.
 * 
 * @author Jirayu Laungwilawan
 * @version 17.2.17
 */
public class BankNote extends AbstractValuable {
	private long serialNumber;

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
		this.serialNumber = 0;
	}

	/**
	 * Receive value and currency from user.
	 * 
	 * @param Recieve
	 *            value of bank note.
	 */
	public BankNote(double value) {
		this(value, "Baht");
	}

	/**
	 * Receive value and currency from user.
	 * 
	 * @param Recieve
	 *            value of bank note.
	 * @param Recieve
	 *            currency of bank note.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Return serial number of the bank note.
	 * 
	 * @return Return serial number of the bank note.
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Return information of the bank note.
	 * 
	 * @return Return information of the bank note.
	 */
	@Override
	public String toString() {
		return String.format(value + "-%s note [%d]", currency, serialNumber);
		// return String.format("%f-&s note %d", this.value, this.currency,
		// this.serialNumber);
	}

}
