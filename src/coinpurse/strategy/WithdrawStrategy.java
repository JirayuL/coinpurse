package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * Interface for using strategy pattern.
 * @author Gear
 *
 */
public interface WithdrawStrategy {
	public List<Valuable> withdraw(double amount, List<Valuable> money);
}
