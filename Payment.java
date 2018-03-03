//********************************************************************* 
//*                                                                   * 
//*   CIS611             Spring 2018 Luis Castro and  Rocco Meconi    * 
//*                                                                   * 
//*                      Program Assignment PP02                      * 
//*                                                                   * 
//*                      Class Description                            *
//*                      Main method containing class also used for   *
//*                      computing stats and writing to output file   *
//*                      Date Created    02/24/18                     * 
//*                                                                   * 
//*                      Saved in: Payment.java                       * 
//*                                                                   * 
//*********************************************************************
package PP2;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;

	// this will check whether a card is valid
	public static Boolean isValidCard(String number) {
		return validating.aValidNumber(number);

	}// end of the isValidCard method

	// creates a hash code for the credit card number to be stored in file
	public static String createHashCode(String number) {
		return hashing.getHashCode(number);

	}// end of the createHashCode method

	// it adds a new customer to the array of customers once the payment was
	// successful
	public static void addCustomer(Customer customer) {
		customers[Customer.getNoOfCustomers() - 1] = customer;

	} // end of the addCustomer method

	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat() {
		double averageCustomerPayment = 0.0;
		double maximumCustomerPayment = 0.0;
		double minimumCustomerPayment = 0.0;
		double totalCustomersPayments = 0.0;

		// Calculate Average
		for (int i = 0; i < customers.length; i++) {
			totalCustomersPayments = totalCustomersPayments + customers[i].getAmount();
		}
		averageCustomerPayment = (totalCustomersPayments / customers.length);

		// Obtain minimum payment
		minimumCustomerPayment = customers[0].getAmount();
		for (int j = 1; j < customers.length; j++) {
			if (minimumCustomerPayment > customers[j].getAmount()) {
				minimumCustomerPayment = customers[j].getAmount();
			}
		}

		// Obtain maximum payment
		maximumCustomerPayment = customers[0].getAmount();
		for (int j = 1; j < customers.length; j++) {
			if (maximumCustomerPayment < customers[j].getAmount()) {
				maximumCustomerPayment = customers[j].getAmount();
			}
		}
		String customersStatistics = "Avg Payment = " + averageCustomerPayment + "\n" + "Min Payment = "
				+ minimumCustomerPayment + "\n" + "Max Payment = " + maximumCustomerPayment + "\n";
		JOptionPane.showMessageDialog(null, customersStatistics);

	}// end of the displayStat method

	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
	public static void writeToFile() throws Exception {
		hashing = new HashCode();
		File file = new File("Customer.txt");
		// creates the file
		file.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file);
		// Writes the content to the file
		for (int i = 0; i < customers.length; i++) {
			writer.write(customers[i].getfName() + ", " + customers[i].getlName() + ", "
					+ createHashCode(String.valueOf(customers[i].getCard().getNumber())) + ", "
					+ customers[i].getCard().getExpDate() + ", " + customers[i].getAmount() + "\n");
		}
		writer.flush();
		writer.close();

	} // end of the writeToFile method

	// the main entry method of the program that will get data from user and
	// perform the business logic
	public static void main(String[] args) throws Exception {
		// Initializing variables
		int n = 0;
		String customerIdString = "";
		int customerId = 0;
		String firstName = "";
		String lastName = "";
		String crediCardNumberString = "";
		long creditCardNumber = 0;
		String creditCardExpirationDate = "";
		String creditCardPaymentAmountString = "";
		double creditCardPaymentAmount = 0.0;

		// Enter total number of customers
		String numberOfCustomers = JOptionPane
				.showInputDialog("Enter the number of customers in whole number, e.g., 3");
		try {
			// Convert string to int
			n = Integer.parseInt(numberOfCustomers);
			if (n == 0 || n < 0) {
				String errorMessage = "You entered an invalid value for number of customers: " + numberOfCustomers;
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}
		} catch (NumberFormatException nfe) {
			String errorMessage = "You entered an invalid value for number of customers: " + numberOfCustomers;
			JOptionPane.showMessageDialog(null, errorMessage);
			System.exit(0);
		}

		customers = new Customer[n];
		validating = new Validation();

		do {
			// Inputing Customer and Credit Card Information

			// Input Customer Id
			customerIdString = JOptionPane.showInputDialog("Enter your customer Id in whole number, e.g., 3 : ");

			try {
				customerId = Integer.parseInt(customerIdString);
				if (customerId == 0) {
					System.exit(0);
				}
				if (customerId < 0) {
					String errorMessage = "You entered an invalid customer Id: " + customerIdString;
					JOptionPane.showMessageDialog(null, errorMessage);
					System.exit(0);
				}
			} catch (NumberFormatException nfe) {
				String errorMessage = "You entered an invalid customer Id: " + customerIdString;
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}

			// Input First Name
			try {
				firstName = JOptionPane.showInputDialog("Enter your first name: ");
				if (firstName.isEmpty()) {
					String errorMessage = "You entered an invalid first name: " + firstName;
					JOptionPane.showMessageDialog(null, errorMessage);
					System.exit(0);
				}
			} catch (Exception e) {
				String errorMessage = "You entered an invalid first name: " + firstName;
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}

			// Input Last Name
			try {
				lastName = JOptionPane.showInputDialog("Enter your last name: ");
				if (lastName.isEmpty()) {
					String errorMessage = "You entered an invalid last name: " + lastName;
					JOptionPane.showMessageDialog(null, errorMessage);
					System.exit(0);
				}
			} catch (Exception e) {
				String errorMessage = "You entered an invalid last name: " + lastName;
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}

			// Input Credit Card Number
			crediCardNumberString = JOptionPane.showInputDialog("Enter your credit card number : ");

			try {
				creditCardNumber = Long.parseLong(crediCardNumberString);
				if (!isValidCard(crediCardNumberString)) {
					String errorMessage = "The credit card number you entered is invalid: " 
							+ crediCardNumberString;
					JOptionPane.showMessageDialog(null, errorMessage);
					System.exit(0);
				}
			} catch (NumberFormatException nfe) {
				String errorMessage = "You entered an invalid value for the credit card number: "
						+ crediCardNumberString;
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}

			// Input Credit Card Expiration date
			try {
				creditCardExpirationDate = JOptionPane
						.showInputDialog("Enter your credit card expiration date e.g., 02/2019 ");
				if (creditCardExpirationDate.isEmpty()) {
					String errorMessage = "You entered an invalid credit card expiration date "
							+ creditCardExpirationDate;
					JOptionPane.showMessageDialog(null, errorMessage);
					System.exit(0);
				}
				if (!creditCardExpirationDate.matches("([0-9]{2}/[0-9]{4})")) {
					String errorMessage = "You entered an invalid credit card expiration date format "
							+ creditCardExpirationDate;
					JOptionPane.showMessageDialog(null, errorMessage);
					System.exit(0);
				}
			} catch (Exception e) {
				String errorMessage = "You entered an invalid credit card expiration date: " + creditCardExpirationDate;
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}

			// Input Credit Card Payment Amount
			creditCardPaymentAmountString = JOptionPane.showInputDialog("Enter your credit card payment amount : ");

			try {
				creditCardPaymentAmount = Double.parseDouble(creditCardPaymentAmountString);
				if (creditCardPaymentAmount < 0) {
					String errorMessage = "You entered an invalid value for the credit card payment amount: "
							+ creditCardPaymentAmountString;
					JOptionPane.showMessageDialog(null, errorMessage);
					System.exit(0);
				}
			} catch (NumberFormatException nfe) {
				String errorMessage = "You entered an invalid value for the credit card payment amount: "
						+ creditCardPaymentAmountString;
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}

			if (Customer.getNoOfCustomers() < n) {
				// Instantiate Customer & CreditCard class objects
				CreditCard creditCard = new CreditCard(creditCardNumber, creditCardExpirationDate);
				Customer customer = new Customer(firstName, lastName, customerId, creditCardPaymentAmount, creditCard);
				// Add valid customer
				addCustomer(customer);
			} else {
				String errorMessage = "User Input exceeded the array size";
				JOptionPane.showMessageDialog(null, errorMessage);
				System.exit(0);
			}
		} while (Customer.getNoOfCustomers() < n);
	
		// Display Statistics - AVG, MAX, MIN customers payments.
		displayStat();
		// Stored only valid credit cards (hashed credit card number) with customer
		// information to a text file (Customer.txt)
		writeToFile();
		
	}
}
