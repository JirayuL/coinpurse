package coinpurse;

import java.util.ResourceBundle;

/**
 * Class for create valuable using purse.properties to determined which currency
 * we will use.
 * 
 * @author Jirayu Laungwilawan
 * @version 25.2.17
 */
public abstract class MoneyFactory {
	private static MoneyFactory moneyFactory = null;

	protected MoneyFactory() {

	}

	static MoneyFactory getInstance() {
		if (moneyFactory == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("purse");
			String className = bundle.getString("moneyfactory");
			try {
				moneyFactory = (MoneyFactory) Class.forName(className).newInstance();

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				System.out.println(className + "is not type MoneyFactory");
			}
		}
		if (moneyFactory == null)
			System.exit(1);
		return moneyFactory;
	}

	abstract Valuable createMoney(double value);

	Valuable createMoney(String value) {
		return this.createMoney(Double.parseDouble(value));
	}

	static void setMoneyFactory(MoneyFactory factory) {
		moneyFactory = factory;
	}
}
