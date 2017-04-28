package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValuableComparator;

public class GreedyWithdraw implements WithdrawStrategy {

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
