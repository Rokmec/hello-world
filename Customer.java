//********************************************************************* 
//*                                                                   * 
//*   CIS611             Spring 2018 Luis Castro and  Rocco Meconi    * 
//*                                                                   * 
//*                      Program Assignment PP02                      * 
//*                                                                   * 
//*                      Class Description                            * 
//*                      Used to create Customer Objects              *
//*                      Date Created    02/24/18                     * 
//*                                                                   * 
//*                      Saved in: Customer.java                      * 
//*                                                                   * 
//*********************************************************************

package PP2;

import javax.swing.JOptionPane;

public class Customer {
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	private static int noOfCustomers;

	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		noOfCustomers++;
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		toString();
	}

	
	
	@Override
	public String toString() {
		String message =  "Customer : " + "\n" + "Id = " + id  + "\n" +  "First Name = " + fName + "\n" +  "Last Name = " + lName + "\n" +  "Amount = " + amount;
		JOptionPane.showMessageDialog(null, message);
		return message;
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}
	
	public static int getNoOfCustomers() {
		return noOfCustomers;
	}

	public static void setNoOfStudents(int noOfCustomers) {
		Customer.noOfCustomers = noOfCustomers;
	}
	
}
