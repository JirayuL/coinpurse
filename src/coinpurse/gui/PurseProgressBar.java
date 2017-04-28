package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import coinpurse.Purse;

/**
 * Process bar window for representing the process of purse capacity.
 * 
 * @author Jirayu Laungwilawan
 * @version 21.4.17
 */
public class PurseProgressBar extends JFrame implements Observer {
	/**
	 * First version.
	 */
	private static final long serialVersionUID = 1L;

	Purse purse;
	/** Process bar for represent the space in the purse. */
	JProgressBar processBar;
	/** Represent the space in the purse in text. */
	JLabel processStatus;
	/** Constant for font size. */
	private final int FONT_SIZE = 20;

	/**
	 * Initialize the constructor for PurseProgreesBar.
	 * 
	 * @param purse
	 */
	public PurseProgressBar(Purse purse) {
		this.purse = purse;
		initComponents();
		run();
	}

	/**
	 * Start the GUI for ProgressBar GUI.
	 */
	public void run() {
		this.setVisible(true);
	}

	/**
	 * Initialize the components for PurseProgressBar GUI.
	 */
	private void initComponents() {
		processStatus = new JLabel();
		processStatus.setFont(new Font(Font.DIALOG, Font.BOLD, FONT_SIZE));
		processStatus.setText(purse.getCapacity() + " left");

		processBar = new JProgressBar();
		processBar.setMaximum(purse.getCapacity());
		processBar.setValue(purse.count());

		this.add(processStatus, BorderLayout.NORTH);
		this.add(processBar, BorderLayout.SOUTH);

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
		if ((purse.getCapacity() - purse.count()) == 0) {
			processStatus.setText("Your purse is full.");
		} else
			processStatus.setText(purse.getCapacity() - purse.count() + " left");
		processBar.setValue(purse.count());
	}
}
