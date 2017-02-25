package coinpurse;

import java.util.ResourceBundle;

public abstract class MoneyFactory {
	private static MoneyFactory moneyFactory = null;
	private static String currency;
	protected MoneyFactory() {

	}

	static MoneyFactory getInstance() {
		if (moneyFactory == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("purse");
			String className = bundle.getString("moneyfactory");
			if(className.equals("coinpurse.MalayMoneyFactory"))
				currency = "Ringgit";
			if(className.equals("coinpurse.ThaiMoneyFactory"))
				currency = "Baht";
			try {
				moneyFactory = (MoneyFactory) Class.forName(className).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				System.out.println(className + "is not type MoneyFactory");
			}
		}
		if (moneyFactory == null) System.exit(1);
		return moneyFactory;
	}

	abstract Valuable createMoney(double value);

	Valuable createMoney(String value) {
		return this.createMoney(Double.parseDouble(value));
	}

	static void setMoneyFactory(MoneyFactory factory) {
		moneyFactory = factory;
	}
	public String getCurrency() {
		return currency;
	}

}
