/**
 * 
 */
package iFM.Model;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

/**
 * @author Rishav
 *
 */
public class Transactions {
	private static int TXN_ID = 0;
	
	/**
	 * Adds a new transaction to the database
	 * <br />(automatically increments the TXN ID)
	 * @param paidBy
	 * @param receivedBy
	 * @param amount
	 * @param date
	 * @param description
	 * @author Rishav
	 */
	public static void addTransaction(String paidBy, String receivedBy, String amount, String date, String description) {
		
		System.out.println("Serial No. for New Transaction : " + TXN_ID);
		
		TransactionDetails newTransaction = new TransactionDetails(TXN_ID, paidBy, receivedBy, amount, date, description);
		
		Entity transactionEntity = newTransaction.getEntity();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(transactionEntity);
		
	}
}
