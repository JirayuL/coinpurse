package coinpurse.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import coinpurse.Purse;

public class PurseObserver extends JFrame implements Observer {
	Purse purse;
	
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
