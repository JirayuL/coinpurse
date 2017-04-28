package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import coinpurse.Purse;

public class PurseProgressBar extends JFrame implements Observer {
	Purse purse;
	int SIZE = 20;
	JProgressBar processBar;
	JLabel processStatus;

	public PurseProgressBar(Purse purse) {
		this.purse = purse;
		initComponents();
		run();
	}

	public void run() {
		this.setVisible(true);
	}

	private void initComponents() {
		processStatus = new JLabel();
		processStatus.setFont(new Font(Font.DIALOG, Font.BOLD, SIZE));
		processStatus.setText(purse.getCapacity() + " left");

		processBar = new JProgressBar();
		processBar.setMaximum(purse.getCapacity());
		processBar.setValue(purse.count());

		this.add(processStatus, BorderLayout.NORTH);
		this.add(processBar, BorderLayout.SOUTH);

		this.pack();
	}

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
