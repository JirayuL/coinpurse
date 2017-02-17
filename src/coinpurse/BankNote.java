package coinpurse;

/**
 * BankNote represents money with a fixed value and currency.
 * 
 * @author Jirayu Laungwilawan
 * @version 17.2.17
 */
public class BankNote implements Comparable<BankNote>, Valuable {
	private static long nextSerialNumber = 1000000;
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;
	public static final String DEFAULT_CURRENCY = "Baht";
	private long serialNumber;

	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
	}

	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber += 1;
	}

	private long getSerial() {
		return this.serialNumber;
	}
	
	@Override
	public double getValue() {
		return this.value;
	}
	
	@Override
	public String getCurrency() {
		return this.currency;
	}

	@Override
	public int compareTo(BankNote b) {
		if (b == null)
			return -1;
		return (int) Math.signum(this.value - b.getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if (other.getValue() == this.getValue() && other.getCurrency() == this.getCurrency())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return this.value + "-" + this.currency + " note <" + this.serialNumber + ">";
	}


}
