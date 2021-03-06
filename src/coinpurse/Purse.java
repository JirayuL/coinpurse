package coinpurse;

import java.util.List;
import java.util.Observable;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.WithdrawStrategy;

import java.util.ArrayList;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Jirayu Laungwilawan
 * @version 10.2.17
 */
public class Purse extends Observable {
	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<>();
	private WithdrawStrategy strategy;

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		// TODO initialize the attributes of purse
		this.capacity = capacity;
		this.strategy = new GreedyWithdraw();
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable x : money)
			balance += x.getValue();
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	// TODO write accessory method for capacity. Use Java naming convention.
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (money.size() >= this.capacity)
			return true;
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (isFull() || valuable.getValue() <= 0)
			return false;
		money.add(valuable);
		setChanged();
		notifyObservers();
		return true;
	}

	/**
	 * Get the strategy for withdraw from purse.
	 * 
	 * @return the strategy of withdraw process.
	 */
	public WithdrawStrategy getStrategy() {
		return strategy;
	}

	/**
	 * Set the strategy of the withdraw process.
	 * 
	 * @param strategy
	 *            that want to change to.
	 */
	public void setStrategy(WithdrawStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount <= 0 || amount > getBalance())
			return null;
		List<Valuable> remove = strategy.withdraw(amount, money);
		for (Valuable removeValuable : remove)
			money.remove(removeValuable);
		setChanged();
		notifyObservers();
		return remove.toArray(new Valuable[0]);
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 * 
	 * @return a String description of the purse contents.
	 */
	public String toString() {
		// TODO complete this
		return count() + " with value " + getBalance();
	}

}