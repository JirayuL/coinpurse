package coinpurse;

import java.util.stream.DoubleStream;

/**
 * Class for creating Thai money currency Baht and Satung.
 * 
 * @author Jirayu Laungwilawan
 * @version 25.2.17
 */
public class ThaiMoneyFactory extends MoneyFactory {
	public static final String DEFAULT_CURRENCY = "Baht";
	private final double[] coinValue = { 0.25, 0.50, 1, 2, 5, 10 };
	private final double[] bankNoteValue = { 20, 50, 100, 500, 1000 };
	/**
	 * I make it static because every time i call this object the serial number
	 * change too.
	 */
	private static long nextSerialNumber = 1000000;

	public ThaiMoneyFactory() {

	}

	@Override
	Valuable createMoney(double value) {
		// String[] s = new String[] { "A", "B", "C" };
		// List<String> d = Arrays.asList(s);
		/*
		 * Equivalent to:
		 * 
		 * boolean test(double v) { return v == value; }
		 */
		if (DoubleStream.of(coinValue).anyMatch(v -> v == value)) {
			Coin coin = new Coin(value, DEFAULT_CURRENCY);
			return coin;
		}
		if (DoubleStream.of(bankNoteValue).anyMatch(v -> v == value)) {
			BankNote banknote = new BankNote(value, DEFAULT_CURRENCY, nextSerialNumber);
			nextSerialNumber++;
			return banknote;
		}
		throw new IllegalArgumentException("In Thailand, we don't have that money.");
	}

}
