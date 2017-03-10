package coinpurse;

import java.util.Comparator;

/**
 * Class for compare in a reverse way for withdraw method in Purse class.
 * 
 * @author Jirayu Laungwilawan
 * @version 10.3.17
 */
public class ValuableComparator implements Comparator<Valuable> {

	@Override
	public int compare(Valuable o1, Valuable o2) {
		return (int) Math.signum(o2.getValue() - o1.getValue());
	}

}
