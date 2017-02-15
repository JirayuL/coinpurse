package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Jirayu Laungwilawan
 * @version 10.2.17
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Coin> money = new ArrayList<Coin>();

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
		for (Coin x : money)
			balance += x.getValue();
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	// TODO write accessor method for capacity. Use Java naming convention.
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
	public boolean insert(Coin coin) {
		if (isFull() || coin.getValue() <= 0)
			return false;
		money.add(coin);
		return true;
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
	public Coin[] withdraw(double amount) {
		if (amount <= 0 || amount > getBalance())
			return null;
		List<Coin> remove = new ArrayList<Coin>();
		Collections.sort(money);
		Collections.reverse(money);
		for (Coin coin : money) {
			if (amount >= coin.getValue()) {
				amount -= coin.getValue();
				remove.add(coin);
			}
			if (amount == 0) {
				for (Coin removeCoin : remove)
					money.remove(removeCoin);
				return remove.toArray(new Coin[0]);
			}
		}
		return null;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 * @return a String description of the purse contents.
	 */
	public String toString() {
		// TODO complete this
		return count() + " coins with value " + getBalance();
	}

}