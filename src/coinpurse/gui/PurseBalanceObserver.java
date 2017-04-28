package coinpurse.gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import coinpurse.Purse;

/**
 * Balance window for checking the balance inpurse.
 * 
 * @author Jirayu Laungwilawan
 * @version 21.4.17
 */
public class PurseBalanceObserver extends JFrame implements Observer {
	/**
	 * First version.
	 */
	private static final long serialVersionUID = 1L;

	Purse purse;
	/** JLabel for representing the balance in the purse. */
	JLabel balanceStatus;
	/** Constant for font size. */
	private final int FONT_SIZE = 24;

	/**
	 * Initialize constructor for balance GUI.
	 * 
	 * @param purse
	 *            for information in the purse.
	 */
	public PurseBalanceObserver(Purse purse) {
		this.purse = purse;
		initComponents();
		run();
	}

	/**
	 * Start the GUI for balance.
	 */
	public void run() {
		this.setVisible(true);
	}

	/**
	 * Initialize components for balance GUI.
	 */
	private void initComponents() {
		balanceStatus = new JLabel();
		balanceStatus.setText(String.valueOf(purse.getBalance()) + " Baht");
		balanceStatus.setFont(new Font(Font.DIALOG, Font.BOLD, FONT_SIZE));

		this.add(balanceStatus);

		this.pack();
	}

	/**
	 * Update method for Observer pattern for update the information in the
	 * balance GUI.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Purse)
			purse = (Purse) o;
		balanceStatus.setText(String.valueOf(purse.getBalance()) + " Baht");
	}

}
