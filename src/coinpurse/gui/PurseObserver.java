package coinpurse.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import coinpurse.Purse;

/**
 * Observer class.
 * 
 * @author Jirayu Laungwilawan
 * @version 21.4.17
 */
public class PurseObserver extends JFrame implements Observer {
	/**
	 * First version
	 */
	private static final long serialVersionUID = 1L;
	Purse purse;

	/**
	 * 
	 * @param purse
	 */
	public PurseObserver(Purse purse) {
		this.purse = purse;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Purse)
			purse = (Purse) o;

	}

}
