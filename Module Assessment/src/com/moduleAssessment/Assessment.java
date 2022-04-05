package com.moduleAssessment;

import java.util.Scanner;

public class Assessment {

	private String ownerName;
	private String address;
	private int balanceAmount;
	private String createdDate;
	private String status;
	private int accType;
	Scanner sc = new Scanner(System.in);

	// getters and setters
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName() {
		System.out.println("Please enter your name: ");
		String ownerName = sc.next();
		this.ownerName = ownerName;
	}

	public String getAddress() {
		return address;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {

		this.balanceAmount = balanceAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	public String getCurrentDate() {
		return createdDate;
	}

	public void setCurrentDate() {
		long millis = System.currentTimeMillis();
		java.sql.Date mydate = new java.sql.Date(millis);
		String date = String.valueOf(mydate);
		this.createdDate = date;

	}

	// method to fetch address
	public void addressDetails() {
		System.out.println("please enter your city");
		String city = sc.next();
		System.out.println("please enter your state");
		String state = sc.next();
		System.out.println("please enter your pin");
		int pin = sc.nextInt();
		System.out.println("please enter house no");
		String houseNo = sc.next();
		System.out.println("please enter your street");
		String street = sc.next();

		this.address = city + "," + state + "," + pin + "," + houseNo + "," + street;
		setCurrentDate();
	}

	// Method to decide which type of account we want to create
	public void createAccType() {
		System.out.println("Please enter your choice to create account:\n  1.SAVINGS\n  2.DEMAT\n  3.CURRENT");
		int choice = sc.nextInt();
		setAccType(choice);
	}

	// Method to deposite money
	public void depositeAmount() {

		System.out.println("Enter the amount to be deposited");
		int amount = sc.nextInt();
		if (amount > 100) {
			this.balanceAmount = this.balanceAmount + amount;
			if (this.balanceAmount > 100) {
				this.status = "ACTIVE";
			}
			showBalance();
		} else {
			System.out.println("Minimum amount to be deposited should be more than 100 Rs. \n");
			depositeAmount();
		}
	}

	// Method to withdraw money
	public void withDrawAmount() {

		System.out.println("\nEnter the amount to withdraw:");
		int withDrawAmount = sc.nextInt();
		if (withDrawAmount >= this.balanceAmount) {
			System.out.println("Oopss!!You have entered the withdrawl amount greater than your balance");
			withDrawAmount();
		} else {
			System.out.println("Amount withdrawal successfully");
			this.balanceAmount = this.balanceAmount - withDrawAmount;
			if (this.balanceAmount < 100) {
				this.status = "INACTIVE";

			}
			showBalance();
		}

	}

	// Method to show balance
	public void showBalance() {
		System.out.println("Your current balance is:" + this.balanceAmount);
		System.out.println("Your account status is:" + this.status);
	}

	// Method to display account details
	public void displayAccountDetails() {
		System.out.println("\nThe account details are:" + "\n\n" + "OwnerName is:" + getOwnerName() + "\n"
				+ "Address is:" + getAddress() + "\n" + "Your balance amount is:" + getBalanceAmount() + "\n"
				+ "Your account created date is:" + getCurrentDate() + "\n" + "Your account status:" + getStatus());

	}

	// Method to close account
	public void closeAccount() {
		System.out.println("Do you want to close your account ? Y/N");
		Scanner sc = new Scanner(System.in);
		char choice = sc.next().charAt(0);
		if (choice == 'Y' || choice == 'N') {
			if (choice == 'Y') {
				this.status = "CLOSED";
				this.balanceAmount = 0;
				System.out.println("Your account is closed on " + this.getCurrentDate());
				this.displayAccountDetails();
			}
		} else {
			System.out.println("Please enter correct choice!\n");
			closeAccount();
		}
	}

//method to create new account
	public void createNewAccount() {
		this.createAccType();
		this.setOwnerName();
		this.depositeAmount();
		this.addressDetails();
	}

}
