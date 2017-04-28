package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

	/**
	 * @see WithdrawStrategy#withdraw(double, List)
	 */
	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		if (amount == 0)
			return new ArrayList<>();

		if ((money.isEmpty() && amount != 0) || amount < 0)
			return null;

		List<Valuable> sol1 = withdraw(amount - money.get(0).getValue(), money.subList(1, money.size()));
		List<Valuable> sol2 = withdraw(amount, money.subList(1, money.size()));

		if (sol1 != null) {
			sol1.add(money.get(0));
			return sol1;
		}

		if (sol2 != null)
			return sol2;

		return null;
	}

}
