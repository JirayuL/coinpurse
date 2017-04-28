package coinpurse.gui;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

import coinpurse.Purse;

public class PurseBalanceObserver extends JFrame implements Observer {
	Purse purse;
	JLabel balanceStatus;
	int SIZE = 24;
	
	public PurseBalanceObserver(Purse purse) {
		this.purse = purse;
		initComponents();
		run();
	}
	
	public void run(){
		this.setVisible(true);
	}
	
	private void initComponents(){
		balanceStatus = new JLabel();
		balanceStatus.setText(String.valueOf(purse.getBalance()) + " Baht");
		balanceStatus.setFont(new Font(Font.DIALOG, Font.BOLD, SIZE));
		
		this.add(balanceStatus);
		
		this.pack();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Purse) 
			purse = (Purse) o;
		balanceStatus.setText(String.valueOf(purse.getBalance()) + " Baht");
	}

}
