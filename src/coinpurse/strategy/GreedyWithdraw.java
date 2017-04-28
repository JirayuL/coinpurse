package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValuableComparator;

/**
 * GreedyWithdraw is the process of with draw the money by sort the money from
 * large to small and take the big one first.
 * 
 * @author Jirayu laungwilawan
 * @version 28.4.17
 */
public class GreedyWithdraw implements WithdrawStrategy {

	/**
	 * @see WithdrawStrategy#withdraw(double, List);
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> remove = new ArrayList<Valuable>();
		Collections.sort(money, new ValuableComparator());
		for (Valuable valuable : money) {
			if (amount >= valuable.getValue()) {
				amount -= valuable.getValue();
				remove.add(valuable);
			}
			if (amount == 0) {
				for (Valuable removeValuable : remove)
					money.remove(removeValuable);
				return remove;
			}
		}
		return null;
	}

}
