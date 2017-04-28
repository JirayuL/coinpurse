package coinpurse.strategy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Purse;
import coinpurse.Valuable;

public class WithdrawStrategyTest {
	Purse purse;

	String currency = "Baht";

	Coin ONE_COIN = new Coin(1, currency);
	Coin TWO_COIN = new Coin(2, currency);
	Coin FIVE_COIN = new Coin(5, currency);
	Coin TEN_COIN = new Coin(10, currency);

	BankNote TWENTY_BANK = new BankNote(20, currency);
	BankNote FIFTY_BANK = new BankNote(50, currency);
	BankNote ONE_HUNDRED_BANK = new BankNote(100, currency);
	BankNote FIVE_HUNDRED_BANK = new BankNote(500, currency);
	BankNote ONE_THOUSAND_BANK = new BankNote(1000, currency);

	@Before
	public void setUp() throws Exception {
		int capacity = 5;
		purse = new Purse(capacity);
	}

	@After
	public void tearDown() throws Exception {
		purse = null;
	}

	@Test
	public void testWithdrawPurse() {
		assertNull(purse.withdraw(100.00));

		purse.insert(ONE_COIN);
		Valuable[] amount1 = {ONE_COIN};
		assertArrayEquals(amount1, purse.withdraw(1.0));

		purse.setStrategy(new RecursiveWithdraw());
		purse.insert(FIVE_COIN);
		purse.insert(TWO_COIN);
		purse.insert(TWO_COIN);
		purse.insert(TWO_COIN);
		purse.insert(TEN_COIN);
		Valuable[] amount2 = { FIVE_COIN, TWO_COIN, TWO_COIN, TWO_COIN, TEN_COIN };
		assertSame(amount2, purse.withdraw(11.0));
	}

}
