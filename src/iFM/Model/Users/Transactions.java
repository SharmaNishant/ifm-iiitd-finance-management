/**
 * 
 */
package iFM.Model.Users;

import java.util.ArrayList;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;

/**
 * @author Rishav
 *
 */
public class Transactions {
	public static String transactionDetailsKind = "Transaction_Details";
	private static int TXN_ID = 1;
	
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
		
		TXN_ID++;
	}
	
	/**
	 * Returns arraylist of strings containing info about the recent transactions of a particular user
	 * (For the Notifications Component)
	 * 
	 * @param email
	 * @return null, if no transactions
	 */
	public static ArrayList<String> getLatest5Transactions(String email) {
		
		String toSearch = Users.getToken(email);
		
		System.out.println("Searching for Transactions related to : " + toSearch);
				
		Query q = new Query(transactionDetailsKind);
		
		Filter paidByFilter = new FilterPredicate("Paid_By", Query.FilterOperator.EQUAL, toSearch);
		Filter recievedByFilter = new FilterPredicate("Received_By", Query.FilterOperator.EQUAL, toSearch);
		
		Filter filter = CompositeFilterOperator.or(paidByFilter, recievedByFilter);
		
		//q.setFilter(recievedByFilter);
		q.setFilter(filter);
		q.addSort("Date", Query.SortDirection.DESCENDING);
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();			
		PreparedQuery pq = ds.prepare(q);
		
		ArrayList<String> ret = new ArrayList<>();
		
		int i=0;
		for( Entity result : pq.asIterable() ) {
//			System.out.println("Description " + i + " : " + result.getProperty("Description"));
//			System.out.println("Paid By " + i + " : " + result.getProperty("Paid_By"));
//			System.out.println("Received By " + i + " : " + result.getProperty("Received_By"));
//			System.out.println("Date " + i + " : " + result.getProperty("Date"));

			if( i==5 )
				break;
			
			if( result.getProperty("Paid_By").toString().contains(toSearch) ) {
				ret.add(result.getProperty("Date") + " - PAID - " + result.getProperty("Description"));
			}
			else {
				ret.add(result.getProperty("Date") + " - RCV - " + result.getProperty("Description"));
			}
			i++;
		}
		
		
//		System.out.println(ret);
		
		if( ret.size()>0 )
			return ret;
		else
			return null;
	}

	/**
	 * Returns arraylist of entity containing info about the transactions of a particular user
	 * @param email
	 * @return null, if no transactions
	 */
	public static ArrayList<Entity> getAllTransactions(String email) {
		
		String toSearch = Users.getToken(email);
		
		System.out.println("Searching for Transactions related to : " + toSearch);
				
		Query q = new Query(transactionDetailsKind);
		
		Filter paidByFilter = new FilterPredicate("Paid_By", Query.FilterOperator.EQUAL, toSearch);
		Filter recievedByFilter = new FilterPredicate("Received_By", Query.FilterOperator.EQUAL, toSearch);
		
		Filter filter = CompositeFilterOperator.or(paidByFilter, recievedByFilter);
		
		//q.setFilter(recievedByFilter);
		q.setFilter(filter);
		q.addSort("Date", Query.SortDirection.DESCENDING);
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();			
		PreparedQuery pq = ds.prepare(q);
		
		ArrayList<Entity> ret = new ArrayList<>();
		
		for( Entity result : pq.asIterable() ) {
			String tmp = Users.getNameByToken((String) result.getProperty("Paid_By"));
			result.setProperty("Paid_By", tmp);
			
			tmp = Users.getNameByToken((String) result.getProperty("Received_By"));
			result.setProperty("Received_By", tmp);
			
			ret.add(result);
		}
				
		if( ret.size()>0 )
			return ret;
		else
			return null;
	}
}
