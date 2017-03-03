package coinpurse;

import java.util.stream.DoubleStream;

public class MalayMoneyFactory extends MoneyFactory {
	public static final String DEFAULT_CURRENCY = "Ringgit";
	private final double[] coinValue = new double[] { 0.05, 0.10, 0.20, 0.50 };
	private final double[] bankNoteValue = new double[] { 1, 2, 5, 10, 20, 50, 100 };
	/**
	 * I make it static because every time i call this object the serial number
	 * change too.
	 */
	private static long nextSerialNumber = 1000000;

	public MalayMoneyFactory() {

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
		throw new IllegalArgumentException("In Malaysia, we don't have that money.");
	}

}
