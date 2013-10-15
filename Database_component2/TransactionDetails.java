/**
 * 
 */
package iFM.Model;

import com.google.appengine.api.datastore.Entity;

/**
 * @author Priyam
 *
 */
public class TransactionDetails {
	
	private Entity Transaction;
    
    public TransactionDetails(int sNo, String paidBy, String receivedBy, String amount, String date, String description) {            
    	this.Transaction = new Entity("Transaction Details", sNo);
    	
        this.Transaction.setProperty("Paid By", paidBy);
        this.Transaction.setProperty("Received By",receivedBy);
        this.Transaction.setProperty("Amount", amount);
        this.Transaction.setProperty("Date", date);
        this.Transaction.setProperty("Description", description);
    }

    public Entity getEntity() {
            return this.Transaction;
    }
    
}
