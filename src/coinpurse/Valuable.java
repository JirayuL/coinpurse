package coinpurse;

/**
 * A specification needs documentation so that others can use it.
 * 
 * @author Jirayu Laungwilawan
 * @version 17.2.17
 */
public interface Valuable {
	/**
	 * Get the monetary value of this object, in its own value.
	 * 
	 * @return the value of this object
	 */
	public double getValue();

	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the currency of this object
	 */
	public String getCurrency();
}
