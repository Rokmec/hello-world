//********************************************************************* 
//*                                                                   * 
//*   CIS611             Spring 2018 Luis Castro and  Rocco Meconi    * 
//*                                                                   * 
//*                      Program Assignment PP02                      * 
//*                                                                   * 
//*                      Class Description                            * 
//*                      Used to Create Credit Card objects           *
//*                      Date Created    02/24/18                     * 
//*                                                                   * 
//*                      Saved in: CreditCard.java                    * 
//*                                                                   * 
//*********************************************************************
package PP2;

import javax.swing.JOptionPane;

public class CreditCard {
	
	private long number;
	private String expDate;
	
	public CreditCard(long number, String expDate){
		this.number = number;
		this.expDate = expDate;
		toString();
	}
	
	
	
	@Override
	public String toString() {
		String message = "CreditCard : "  + "\n" + "Number = " + number + "\n" + "ExpDate = " + expDate;
		JOptionPane.showMessageDialog(null, message);
		return message;
	}



	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

}
