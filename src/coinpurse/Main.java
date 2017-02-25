package coinpurse;
 
/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Jirayu Laungwilawan
 * @version 14.2.17
 */
public class Main {
	

    private static final MoneyFactory factory = null;
    
    
	/**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
//TODO follow the steps in the sequence diagram
//        // 1. create a Purse
//    	Purse purse = new Purse(10);
//        // 2. create a ConsoleDialog with a reference to the Purse object
//    	ConsoleDialog console = new ConsoleDialog(purse);
//        // 3. run the ConsoleDialog
//    	console.run();
    	
    	BankNote c = new BankNote(20, "Baht");
    	System.out.println(c.toString());

    }
}
