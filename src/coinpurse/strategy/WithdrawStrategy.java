package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * Interface for using strategy pattern.
 * 
 * @author Jirayu Laungwilawan
 * @version 28.4.17
 */
public interface WithdrawStrategy {
	/**
	 * Withdraw the money form the purse using the strategy to withdraw.
	 * 
	 * @param amount
	 *            that want to withdraw.
	 * @param money
	 *            that contains in the purse.
	 * @return the list of Valuable that want to withdraw.
	 */
	public List<Valuable> withdraw(double amount, List<Valuable> money);
}
